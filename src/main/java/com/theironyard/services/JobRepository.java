package com.theironyard.services;


import com.theironyard.entities.Job;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ericweidman on 3/11/16.
 */
public interface JobRepository extends CrudRepository<Job, Integer> {
}
