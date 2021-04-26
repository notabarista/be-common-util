package org.notabarista.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CanAccessDetails {

	private String uid;
	private String action;
	private String resource;
	private String microserviceName;
	
}
