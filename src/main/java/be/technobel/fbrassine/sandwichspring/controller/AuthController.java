package be.technobel.fbrassine.sandwichspring.controller;

import be.technobel.fbrassine.sandwichspring.models.form.UserInsertForm;
import be.technobel.fbrassine.sandwichspring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/subscribe")
    public String insertForm(@ModelAttribute("form") UserInsertForm userInsertForm){
        return "user/subscribe";
    }
    @PostMapping("/subscribe")
    public String processInsertForm(
            @ModelAttribute("form") @Valid UserInsertForm form,
            BindingResult bindingResult){
        if( bindingResult.hasErrors() ){
            form.setPassword(null);
            return "user/subscribe";
        }
        userService.insert(form);
        return "redirect:/";
    }
}
