package fr.formation.eni.beerfactory.ihm;

import fr.formation.eni.beerfactory.bll.BreweryService;
import fr.formation.eni.beerfactory.bll.BreweryServiceException;
import fr.formation.eni.beerfactory.bo.Brewery;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brewery")
public class BreweryController {

    @Autowired
    BreweryService breweryService;

    @GetMapping
    public String init(Brewery brewery) {
        return "brewery";
    }

    @PostMapping
    public String valid(@Valid Brewery brewery, BindingResult errors, Model model){
        if (errors.hasErrors()) {
            return "brewery";
        }
        try {
            breweryService.addBrewery(brewery);
        } catch (BreweryServiceException e) {
            //message global
            ObjectError error = new ObjectError("global", e.getMessage());
            errors.addError(error);
            //message spécifique à un champ
            FieldError error2 = new FieldError("brewery", "nom", e.getMessage());
            errors.addError(error2);
            return "brewery";
        }
        return "redirect:/brewery";
    }
}
