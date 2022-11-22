package com.revature.service;


import java.util.List;

import com.revature.dao.SuperHeroDao;
import com.revature.model.Superhero;

public class SuperheroService {
    private SuperHeroDao superHeroDao;

    // pass in a particular implementation of the super hero dao:
    public SuperheroService(SuperHeroDao superHeroDao) {
        // do the creation of the dao:
        this.superHeroDao = superHeroDao;
    }

    public Superhero save(Superhero superhero) {
        // invoking the methods from the DAO:
        // we need an instance of the DAO implementation class:
        this.superHeroDao.save(superhero);
        return superhero;
    }

    public void delete(Superhero superhero) {
    	this.superHeroDao.delete(superhero);
}
    
    public List<Superhero> findAll(){
    	return this.superHeroDao.findAllSuperheroes();
    }
    
    public Superhero update(Superhero superhero) {
    	return this.superHeroDao.update(superhero);
    }
}
