package org.notabarista.service.util.enums;

public enum MicroService {
	USER_MANAGEMENT_SERVICE("USER-MANAGEMENT-SERVICE"), GATEWAY_SERVICE("GATEWAY-SERVICE"),
	BE_EC_CATALOG_SERVICE("BE-EC-CATALOG-SERVICE");

	private String microserviceName;

	private MicroService(String microserviceName) {
		this.microserviceName = microserviceName;
	}
	
	public String getMicroserviceName() {
		return this.microserviceName;
	}
}
