package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    SpeakerRepositoryImpl sessionRepository;

    @GetMapping("/")
    public List<Speaker> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Speaker> getSpeaker(@PathVariable Long id){
        return sessionRepository.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker createSpeaker(@RequestBody final Speaker speaker){
        return sessionRepository.saveAndFlush(speaker);
    }

    @RequestMapping(path = "/{id}", method =RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSpealer(@PathVariable Long id){
        //You would need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }
}
