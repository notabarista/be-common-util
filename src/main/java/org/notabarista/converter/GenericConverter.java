package org.notabarista.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter<T, S> {

	T createFromSource(S source);

	S createFromTarget(T target);

	S updateSource(T target, S source);

	default List<T> createFromSources(final Collection<S> dtos) {
		return dtos.stream().map(this::createFromSource).collect(Collectors.toList());
	}
	
	default List<S> createFromTargets(final Collection<T> entities) {
		return entities.stream().map(this::createFromTarget).collect(Collectors.toList());
	}
}
