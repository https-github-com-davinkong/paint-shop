package com.greenteam.paintshop.dtos;

import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.entities.Contractors;
import com.greenteam.paintshop.entities.Jobs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsDto implements Serializable {

    private Long id;
    private String jobTitle;
    private Instant date;
    private Set<Contractors> contractors;
//    private List<Product> products;
    private Clients client;

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
        if(jobs.getContractors() != null) {
            this.contractors = jobs.getContractors();
        }
        if(jobs.getClient() != null) {
            this.client = jobs.getClient();
        }
//        if(jobs.getProduct() != null) {
//            this.products = jobs.getProduct();
//        }

    }
}
