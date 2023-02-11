package be.technobel.fbrassine.sandwichspring.controller;

import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichUpdateForm;
import be.technobel.fbrassine.sandwichspring.service.IngredientService;
import be.technobel.fbrassine.sandwichspring.service.SandwichService;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;
    private final IngredientService ingredientService;

    public SandwichController(SandwichService sandwichService, IngredientService ingredientService) {
        this.sandwichService = sandwichService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("list", sandwichService.getAll());
        return "sandwich/display-all";
    }
    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model, @PathVariable("id") long id){
        model.addAttribute("sandwich", sandwichService.getOne(id));
        return "sandwich/display-one";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form", new SandwichInsertForm());
        model.addAttribute("list", ingredientService.getAll());
        return "sandwich/insert-form";
    }

    @PostMapping("/add")
    public String processInsertForm(
            Model model,
            @ModelAttribute("form") @Valid SandwichInsertForm form,
            BindingResult bindingResult){
        if(bindingResult.hasErrors() ) {
            model.addAttribute("list", ingredientService.getAll());
            return "sandwich/insert-form";
        }

        sandwichService.insert(form);
        return "redirect:/sandwich/all";
    }


    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id){
    SandwichUpdateForm form = new SandwichUpdateForm();
    SandwichDTO sandwich = sandwichService.getOne(id);
    form.setName( sandwich.getName() );
    form.setDescription( sandwich.getDescription() );
    form.setPrice( sandwich.getPrice() );
    model.addAttribute("form", form);
    model.addAttribute("id", id);
    model.addAttribute("list", ingredientService.getAll());
    return "sandwich/update-form";
    }
    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            Model model,
            @PathVariable Long id,
            @ModelAttribute("form") @Valid SandwichUpdateForm form,
            BindingResult bindingResult
    ){
        if( bindingResult.hasErrors() ){
            model.addAttribute("list", ingredientService.getAll());
            return "sandwich/update-form";
        }

        sandwichService.update(id, form);
        return "redirect:/sandwich/all";
    }
}
