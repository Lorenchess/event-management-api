package com.lorenchess.eventsmanagementapi.controller;

import com.lorenchess.eventsmanagementapi.controller.exceptions.AlreadyPresentException;
import com.lorenchess.eventsmanagementapi.controller.exceptions.NotPresentException;
import com.lorenchess.eventsmanagementapi.entities.Participant;
import com.lorenchess.eventsmanagementapi.repositiories.ParticipantRepo;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RepositoryRestController
public class CheckInCheckOutController {
    private final ParticipantRepo participantRepo;

    public CheckInCheckOutController(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }

    /**
     * Method that returns a HAL obj, we need the second parameter PersistentEntityResourceAssembler and the return type is PersistentEntityResource
     * */
    @PostMapping("/events/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) throws AlreadyPresentException {
        Participant participant;
        if (participantRepo.findById(id).isPresent()) {
            participant = participantRepo.findById(id).get();

          try{
              if (!participant.getCheckedIn()) {
                  participant.setCheckedIn(true);
                  participantRepo.save(participant);
              }
          } catch (RuntimeException exception) {
              throw new AlreadyPresentException(participant.getName() + " already checked!", exception);
          }


        } else {
            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(assembler.toFullResource(participant));
    }

    @PostMapping("events/checkout/{id}")
    public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) {
        Participant participant;
        if (participantRepo.findById(id).isPresent()) {
         participant = participantRepo.findById(id).get();

         try{
          if (participant.getCheckedIn()) {
              participant.setCheckedIn(false);
              participantRepo.save(participant);
          }
         }catch (RuntimeException exception) {
           throw new NotPresentException(participant.getName() + " has not check in yet.", exception);
         }

         } else {
             throw new ResourceNotFoundException();
         }

     return ResponseEntity.ok(assembler.toFullResource(participant));
    }


}
