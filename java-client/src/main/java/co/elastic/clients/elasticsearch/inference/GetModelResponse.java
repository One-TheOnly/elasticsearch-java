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

package co.elastic.clients.elasticsearch.inference;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: inference.get_model.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#inference.get_model.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class GetModelResponse implements JsonpSerializable {
	private final List<ModelConfigContainer> models;

	// ---------------------------------------------------------------------------------------------

	private GetModelResponse(Builder builder) {

		this.models = ApiTypeHelper.unmodifiableRequired(builder.models, this, "models");

	}

	public static GetModelResponse of(Function<Builder, ObjectBuilder<GetModelResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code models}
	 */
	public final List<ModelConfigContainer> models() {
		return this.models;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (ApiTypeHelper.isDefined(this.models)) {
			generator.writeKey("models");
			generator.writeStartArray();
			for (ModelConfigContainer item0 : this.models) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetModelResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<GetModelResponse> {
		private List<ModelConfigContainer> models;

		/**
		 * Required - API name: {@code models}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>models</code>.
		 */
		public final Builder models(List<ModelConfigContainer> list) {
			this.models = _listAddAll(this.models, list);
			return this;
		}

		/**
		 * Required - API name: {@code models}
		 * <p>
		 * Adds one or more values to <code>models</code>.
		 */
		public final Builder models(ModelConfigContainer value, ModelConfigContainer... values) {
			this.models = _listAdd(this.models, value, values);
			return this;
		}

		/**
		 * Required - API name: {@code models}
		 * <p>
		 * Adds a value to <code>models</code> using a builder lambda.
		 */
		public final Builder models(Function<ModelConfigContainer.Builder, ObjectBuilder<ModelConfigContainer>> fn) {
			return models(fn.apply(new ModelConfigContainer.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetModelResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetModelResponse build() {
			_checkSingleUse();

			return new GetModelResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link GetModelResponse}
	 */
	public static final JsonpDeserializer<GetModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			GetModelResponse::setupGetModelResponseDeserializer);

	protected static void setupGetModelResponseDeserializer(ObjectDeserializer<GetModelResponse.Builder> op) {

		op.add(Builder::models, JsonpDeserializer.arrayDeserializer(ModelConfigContainer._DESERIALIZER), "models");

	}

}
