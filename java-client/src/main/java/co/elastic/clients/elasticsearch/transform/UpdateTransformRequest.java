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

package co.elastic.clients.elasticsearch.transform;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.elasticsearch.core.reindex.Destination;
import co.elastic.clients.elasticsearch.core.reindex.Source;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: transform.update_transform.Request
@JsonpDeserializable
public class UpdateTransformRequest extends RequestBase implements JsonpSerializable {
	@Nullable
	private final Boolean deferValidation;

	@Nullable
	private final String description;

	@Nullable
	private final Destination dest;

	@Nullable
	private final Time frequency;

	@Nullable
	private final RetentionPolicy retentionPolicy;

	@Nullable
	private final Settings settings;

	@Nullable
	private final Source source;

	@Nullable
	private final Sync sync;

	private final String transformId;

	// ---------------------------------------------------------------------------------------------

	private UpdateTransformRequest(Builder builder) {

		this.deferValidation = builder.deferValidation;
		this.description = builder.description;
		this.dest = builder.dest;
		this.frequency = builder.frequency;
		this.retentionPolicy = builder.retentionPolicy;
		this.settings = builder.settings;
		this.source = builder.source;
		this.sync = builder.sync;
		this.transformId = ModelTypeHelper.requireNonNull(builder.transformId, this, "transformId");

	}

	public static UpdateTransformRequest of(Function<Builder, ObjectBuilder<UpdateTransformRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * When true, deferrable validations are not run. This behavior may be desired
	 * if the source index does not exist until after the transform is created.
	 * <p>
	 * API name: {@code defer_validation}
	 */
	@Nullable
	public final Boolean deferValidation() {
		return this.deferValidation;
	}

	/**
	 * Free text description of the transform.
	 * <p>
	 * API name: {@code description}
	 */
	@Nullable
	public final String description() {
		return this.description;
	}

	/**
	 * The destination for the transform.
	 * <p>
	 * API name: {@code dest}
	 */
	@Nullable
	public final Destination dest() {
		return this.dest;
	}

	/**
	 * The interval between checks for changes in the source indices when the
	 * transform is running continuously. Also determines the retry interval in the
	 * event of transient failures while the transform is searching or indexing. The
	 * minimum value is 1s and the maximum is 1h.
	 * <p>
	 * API name: {@code frequency}
	 */
	@Nullable
	public final Time frequency() {
		return this.frequency;
	}

	/**
	 * Defines a retention policy for the transform. Data that meets the defined
	 * criteria is deleted from the destination index.
	 * <p>
	 * API name: {@code retention_policy}
	 */
	@Nullable
	public final RetentionPolicy retentionPolicy() {
		return this.retentionPolicy;
	}

	/**
	 * Defines optional transform settings.
	 * <p>
	 * API name: {@code settings}
	 */
	@Nullable
	public final Settings settings() {
		return this.settings;
	}

	/**
	 * The source of the data for the transform.
	 * <p>
	 * API name: {@code source}
	 */
	@Nullable
	public final Source source() {
		return this.source;
	}

	/**
	 * Defines the properties transforms require to run continuously.
	 * <p>
	 * API name: {@code sync}
	 */
	@Nullable
	public final Sync sync() {
		return this.sync;
	}

	/**
	 * Required - Identifier for the transform. This identifier can contain
	 * lowercase alphanumeric characters (a-z and 0-9), hyphens, and underscores. It
	 * must start and end with alphanumeric characters.
	 * <p>
	 * API name: {@code transform_id}
	 */
	public final String transformId() {
		return this.transformId;
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

		if (this.description != null) {
			generator.writeKey("description");
			generator.write(this.description);

		}
		if (this.dest != null) {
			generator.writeKey("dest");
			this.dest.serialize(generator, mapper);

		}
		if (this.frequency != null) {
			generator.writeKey("frequency");
			this.frequency.serialize(generator, mapper);

		}
		if (this.retentionPolicy != null) {
			generator.writeKey("retention_policy");
			this.retentionPolicy.serialize(generator, mapper);

		}
		if (this.settings != null) {
			generator.writeKey("settings");
			this.settings.serialize(generator, mapper);

		}
		if (this.source != null) {
			generator.writeKey("source");
			this.source.serialize(generator, mapper);

		}
		if (this.sync != null) {
			generator.writeKey("sync");
			this.sync.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link UpdateTransformRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UpdateTransformRequest> {
		@Nullable
		private Boolean deferValidation;

		@Nullable
		private String description;

		@Nullable
		private Destination dest;

		@Nullable
		private Time frequency;

		@Nullable
		private RetentionPolicy retentionPolicy;

		@Nullable
		private Settings settings;

		@Nullable
		private Source source;

		@Nullable
		private Sync sync;

		private String transformId;

		/**
		 * When true, deferrable validations are not run. This behavior may be desired
		 * if the source index does not exist until after the transform is created.
		 * <p>
		 * API name: {@code defer_validation}
		 */
		public final Builder deferValidation(@Nullable Boolean value) {
			this.deferValidation = value;
			return this;
		}

		/**
		 * Free text description of the transform.
		 * <p>
		 * API name: {@code description}
		 */
		public final Builder description(@Nullable String value) {
			this.description = value;
			return this;
		}

		/**
		 * The destination for the transform.
		 * <p>
		 * API name: {@code dest}
		 */
		public final Builder dest(@Nullable Destination value) {
			this.dest = value;
			return this;
		}

		/**
		 * The destination for the transform.
		 * <p>
		 * API name: {@code dest}
		 */
		public final Builder dest(Function<Destination.Builder, ObjectBuilder<Destination>> fn) {
			return this.dest(fn.apply(new Destination.Builder()).build());
		}

		/**
		 * The interval between checks for changes in the source indices when the
		 * transform is running continuously. Also determines the retry interval in the
		 * event of transient failures while the transform is searching or indexing. The
		 * minimum value is 1s and the maximum is 1h.
		 * <p>
		 * API name: {@code frequency}
		 */
		public final Builder frequency(@Nullable Time value) {
			this.frequency = value;
			return this;
		}

		/**
		 * The interval between checks for changes in the source indices when the
		 * transform is running continuously. Also determines the retry interval in the
		 * event of transient failures while the transform is searching or indexing. The
		 * minimum value is 1s and the maximum is 1h.
		 * <p>
		 * API name: {@code frequency}
		 */
		public final Builder frequency(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.frequency(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Defines a retention policy for the transform. Data that meets the defined
		 * criteria is deleted from the destination index.
		 * <p>
		 * API name: {@code retention_policy}
		 */
		public final Builder retentionPolicy(@Nullable RetentionPolicy value) {
			this.retentionPolicy = value;
			return this;
		}

		/**
		 * Defines a retention policy for the transform. Data that meets the defined
		 * criteria is deleted from the destination index.
		 * <p>
		 * API name: {@code retention_policy}
		 */
		public final Builder retentionPolicy(Function<RetentionPolicy.Builder, ObjectBuilder<RetentionPolicy>> fn) {
			return this.retentionPolicy(fn.apply(new RetentionPolicy.Builder()).build());
		}

		/**
		 * Defines optional transform settings.
		 * <p>
		 * API name: {@code settings}
		 */
		public final Builder settings(@Nullable Settings value) {
			this.settings = value;
			return this;
		}

		/**
		 * Defines optional transform settings.
		 * <p>
		 * API name: {@code settings}
		 */
		public final Builder settings(Function<Settings.Builder, ObjectBuilder<Settings>> fn) {
			return this.settings(fn.apply(new Settings.Builder()).build());
		}

		/**
		 * The source of the data for the transform.
		 * <p>
		 * API name: {@code source}
		 */
		public final Builder source(@Nullable Source value) {
			this.source = value;
			return this;
		}

		/**
		 * The source of the data for the transform.
		 * <p>
		 * API name: {@code source}
		 */
		public final Builder source(Function<Source.Builder, ObjectBuilder<Source>> fn) {
			return this.source(fn.apply(new Source.Builder()).build());
		}

		/**
		 * Defines the properties transforms require to run continuously.
		 * <p>
		 * API name: {@code sync}
		 */
		public final Builder sync(@Nullable Sync value) {
			this.sync = value;
			return this;
		}

		/**
		 * Defines the properties transforms require to run continuously.
		 * <p>
		 * API name: {@code sync}
		 */
		public final Builder sync(Function<Sync.Builder, ObjectBuilder<Sync>> fn) {
			return this.sync(fn.apply(new Sync.Builder()).build());
		}

		/**
		 * Required - Identifier for the transform. This identifier can contain
		 * lowercase alphanumeric characters (a-z and 0-9), hyphens, and underscores. It
		 * must start and end with alphanumeric characters.
		 * <p>
		 * API name: {@code transform_id}
		 */
		public final Builder transformId(String value) {
			this.transformId = value;
			return this;
		}

		/**
		 * Builds a {@link UpdateTransformRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public UpdateTransformRequest build() {
			_checkSingleUse();

			return new UpdateTransformRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link UpdateTransformRequest}
	 */
	public static final JsonpDeserializer<UpdateTransformRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, UpdateTransformRequest::setupUpdateTransformRequestDeserializer);

	protected static void setupUpdateTransformRequestDeserializer(
			ObjectDeserializer<UpdateTransformRequest.Builder> op) {

		op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
		op.add(Builder::dest, Destination._DESERIALIZER, "dest");
		op.add(Builder::frequency, Time._DESERIALIZER, "frequency");
		op.add(Builder::retentionPolicy, RetentionPolicy._DESERIALIZER, "retention_policy");
		op.add(Builder::settings, Settings._DESERIALIZER, "settings");
		op.add(Builder::source, Source._DESERIALIZER, "source");
		op.add(Builder::sync, Sync._DESERIALIZER, "sync");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code transform.update_transform}".
	 */
	public static final Endpoint<UpdateTransformRequest, UpdateTransformResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/transform.update_transform",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				final int _transformId = 1 << 0;

				int propsSet = 0;

				propsSet |= _transformId;

				if (propsSet == (_transformId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_transform");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.transformId, buf);
					buf.append("/_update");
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.deferValidation != null) {
					params.put("defer_validation", String.valueOf(request.deferValidation));
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, UpdateTransformResponse._DESERIALIZER);
}
