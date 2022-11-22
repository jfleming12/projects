package com.revature.dao;

import java.util.List;

import com.revature.model.Superhero;

public interface SuperHeroDao {
    // CRUD:
    Superhero save(Superhero superhero);
    void delete(Superhero superhero);
    Superhero update(Superhero superhero);
    List<Superhero> findAllSuperheroes();
}
