package ccbill.training.sfgpetclinic.repositories;

import ccbill.training.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
