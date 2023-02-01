package com.greenteam.paintshop.dtos;

import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsDto implements Serializable {

    private Long id;
    private String jobTitle;
    private Instant date;
    private Set<ContractorsDto> contractorsDto = new HashSet<>();
    private List<ProductsDto> productsDto = new ArrayList<>();
    private ClientsDto clientDto;

    public JobsDto(Jobs jobs) {
        if(jobs.getId() != null) {
            this.id = jobs.getId();
        }
        if(jobs.getJobTitle() != null) {
            this.jobTitle = jobs.getJobTitle();
        }
        if(jobs.getDate() != null) {
            this.date = jobs.getDate();
        }
        this.clientDto = new ClientsDto();
        this.clientDto.setFirstName(jobs.getClient().getFirstName());
        this.clientDto.setId(jobs.getClient().getId());
        this.clientDto.setLastName(jobs.getClient().getLastName());

    }
}
