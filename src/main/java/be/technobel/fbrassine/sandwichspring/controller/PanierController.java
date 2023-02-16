package be.technobel.fbrassine.sandwichspring.controller;

import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import be.technobel.fbrassine.sandwichspring.service.PanierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/panier")
public class PanierController {
    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping("/")
    public String displayPanier(Model model){
        model.addAttribute("sandwichs", panierService.getAllSand(1L));

        model.addAttribute("total", panierService.getOne(1L).getTotal());
        return "user/panier";
    }
    @PostMapping("/{id:[0-9]+}/buy")
    public String processBuyForm(Model model, @PathVariable Long id){
        panierService.addSand(id);
        return "redirect:/panier/";
    }
    @PostMapping("/{id:[0-9]+}/remove")
    public String processRemoveForm(Model model, @PathVariable Long id){
        panierService.delete(id);
        return "redirect:/panier/";
    }
}
