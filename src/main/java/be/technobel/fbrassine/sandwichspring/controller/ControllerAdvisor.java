package be.technobel.fbrassine.sandwichspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import be.technobel.fbrassine.sandwichspring.exceptions.NotFoundException;
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler
    public String handle(NotFoundException ex, Model model, HttpServletRequest req){
        model.addAttribute("ex", ex);
        model.addAttribute("previous", req.getHeader("referer"));
        return"errors/not-found";
    }
}
