package ccbill.training.sfgpetclinic.repositories;

import ccbill.training.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
