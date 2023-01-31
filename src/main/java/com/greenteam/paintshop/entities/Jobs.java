package com.greenteam.paintshop.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greenteam.paintshop.dtos.JobsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.Set;

@Entity
@Table (name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String jobTitle;

    @Column
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;


//    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
//    private List<Product> products;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private Set<Contractors> contractors;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    public Jobs(JobsDto jobsDto) {
        if(jobsDto.getJobTitle() != null) {
            this.jobTitle = jobsDto.getJobTitle();
        }
        if(jobsDto.getDate() != null) {
            this.date = jobsDto.getDate();
        }
        if(jobsDto.getClient() != null) {
            this.client = jobsDto.getClient();
        }
    }
}
