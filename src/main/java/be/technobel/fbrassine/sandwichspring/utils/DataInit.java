package be.technobel.fbrassine.sandwichspring.utils;

import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import be.technobel.fbrassine.sandwichspring.models.entity.User;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import be.technobel.fbrassine.sandwichspring.repository.IngredientRepository;
import be.technobel.fbrassine.sandwichspring.repository.SandwichRepository;
import be.technobel.fbrassine.sandwichspring.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
@Log4j2
public class DataInit implements InitializingBean {

    private final SandwichRepository sandwichRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;

    public DataInit(SandwichRepository sandwichRepository, UserRepository userRepository, IngredientRepository ingredientRepository) {
        this.sandwichRepository = sandwichRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("-- INITIALIZING DB DATA --");
        Sandwich s1 = new Sandwich();
        s1.setName("Pesto");
        s1.setPrice(4.5);
        s1.setDescription("Un vrai goût d'Italie !");

        Set<Ingredient> ingredients2 = new HashSet<>();

        Ingredient tomate = new Ingredient();
        tomate.setName("tomates");
        tomate = ingredientRepository.save(tomate);
        ingredients2.add(tomate);

        Ingredient pain = new Ingredient();
        pain.setName("pain");
        pain = ingredientRepository.save(pain);
        ingredients2.add(pain);

        Ingredient pesto = new Ingredient();
        pesto.setName("pesto");
        pesto = ingredientRepository.save(pesto);
        ingredients2.add(pesto);

        s1.setIngredients(ingredients2);

        Sandwich s2 = new Sandwich();
        s2.setName("Houmous");
        s2.setPrice(4.5);
        s2.setDescription("Fait avec amour et du babaganoush !");

        Set<Ingredient> ingredients = new HashSet<>();

        Ingredient houmous = new Ingredient();
        houmous.setName("houmous");
        houmous = ingredientRepository.save(houmous);
        ingredients.add(houmous);


        ingredients.add(pain);

        Ingredient babaganoush = new Ingredient();
        babaganoush.setName("babaganoush");
        babaganoush = ingredientRepository.save(babaganoush);
        ingredients.add(babaganoush);
        s2.setIngredients(ingredients);


        s1 = sandwichRepository.save(s1);
        s2 = sandwichRepository.save(s2);

        User user = new User();
        user.setEmail("user@customer.be");
        user.setPassword("pass");
        user.setRole("CUSTOMER");
        user.setFirstName("user");
        user.setLastName("customer");
        user.setBirthDate(LocalDate.now());

        user = userRepository.save(user);

        log.info("-- DATA INIT FINISHED --");
    }
}
