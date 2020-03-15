package com.anbara.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anbara.cat.dao.ProduitRepository;
import com.anbara.cat.entities.Produit;

@SpringBootApplication
public class CatMvcSpringBoot1Application implements CommandLineRunner{
	@Autowired 
	ProduitRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CatMvcSpringBoot1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	    repository.save(new Produit(null, "hp laptop", 587, 3300));
	    repository.save(new Produit(null, "samsung phone", 668, 7933));
	    repository.save(new Produit(null, "samsung laptop", 98, 3993));
	    repository.save(new Produit(null, "camera HD ", 80, 2344));
	    repository.findAll().forEach(l->
	    System.out.println(l.getDesignation()));
	}

}
