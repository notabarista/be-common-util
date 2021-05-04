package org.notabarista.service.util;

import org.notabarista.entity.response.Response;
import org.notabarista.exception.AbstractNotabaristaException;
import org.notabarista.service.util.enums.MicroService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.net.URI;
import java.util.Map;

public interface IBackendRequestService {

	URI getServiceUri(String microServiceName) throws AbstractNotabaristaException;

	<T extends Object> Response<T> executePost(MicroService microService, String uri, Object object,
			ParameterizedTypeReference<Response<T>> parameterizedTypeReference, Map<String, String> customHeaders) throws AbstractNotabaristaException;

	<T extends Object> Response<T> executeGet(MicroService microService, String uri, Object object,
			ParameterizedTypeReference<Response<T>> parameterizedTypeReference, Map<String, String> customHeaders) throws AbstractNotabaristaException;

	<T extends Object> Response<T> executeRequest(String uri, HttpMethod httpMethod, Object object,
			ParameterizedTypeReference<Response<T>> parameterizedTypeReference, Map<String, String> customHeaders);

	<T extends Object> Response<T> executePut(MicroService microService, String uri, Object object,
			ParameterizedTypeReference<Response<T>> parameterizedTypeReference, Map<String, String> customHeaders) throws AbstractNotabaristaException;
	
	<T extends Object> Response<T> executePatch(MicroService microService, String uri, Object object,
			ParameterizedTypeReference<Response<T>> parameterizedTypeReference, Map<String, String> customHeaders) throws AbstractNotabaristaException;

}
