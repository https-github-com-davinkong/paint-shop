package com.greenteam.paintshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greenteam.paintshop.dtos.ClientsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private Set<Jobs> jobsSet = new HashSet<>();

    public Clients(ClientsDto clientsDto) {
        if(clientsDto.getFirstName() != null) {
            this.firstName = clientsDto.getFirstName();
        }
        if(clientsDto.getLastName() != null) {
            this.lastName = clientsDto.getLastName();
        }
    }
}
