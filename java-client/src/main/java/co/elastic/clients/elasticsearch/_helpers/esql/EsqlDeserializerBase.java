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

import co.elastic.clients.json.BufferingJsonGenerator;
import co.elastic.clients.json.BufferingJsonpMapper;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.endpoints.BinaryResponse;
import jakarta.json.stream.JsonParser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EsqlDeserializerBase {

    static class ObjectList<T> implements EsqlDeserializer<Iterable<T>> {

        private final Type type;

        public ObjectList(Class<T> clazz) {
            this.type = clazz;
        }

        public ObjectList(Type type) {
            this.type = type;
        }

        @Override
        public String format() {
            return "json";
        }

        @Override
        public boolean columnar() {
            return false;
        }

        @Override
        public Iterable<T> deserialize(BinaryResponse response, JsonpMapper mapper) throws IOException {
            if (!(mapper instanceof JacksonJsonpMapper)) {
                throw new IllegalArgumentException("ES|QL object mapping currently only works with JacksonJsonpMapper");
            }

            JsonParser parser = mapper.jsonProvider().createParser(response.content());

            List<EsqlMetadata.EsqlColumn> columns = EsqlHelper.readHeader(parser, mapper).columns;

            List<T> results = new ArrayList<>();
            JsonParser.Event event;

            while ((event = parser.next()) != JsonParser.Event.END_ARRAY) {
                // Start of row
                JsonpUtils.expectEvent(parser, JsonParser.Event.START_ARRAY, event);

                // FIXME: add a second implementation not requiring a buffering parser
                results.add(parseRow(columns, parser, mapper));

                // End of row
                JsonpUtils.expectNextEvent(parser, JsonParser.Event.END_ARRAY);
            }

            EsqlHelper.readFooter(parser);

            return results;
        }

        private T parseRow(List<EsqlMetadata.EsqlColumn> columns, JsonParser parser, JsonpMapper mapper) {
            BufferingJsonGenerator bjson = ((BufferingJsonpMapper)mapper).createBufferingGenerator();

            bjson.writeStartObject();
            for (EsqlMetadata.EsqlColumn column: columns) {
                bjson.writeKey(column.name);
                JsonpUtils.copy(parser, bjson);
            }
            bjson.writeEnd();

            return mapper.deserialize(bjson.getParser(), type);
        }
    }
}
