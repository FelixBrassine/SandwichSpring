package be.technobel.fbrassine.sandwichspring.controller;

import be.technobel.fbrassine.sandwichspring.models.form.PanierInsertForm;
import be.technobel.fbrassine.sandwichspring.service.PanierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/panier")
public class PanierController {
    @GetMapping("/all")
    public String displayPanier(Model model){
//        model.addAttribute("panier", panierService.g);
        return "user/panier";
    }
}
