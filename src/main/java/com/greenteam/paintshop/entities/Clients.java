package com.greenteam.paintshop.entities;

import com.greenteam.paintshop.dtos.ClientsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Clients(ClientsDto clientsDto) {
        if(clientsDto.getFirstName() != null) {
            this.firstName = clientsDto.getFirstName();
        }
        if(clientsDto.getLastName() != null) {
            this.lastName = clientsDto.getLastName();
        }
    }
}
