package org.notabarista.service.util.impl;

import org.apache.commons.lang.StringUtils;
import org.notabarista.entity.CanAccessDetails;
import org.notabarista.entity.response.Response;
import org.notabarista.exception.AbstractNotabaristaException;
import org.notabarista.exception.InsufficientRightsException;
import org.notabarista.service.util.ICheckAccessService;
import org.notabarista.service.util.enums.MicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CheckAccessService implements ICheckAccessService {

	@Autowired
	private BackendRequestService backendRequestService;

	@Override
	public void checkAccess(CanAccessDetails accessDetails) throws InsufficientRightsException {

		if (accessDetails == null || StringUtils.isBlank(accessDetails.getAction())
				|| StringUtils.isBlank(accessDetails.getUid())
				|| StringUtils.isBlank(accessDetails.getMicroserviceName())) {
			throw new InsufficientRightsException();
		}

		try {
			Response<Boolean> response = backendRequestService.executePost(MicroService.USER_MANAGEMENT_SERVICE,
					"/user/check-access/", accessDetails, new ParameterizedTypeReference<Response<Boolean>>() {
					});

			if (CollectionUtils.isEmpty(response.getData()) || !response.getData().get(0)) {
				log.trace("Insufficient rights for: " + accessDetails);
				throw new InsufficientRightsException();
			}

		} catch (AbstractNotabaristaException e) {
			log.error("Could not check access from user service for: " + accessDetails);
			throw new InsufficientRightsException();
		}
	}

}
