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

import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.transport.endpoints.BinaryResponse;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * A deserializer for ES|QL responses.
 */
public interface EsqlDeserializer<Result> {
    /**
     * ESQL result format this deserializer accepts (text, csv, json, arrow, etc.)
     */
    String format();

    /**
     * For JSON results, whether the result should be organized in rows or columns
     */
    boolean columnar();

    /**
     * Deserialize the raw http response returned by the server
     */
    Result deserialize(BinaryResponse response, JsonpMapper mapper) throws IOException;

    //---------------------------------------------------------------------------------------------
    // Implementations
    //---------------------------------------------------------------------------------------------

    /**
     * Creates an ES|QL deserializer that returns a collection of objects.
     */
    static <T> EsqlDeserializer<Iterable<T>> objects(Class<T> clazz) {
        return new EsqlDeserializerBase.ObjectList<>(clazz);
    }

    /**
     * Creates an ES|QL deserializer that returns a collection of objects.
     */
    static <T> EsqlDeserializer<Iterable<T>> objects(Type type) {
        return new EsqlDeserializerBase.ObjectList<>(type);
    }
}
