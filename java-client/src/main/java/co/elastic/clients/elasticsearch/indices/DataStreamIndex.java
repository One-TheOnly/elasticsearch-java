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

package co.elastic.clients.elasticsearch.indices;

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
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: indices._types.DataStreamIndex

/**
 *
 * @see <a href="../doc-files/api-spec.html#indices._types.DataStreamIndex">API
 *      specification</a>
 */
@JsonpDeserializable
public class DataStreamIndex implements JsonpSerializable {
	private final String indexName;

	private final String indexUuid;

	@Nullable
	private final String ilmPolicy;

	private final ManagedBy managedBy;

	private final boolean preferIlm;

	// ---------------------------------------------------------------------------------------------

	private DataStreamIndex(Builder builder) {

		this.indexName = ApiTypeHelper.requireNonNull(builder.indexName, this, "indexName");
		this.indexUuid = ApiTypeHelper.requireNonNull(builder.indexUuid, this, "indexUuid");
		this.ilmPolicy = builder.ilmPolicy;
		this.managedBy = ApiTypeHelper.requireNonNull(builder.managedBy, this, "managedBy");
		this.preferIlm = ApiTypeHelper.requireNonNull(builder.preferIlm, this, "preferIlm");

	}

	public static DataStreamIndex of(Function<Builder, ObjectBuilder<DataStreamIndex>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Name of the backing index.
	 * <p>
	 * API name: {@code index_name}
	 */
	public final String indexName() {
		return this.indexName;
	}

	/**
	 * Required - Universally unique identifier (UUID) for the index.
	 * <p>
	 * API name: {@code index_uuid}
	 */
	public final String indexUuid() {
		return this.indexUuid;
	}

	/**
	 * Name of the current ILM lifecycle policy configured for this backing index.
	 * <p>
	 * API name: {@code ilm_policy}
	 */
	@Nullable
	public final String ilmPolicy() {
		return this.ilmPolicy;
	}

	/**
	 * Required - Name of the lifecycle system that's currently managing this
	 * backing index.
	 * <p>
	 * API name: {@code managed_by}
	 */
	public final ManagedBy managedBy() {
		return this.managedBy;
	}

	/**
	 * Required - Indicates if ILM should take precedence over DSL in case both are
	 * configured to manage this index.
	 * <p>
	 * API name: {@code prefer_ilm}
	 */
	public final boolean preferIlm() {
		return this.preferIlm;
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

		generator.writeKey("index_name");
		generator.write(this.indexName);

		generator.writeKey("index_uuid");
		generator.write(this.indexUuid);

		if (this.ilmPolicy != null) {
			generator.writeKey("ilm_policy");
			generator.write(this.ilmPolicy);

		}
		generator.writeKey("managed_by");
		this.managedBy.serialize(generator, mapper);
		generator.writeKey("prefer_ilm");
		generator.write(this.preferIlm);

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DataStreamIndex}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<DataStreamIndex> {
		private String indexName;

		private String indexUuid;

		@Nullable
		private String ilmPolicy;

		private ManagedBy managedBy;

		private Boolean preferIlm;

		/**
		 * Required - Name of the backing index.
		 * <p>
		 * API name: {@code index_name}
		 */
		public final Builder indexName(String value) {
			this.indexName = value;
			return this;
		}

		/**
		 * Required - Universally unique identifier (UUID) for the index.
		 * <p>
		 * API name: {@code index_uuid}
		 */
		public final Builder indexUuid(String value) {
			this.indexUuid = value;
			return this;
		}

		/**
		 * Name of the current ILM lifecycle policy configured for this backing index.
		 * <p>
		 * API name: {@code ilm_policy}
		 */
		public final Builder ilmPolicy(@Nullable String value) {
			this.ilmPolicy = value;
			return this;
		}

		/**
		 * Required - Name of the lifecycle system that's currently managing this
		 * backing index.
		 * <p>
		 * API name: {@code managed_by}
		 */
		public final Builder managedBy(ManagedBy value) {
			this.managedBy = value;
			return this;
		}

		/**
		 * Required - Indicates if ILM should take precedence over DSL in case both are
		 * configured to manage this index.
		 * <p>
		 * API name: {@code prefer_ilm}
		 */
		public final Builder preferIlm(boolean value) {
			this.preferIlm = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link DataStreamIndex}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DataStreamIndex build() {
			_checkSingleUse();

			return new DataStreamIndex(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DataStreamIndex}
	 */
	public static final JsonpDeserializer<DataStreamIndex> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			DataStreamIndex::setupDataStreamIndexDeserializer);

	protected static void setupDataStreamIndexDeserializer(ObjectDeserializer<DataStreamIndex.Builder> op) {

		op.add(Builder::indexName, JsonpDeserializer.stringDeserializer(), "index_name");
		op.add(Builder::indexUuid, JsonpDeserializer.stringDeserializer(), "index_uuid");
		op.add(Builder::ilmPolicy, JsonpDeserializer.stringDeserializer(), "ilm_policy");
		op.add(Builder::managedBy, ManagedBy._DESERIALIZER, "managed_by");
		op.add(Builder::preferIlm, JsonpDeserializer.booleanDeserializer(), "prefer_ilm");

	}

}
