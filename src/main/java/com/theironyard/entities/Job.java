package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by ericweidman on 3/11/16.
 */
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String companyName;
    @Column(nullable = false)
    String url;
    @Column(nullable = false)
    String dateApplied;

    @ManyToOne
    User user;

    public Job() {
    }

    public Job(String companyName, String url, String dateApplied, User user) {
        this.companyName = companyName;
        this.url = url;
        this.dateApplied = dateApplied;
        this.user = user;
    }
}
