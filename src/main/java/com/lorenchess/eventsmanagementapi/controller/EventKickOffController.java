package com.lorenchess.eventsmanagementapi.controller;

import com.lorenchess.eventsmanagementapi.entities.Event;
import com.lorenchess.eventsmanagementapi.repositiories.EventRepo;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;

/**
 * //We use @RepositoryRestController to become part of the Rest application and follow the app path
 * set in the app.properties: spring.data.rest.base-path=/event-api
 * */
@RepositoryRestController
public class EventKickOffController {

    private final EventRepo eventRepo;

    public EventKickOffController(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @PostMapping("/events/start/{id}")
    public ResponseEntity start(@PathVariable Long id) {
        Event event;
        if(eventRepo.findById(id).isPresent()){
            event = eventRepo.findById(id).get();
            event.setStarted(true);
            eventRepo.save(event);
        } else {
            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(event.getName()+ " has started!");

    }





}
