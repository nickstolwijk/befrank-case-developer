package com.befrank.casedeveloperjava.repositories.jpa;

import com.befrank.casedeveloperjava.domain.adapters.deelnemer.DeelnemerRepository;
import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryDefinition(domainClass = Deelnemer.class, idClass = Long.class )
public interface DeelnemerSpringDataRepository extends DeelnemerRepository {

}
