package com.actors.dao;

import com.actors.model.Actor;

import java.util.List;

public interface ActorDAO {

    Actor getById(Integer id);

    List<Actor> getAll();

    void addActor(Actor actor);

    void deleteById(Integer id);

}
