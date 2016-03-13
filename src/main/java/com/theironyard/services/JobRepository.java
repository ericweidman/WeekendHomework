package com.theironyard.services;

import com.sun.tools.javac.util.List;
import com.theironyard.entities.Job;
import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ericweidman on 3/11/16.
 */
public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> findByUser(User user);
}
