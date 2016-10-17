package de.escalon.hypermedia.affordance;

import org.springframework.hateoas.Identifiable;
import org.springframework.web.bind.annotation.RequestMethod;

import de.escalon.hypermedia.spring.AffordanceBuilder;

public interface EntityAffordances {

	AffordanceBuilder[] affordanceForSingleResource(final Identifiable<?> entity);

	AffordanceBuilder[] affordanceForSingleResource(final Identifiable<?> entity, final RequestMethod... methods);

	AffordanceBuilder[] affordanceToCollectionResource(final Class<?> type);
}
