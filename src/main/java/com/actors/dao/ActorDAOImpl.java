package com.actors.dao;

import com.actors.model.Actor;
import com.actors.model.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorDAOImpl implements ActorDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM actors";
    private static final String SQL_BY_ID = "SELECT * FROM actors WHERE id = ?";
    private static final String SQL_INSERT_NEW_ACTOR = "INSERT INTO actors(name) VALUES (?);";
    private static final String SQL_DELETE_ACTOR_BY_ID = "DELETE FROM actors WHERE id = ?;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Actor getById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_BY_ID, new Object[]{id},new ActorMapper());
    }

    @Override
    public List<Actor> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new ActorMapper());
    }

    @Override
    public void addActor(Actor actor) {
        jdbcTemplate.update(SQL_INSERT_NEW_ACTOR, actor.getName());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(SQL_DELETE_ACTOR_BY_ID, id);
    }
}
