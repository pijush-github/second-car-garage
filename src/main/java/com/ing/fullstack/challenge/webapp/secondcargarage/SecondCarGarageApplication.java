package com.ing.fullstack.challenge.webapp.secondcargarage;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Car;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Location;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Warehouse;
import com.ing.fullstack.challenge.webapp.secondcargarage.repository.WarehouseRepository;

@ComponentScan
@EnableMongoRepositories(basePackageClasses = WarehouseRepository.class)
@SpringBootApplication
public class SecondCarGarageApplication implements CommandLineRunner {

	@Autowired 
	private WarehouseRepository warehouseRepository; 
	
	public static void main(String[] inArgs) {
		SpringApplication.run(SecondCarGarageApplication.class, inArgs);
	}

	@Override
	public void run(String... inArgs) throws Exception {
		warehouseRepository.deleteAll();
		int id = 1;
	    final Vehicle v1 = new Vehicle(Long.valueOf(id++),"Volkswagen", "Jetta III", Long.valueOf(1995), Double.valueOf(12947.52), true, "2018-09-18");
	    final Vehicle v2 = new Vehicle(Long.valueOf(id++),"Chevrolet", "Corvette", Long.valueOf(2004), Double.valueOf(20019.64), true, "2018-01-27");
	    final Vehicle v3 = new Vehicle(Long.valueOf(id++),"Ford", "Expedition EL", Long.valueOf(2008), Double.valueOf(27323.42), false, "2018-07-03");

	    final List<Vehicle> vehicles = Arrays.asList(v1, v2, v3);
	    
	    final Car c = new Car("West wing", vehicles);
	    final Location l = new Location(new BigDecimal("47.13111"), new BigDecimal("-61.54801"));

	    final Warehouse w = new Warehouse(Long.valueOf(1), "Warehouse A", l, c);
	    warehouseRepository.save(w);
	    
	    System.out.println("Find All");
	    warehouseRepository.findAll().forEach(System.out::println);
	    System.out.println("Find By Name");
	    System.out.println(warehouseRepository.findByName("Warehouse A").get(0));
	    System.out.println("Find By Id");
	    System.out.println(warehouseRepository.findById(Long.valueOf(1)).get());
	}
}
