package com.greenteam.paintshop.dtos;

import com.greenteam.paintshop.entities.Contractors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractorsDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isAdmin;

    public ContractorsDto(Contractors contractors){
        if (contractors.getId() != null){
            this.id = contractors.getId();
        }
        if (contractors.getFirstName() != null){
            this.firstName = contractors.getFirstName();
        }
        if (contractors.getLastName() != null){
            this.lastName = contractors.getLastName();
        }
        if (contractors.getEmail() != null){
            this.email = contractors.getEmail();
        }
        if (contractors.getPassword() != null){
            this.password = contractors.getPassword();
        }
        if (contractors.getIsAdmin() != null){
            this.isAdmin = contractors.getIsAdmin();
        }
    }
}
