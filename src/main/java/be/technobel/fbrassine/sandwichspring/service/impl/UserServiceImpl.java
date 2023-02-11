package be.technobel.fbrassine.sandwichspring.service.impl;

import be.technobel.fbrassine.sandwichspring.models.entity.User;
import be.technobel.fbrassine.sandwichspring.models.form.UserInsertForm;
import be.technobel.fbrassine.sandwichspring.repository.UserRepository;
import be.technobel.fbrassine.sandwichspring.service.UserService;
import be.technobel.fbrassine.sandwichspring.service.mapper.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void insert(UserInsertForm form) {
        if (userRepository.existsByEmail(form.getEmail())){
            throw new IllegalArgumentException("the specified email is already taken");
        }else if (form == null){
            throw new IllegalArgumentException("form should be not null");
        }else{
            User entity = mapper.toEntity(form);
            entity.setRole("CUSTOMER");
            userRepository.save(entity);
        }
    }

}
