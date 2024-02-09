/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.elastic.clients.elasticsearch._helpers.esql;

import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch.esql.QueryRequest;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpMappingException;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.endpoints.BinaryResponse;
import jakarta.json.stream.JsonParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EsqlHelper {

    public <T> T query(ElasticsearchTransport transport, EsqlDeserializer<T> deserializer, String query, FieldValue... params)
        throws IOException {

        // FIXME: add support for filter

        QueryRequest q = QueryRequest.of(esql -> esql
            .format(deserializer.format())
            .columnar(deserializer.columnar())
            .query(query)
            .params(Arrays.asList(params))
        );

        BinaryResponse response = transport.performRequest(q, QueryRequest._ENDPOINT, null);
        return deserializer.deserialize(response, transport.jsonpMapper());
    }

    /**
     * Reads the header of an ES|QL response, moving the parser at the beginning of the first value row.
     * The caller can then read row arrays until finding an end array that closes the top-level array.
     */
    static EsqlMetadata readHeader(JsonParser parser, JsonpMapper mapper) {
        JsonpUtils.expectNextEvent(parser, JsonParser.Event.START_OBJECT);
        JsonpUtils.expectNextEvent(parser, JsonParser.Event.KEY_NAME);

        if (!"columns".equals(parser.getString())) {
            throw new JsonpMappingException("Expecting a 'columns' property, but found '" + parser.getString() + "'", parser.getLocation());
        }

        List<EsqlMetadata.EsqlColumn> columns = JsonpDeserializer
            .arrayDeserializer(JsonpDeserializer.<EsqlMetadata.EsqlColumn>of(EsqlMetadata.EsqlColumn.class))
            .deserialize(parser, mapper);

        EsqlMetadata result = new EsqlMetadata();
        result.columns = columns;

        JsonpUtils.expectNextEvent(parser, JsonParser.Event.KEY_NAME);

        if (!"values".equals(parser.getString())) {
            throw new JsonpMappingException("Expecting a 'values' property, but found '" + parser.getString() + "'", parser.getLocation());
        }

        JsonpUtils.expectNextEvent(parser, JsonParser.Event.START_ARRAY);

        return result;
    }

    static void readFooter(JsonParser parser) {
        JsonpUtils.expectNextEvent(parser, JsonParser.Event.END_OBJECT);
    }
}
