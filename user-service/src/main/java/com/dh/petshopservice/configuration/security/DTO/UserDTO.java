package com.dh.petshopservice.configuration.security.DTO;

import com.dh.petshopservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String idUser;
    private String username;
    private String email;
    private String firstName;

    public UserDTO() {
    }

    public UserDTO(String idUser, String username, String email, String firstName) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
    }

    public UserDTO(User user) {
    }
}
