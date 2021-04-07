package ccbill.training.sfgpetclinic.repositories;

import ccbill.training.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
