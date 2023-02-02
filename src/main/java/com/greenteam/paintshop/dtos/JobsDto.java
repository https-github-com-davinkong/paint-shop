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
    private ContractorsDto contractorsDto;
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

        this.contractorsDto = new ContractorsDto();
        this.contractorsDto.setFirstName(jobs.getContractors().getFirstName());
        this.contractorsDto.setId(jobs.getContractors().getId());
        this.contractorsDto.setLastName(jobs.getContractors().getLastName());
        this.contractorsDto.setEmail(jobs.getContractors().getEmail());
        this.contractorsDto.setPassword(jobs.getContractors().getPassword());
        this.contractorsDto.setIsAdmin(jobs.getContractors().getIsAdmin());
//        this.contractorsDto = new HashSet<>();
//        System.out.println("GET CONTRACTOR: "+jobs.getContractors().toString());
//        for (Contractors contractor : jobs.getContractors()) {
//            System.out.println("THIS.CONTRACTORSDTO: "+this.contractorsDto);
//            ContractorsDto contractorDto = new ContractorsDto();
//            contractorDto.setFirstName(contractor.getFirstName());
//            contractorDto.setId(contractor.getId());
//            contractorDto.setLastName(contractor.getLastName());
//            contractorDto.setEmail(contractor.getEmail());
//            contractorDto.setPassword(contractor.getPassword());
//            contractorDto.setIsAdmin(contractor.getIsAdmin());
//            this.contractorsDto.add(contractorDto);
//            System.out.println("END OF FOR LOOP: "+this.contractorsDto);
//        }
//
//        System.out.println("----------------------------------------------");
//        System.out.println("CONTRACTORS DTO: " + contractorsDto);


    }
}
