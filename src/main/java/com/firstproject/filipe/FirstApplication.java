package com.firstproject.filipe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.firstproject.filipe.domain.Category;
import com.firstproject.filipe.domain.City;
import com.firstproject.filipe.domain.Product;
import com.firstproject.filipe.domain.State;
import com.firstproject.filipe.repositories.CategoryRepository;
import com.firstproject.filipe.repositories.CityRepository;
import com.firstproject.filipe.repositories.ProductRepository;
import com.firstproject.filipe.repositories.StateRepository;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 =  new Category(null, "Computer");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		State state1 = new State(null,"Piauí");
		State state2 = new State(null,"Ceará");
		
		City c1 = new City(null, "Teresina", state1);
		City c2 = new City(null, "Fortaleza", state2);
		City c3 = new City(null, "Parnaíba", state1);
		
		state1.getCities().addAll(Arrays.asList(c1,c3));
		state2.getCities().addAll(Arrays.asList(c2));
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
}
