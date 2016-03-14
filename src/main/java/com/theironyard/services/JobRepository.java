package com.theironyard.services;


import com.theironyard.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ericweidman on 3/11/16.
 */
public interface JobRepository extends PagingAndSortingRepository<Job, Integer> {
    Page<Job> findAll(Pageable pageable);
}
