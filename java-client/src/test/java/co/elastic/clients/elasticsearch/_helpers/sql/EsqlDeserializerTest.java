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

package co.elastic.clients.elasticsearch._helpers.sql;

import co.elastic.clients.elasticsearch._helpers.esql.EsqlDeserializer;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.endpoints.BinaryDataResponse;
import co.elastic.clients.transport.endpoints.BinaryResponse;
import co.elastic.clients.util.ByteArrayBinaryData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class EsqlDeserializerTest {

    String json = "{\n" +
        "  \"columns\": [\n" +
        "\t{\"name\": \"avg_salary\", \"type\": \"double\"},\n" +
        "\t{\"name\": \"lang\",   \t\"type\": \"keyword\"}\n" +
        "  ],\n" +
        "  \"values\": [\n" +
        "\t[43760.0, \"Spanish\"],\n" +
        "\t[48644.0, \"French\"],\n" +
        "\t[48832.0, \"German\"]\n" +
        "  ]\n" +
        "}\n";

    public static class Data {
        public double avg_salary;
        public String lang;
    }

    @Test
    public void testObjectDeserializer() throws IOException {

        EsqlDeserializer<Iterable<Data>> deser = EsqlDeserializer.objects(Data.class);

        ByteArrayBinaryData binData = new ByteArrayBinaryData(json.getBytes(StandardCharsets.UTF_8), "application/json");

        BinaryResponse binResponse = new BinaryDataResponse(binData);

        Iterable<Data> deserialize = deser.deserialize(binResponse, new JacksonJsonpMapper());

        for (Data d: deserialize) {
            System.out.println(d.lang + " " + d.avg_salary);
        }
    }
}
