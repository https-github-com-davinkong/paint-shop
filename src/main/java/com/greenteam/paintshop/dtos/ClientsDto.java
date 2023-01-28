package com.greenteam.paintshop.dtos;

import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.entities.Jobs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<JobsDto> jobsDtoSet = new HashSet<>();

    public ClientsDto(Clients clients){
        if (clients.getId() != null){
            this.id = clients.getId();
        }
        if (clients.getFirstName() != null){
            this.firstName = clients.getFirstName();
        }
        if (clients.getLastName() != null){
            this.lastName = clients.getLastName();
        }
    }
}
