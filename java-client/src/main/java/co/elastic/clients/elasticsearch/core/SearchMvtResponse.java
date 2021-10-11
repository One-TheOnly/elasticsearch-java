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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.core;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.search_mvt.Response
@JsonpDeserializable
public final class SearchMvtResponse implements JsonpSerializable {
	private final JsonValue valueBody;

	// ---------------------------------------------------------------------------------------------

	public SearchMvtResponse(Builder builder) {

		this.valueBody = Objects.requireNonNull(builder.valueBody, "_value_body");

	}

	public SearchMvtResponse(Function<Builder, Builder> fn) {
		this(fn.apply(new Builder()));
	}

	/**
	 * Required - Response value.
	 * <p>
	 * API name: {@code _value_body}
	 */
	public JsonValue valueBody() {
		return this.valueBody;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.write(this.valueBody);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SearchMvtResponse}.
	 */
	public static class Builder implements ObjectBuilder<SearchMvtResponse> {
		private JsonValue valueBody;

		/**
		 * Required - Response value.
		 * <p>
		 * API name: {@code _value_body}
		 */
		public Builder valueBody(JsonValue value) {
			this.valueBody = value;
			return this;
		}

		/**
		 * Builds a {@link SearchMvtResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SearchMvtResponse build() {

			return new SearchMvtResponse(this);
		}
	}

	public static final JsonpDeserializer<SearchMvtResponse> _DESERIALIZER = createSearchMvtResponseDeserializer();
	protected static JsonpDeserializer<SearchMvtResponse> createSearchMvtResponseDeserializer() {

		JsonpDeserializer<JsonValue> valueDeserializer = JsonpDeserializer.jsonValueDeserializer();

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.valueBody(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}