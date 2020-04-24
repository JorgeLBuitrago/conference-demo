package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    SessionRepositoryImpl sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Optional<Session> getSession(@PathVariable Long id){
        return sessionRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session createSession(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(path = "{id}", method =RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSession(@PathVariable Long id){
        //You would need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    @RequestMapping(path = "{id}", method =RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Session updateSession(@PathVariable Long id, @RequestBody Session session) throws Exception {
        if(sessionRepository.existsById(id)){
            return sessionRepository.saveAndFlush(session);
        } else {
            throw new Exception("Error");
        }
    }

}
