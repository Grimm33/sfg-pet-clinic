package ccbill.training.sfgpetclinic.model;

public class PetType extends BaseEntity{

    private String name;

    //region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
