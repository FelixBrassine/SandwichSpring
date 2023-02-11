package be.technobel.fbrassine.sandwichspring.service;

import be.technobel.fbrassine.sandwichspring.models.form.UserInsertForm;

import java.time.LocalDate;

public interface UserService {

    void insert(UserInsertForm form);

}
