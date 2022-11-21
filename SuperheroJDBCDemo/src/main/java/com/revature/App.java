package com.revature;

import com.revature.dao.SuperHeroDao;
import com.revature.dao.SuperHeroDaoImpl;
import com.revature.model.Superhero;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // use -1 as a placeholder for id:
        Superhero superhero = new Superhero(-1, "Superman", "Flying", 20, "Kryptonite", "D", "Krypton");
        // Not good code, we should get the DAO from a factory:
        SuperHeroDao superheroDao = new SuperHeroDaoImpl();
        superheroDao.save(superhero);
        System.out.println(superhero.getId());
    }
}
