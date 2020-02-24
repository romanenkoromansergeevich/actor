package com.actors.controller;

import com.actors.model.Actor;
import com.actors.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Actor> getAll() {
        return actorService.getAll();
    }

    @RequestMapping(value = "/add/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String add(@PathVariable String name) {
        Actor newActor = new Actor();
        newActor.setName(name);
        actorService.addActor(newActor);
        return "Actor successfully added";
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Integer id) {
        actorService.deleteActorById(id);
        return "Actor successfully deleted";
    }

    @RequestMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "Hello, you can add, delete or view your favorite actors" +
                "1) /add/{name} to add person" +
                "2) /delete/{id} to delete" +
                "3) /all to view actors";
    }
}

