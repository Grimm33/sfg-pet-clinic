package ccbill.training.sfgpetclinic.repositories;

import ccbill.training.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
