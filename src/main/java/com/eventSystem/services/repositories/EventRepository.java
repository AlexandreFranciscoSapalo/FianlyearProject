package com.eventSystem.services.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.eventSystem.domain.Event;



public interface EventRepository extends PagingAndSortingRepository<Event, Integer> {

}
