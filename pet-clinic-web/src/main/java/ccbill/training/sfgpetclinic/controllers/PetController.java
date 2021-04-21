package ccbill.training.sfgpetclinic.controllers;

import ccbill.training.sfgpetclinic.model.Owner;
import ccbill.training.sfgpetclinic.model.PetType;
import ccbill.training.sfgpetclinic.services.OwnerService;
import ccbill.training.sfgpetclinic.services.PetService;
import ccbill.training.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping({"/owners/{ownerId}", "/owners/{ownerId}/"})
public class PetController {

    public static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM  = "pets/createOrUpdateForm";
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

}