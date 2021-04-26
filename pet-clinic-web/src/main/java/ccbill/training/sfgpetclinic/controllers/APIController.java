package ccbill.training.sfgpetclinic.controllers;

import ccbill.training.sfgpetclinic.model.Vet;
import ccbill.training.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping("/api")
@Controller
public class APIController {

    private final VetService vetService;

    public APIController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("vets")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
