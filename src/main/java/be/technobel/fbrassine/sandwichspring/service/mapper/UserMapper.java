package be.technobel.fbrassine.sandwichspring.service.mapper;


import be.technobel.fbrassine.sandwichspring.models.dto.UserDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.User;
import be.technobel.fbrassine.sandwichspring.models.form.UserInsertForm;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDTO toDto(User entity){

        if (entity == null){
            return null;
        }else {
            return UserDTO.builder()
                    .id(entity.getId())
                    .email(entity.getEmail())
                    .password(entity.getPassword())
                    .role(entity.getRole())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .birthDate(entity.getBirthDate())
                    .enabled(entity.getEnabled())
                    .blackListed(entity.getBlackListed())
                    .build();
        }
    }
    public User toEntity(UserInsertForm form){
        if (form == null){
            return null;
        }else{
            User entity = new User();
            entity.setEmail(form.getEmail());
            entity.setPassword(form.getPassword());
            entity.setFirstName(form.getFirstName());
            entity.setLastName(form.getLastName());
            entity.setBirthDate(form.getBirthDate());
            return entity;
        }
    }
}
