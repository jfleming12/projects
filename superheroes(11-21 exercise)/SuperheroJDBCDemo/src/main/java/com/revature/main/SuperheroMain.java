package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.SuperHeroDao;
import com.revature.model.Superhero;
import com.revature.service.SuperheroService;

public class SuperheroMain {

	public static void main(String[] args) {
		
		SuperHeroDao superHeroDao = null;
		SuperheroService ss = new SuperheroService(superHeroDao);
		
		System.out.println("Type 1 to get all superheroes:");
		Scanner sc= new Scanner(System.in); 
		int a = sc.nextInt();
		if (a==1) {
			List<Superhero> sh = ss.findAll();
			for(Superhero s : sh) {
				System.out.println(s);
			}
		}
		sc.close();
	}

}
