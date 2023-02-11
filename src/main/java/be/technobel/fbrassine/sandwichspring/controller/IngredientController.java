package be.technobel.fbrassine.sandwichspring.controller;

import be.technobel.fbrassine.sandwichspring.models.dto.IngredientDTO;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientUpdateForm;
import be.technobel.fbrassine.sandwichspring.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("list", ingredientService.getAll());
        return "ingredient/display-all";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form", new IngredientInsertForm());
        return "ingredient/insert-form";
    }
    @PostMapping("/add")
    public String processInsertForm(
            @ModelAttribute("form") @Valid IngredientInsertForm form,
            BindingResult bindingResult){
        if(bindingResult.hasErrors() ) {
            return "sandwich/insert-form";
        }
        ingredientService.insert(form);
        return "redirect:/ingredient/all";
    }
    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id){
        IngredientUpdateForm form = new IngredientUpdateForm();
        IngredientDTO ingredient = ingredientService.getOne(id);
        form.setName( ingredient.getName() );
        model.addAttribute("form", form);
        model.addAttribute("id", id);
        return "ingredient/update-form";
    }

    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            @PathVariable long id,
            @ModelAttribute("form") @Valid IngredientUpdateForm form,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors() ) {
            return "sandwich/update-form";
        }
        ingredientService.update(id, form);
        return "redirect:/ingredient/all";
    }

}
