package com.actors.service;

import com.actors.dao.ActorDAO;
import com.actors.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorDAO actorDAO;

    public List<Actor> getAll() {
        return actorDAO.getAll();
    }

    public Actor getById(Integer id) {
        return actorDAO.getById(id);
    }

    public void addActor(Actor actor) {
        actorDAO.addActor(actor);
    }

    public void deleteActorById(Integer id) {
        actorDAO.deleteById(id);
    }


}
