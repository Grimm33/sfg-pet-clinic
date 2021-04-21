package ccbill.training.sfgpetclinic.controllers;

import ccbill.training.sfgpetclinic.model.Pet;
import ccbill.training.sfgpetclinic.model.Visit;
import ccbill.training.sfgpetclinic.services.PetService;
import ccbill.training.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {
    public static final String VIEWS_VISITS_CREATE_OR_UPDATE_FORM  = "pets/createOrUpdateVisitForm";

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model){
        Pet pet = petService.findById(petId);

        model.addAttribute("pet", pet);

        Visit visit = Visit.builder().build();
        pet.getVisits().add(visit);
        visit.setPet(pet);

        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model){
        return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result, @PathVariable Long ownerId){
        if(result.hasErrors()) return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;

        visitService.save(visit);
        return "redirect:/owners/" + ownerId;
    }
}
