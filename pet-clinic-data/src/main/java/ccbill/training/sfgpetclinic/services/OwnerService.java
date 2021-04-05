package ccbill.training.sfgpetclinic.services;

import ccbill.training.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
