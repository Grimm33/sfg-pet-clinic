package ccbill.training.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    //use Boxed Types because they can be null. It is also recommended by Hibernate to use Boxed Types
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
