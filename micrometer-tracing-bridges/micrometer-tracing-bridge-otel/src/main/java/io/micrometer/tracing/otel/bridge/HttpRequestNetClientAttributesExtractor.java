/**
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.tracing.otel.bridge;

import io.micrometer.tracing.http.HttpRequest;
import io.micrometer.tracing.http.HttpResponse;
import io.micrometer.common.lang.Nullable;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;

/**
 * Extracts OpenTelemetry network semantic attributes value for client http spans.
 *
 * @author Nikita Salnikov-Tarnovski
 */
class HttpRequestNetClientAttributesExtractor implements NetClientAttributesGetter<HttpRequest, HttpResponse> {

    @Nullable
    @Override
    public String transport(HttpRequest httpRequest, @Nullable HttpResponse httpResponse) {
        return null;
    }

    @Nullable
    @Override
    public String peerName(HttpRequest httpRequest) {
        return null;
    }

    @Nullable
    @Override
    public Integer peerPort(HttpRequest httpRequest) {
        return httpRequest == null ? null : httpRequest.remotePort();
    }

    @Nullable
    @Override
    public String sockPeerAddr(HttpRequest httpRequest, @Nullable HttpResponse httpResponse) {
        return httpRequest == null ? null : httpRequest.remoteIp();
    }

    @Nullable
    @Override
    public Integer sockPeerPort(HttpRequest httpRequest, @Nullable HttpResponse httpResponse) {
        return httpRequest == null ? null : httpRequest.remotePort();
    }

}
