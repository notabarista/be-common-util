package org.notabarista.service.util;

import org.notabarista.entity.CanAccessDetails;
import org.notabarista.exception.InsufficientRightsException;
import org.springframework.stereotype.Service;

@Service
public interface ICheckAccessService {

	void checkAccess(CanAccessDetails accessDetails) throws InsufficientRightsException;

}
