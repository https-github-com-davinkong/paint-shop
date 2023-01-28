package com.greenteam.paintshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greenteam.paintshop.dtos.ContractorsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contractors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contractors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;


    @ManyToOne
    @JsonBackReference
    private Jobs jobs;
    public Contractors(ContractorsDto contractorsDto){
        if (contractorsDto.getFirstName() != null){
            this.firstName = contractorsDto.getFirstName();
        }
        if (contractorsDto.getLastName() != null){
            this.lastName = contractorsDto.getLastName();
        }
        if (contractorsDto.getEmail() != null){
            this.email = contractorsDto.getEmail();
        }
        if (contractorsDto.getPassword() != null){
            this.password = contractorsDto.getPassword();
        }
        if (contractorsDto.getIsAdmin() != null){
            this.isAdmin = contractorsDto.getIsAdmin();
        }

    }

}
