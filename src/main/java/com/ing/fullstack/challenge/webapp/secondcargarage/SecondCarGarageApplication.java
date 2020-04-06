package com.ing.fullstack.challenge.webapp.secondcargarage;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Car;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Location;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Warehouse;
import com.ing.fullstack.challenge.webapp.secondcargarage.repository.WarehouseRepository;
import com.ing.fullstack.challenge.webapp.secondcargarage.service.NextSequenceGeneratorService;

@ComponentScan
@SpringBootApplication(exclude = EmbeddedMongoAutoConfiguration.class)
@EnableMongoRepositories(basePackageClasses = WarehouseRepository.class)
public class SecondCarGarageApplication implements CommandLineRunner {

	@Autowired 
	private WarehouseRepository theWarehouseRepository;
	
	@Autowired
	private NextSequenceGeneratorService theNextSequenceGeneratorService;
		
	public static void main(String[] inArgs) {
		SpringApplication.run(SecondCarGarageApplication.class, inArgs);
	}

	/*
	 * This method is required for data setup during application start up for local-env
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... inArgs) throws Exception {
		theWarehouseRepository.deleteAll();
	    final Vehicle wAv1 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Volkswagen", "Jetta III", Long.valueOf(1995), Double.valueOf(12947.52), true, "2018-09-18");
	    final Vehicle wAv2 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Chevrolet", "Corvette", Long.valueOf(2004), Double.valueOf(20019.64), true, "2018-01-27");
	    final Vehicle wAv3 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Ford", "Expedition EL", Long.valueOf(2008), Double.valueOf(27323.42), false, "2018-07-03");	    
	    final Car wAc = new Car("West wing", Arrays.asList(wAv1, wAv2, wAv3));
	    final Location wAl = new Location(new BigDecimal("47.13111"), new BigDecimal("-61.54801"));
	    final Warehouse wA = new Warehouse(Long.valueOf(theNextSequenceGeneratorService.getNextWarehoseSequence("warehouseSequences")), "Warehouse A", wAl, wAc);
	    theWarehouseRepository.save(wA);
	    final Vehicle wBv1 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Maserati", "Coupe", Long.valueOf(2005), Double.valueOf(19957.71), false, "2017-11-14");
	    final Vehicle wBv2 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Isuzu", "Rodeo", Long.valueOf(1998), Double.valueOf(6303.99), false, "2017-12-03");
	    final Vehicle wBv3 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Infiniti", "I", Long.valueOf(2002), Double.valueOf(6910.16), false, "2017-10-15");	    
	    final Car wBc = new Car("East wing", Arrays.asList(wBv1, wBv2, wBv3));
	    final Location wBl = new Location(new BigDecimal("15.95386"), new BigDecimal("7.06246"));
	    final Warehouse wB = new Warehouse(Long.valueOf(theNextSequenceGeneratorService.getNextWarehoseSequence("warehouseSequences")), "Warehouse B", wBl, wBc);
	    theWarehouseRepository.save(wB);
	    final Vehicle wCv1 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Cadillac", "Escalade", Long.valueOf(2005), Double.valueOf(7429.18), true, "2018-09-26");
	    final Vehicle wCv2 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Porsche", "Cayenne", Long.valueOf(2011), Double.valueOf(17066.31), true, "2017-10-19");
	    final Vehicle wCv3 = new Vehicle(Long.valueOf(theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences")),"Mercedes-Benz", "SL-Class", Long.valueOf(2005), Double.valueOf(14066.06), false, "2018-08-08");	    
	    final Car wCc = new Car("Suid wing", Arrays.asList(wCv1, wCv2, wCv3));
	    final Location wCl = new Location(new BigDecimal("39.12788"), new BigDecimal("-2.71398"));
	    final Warehouse wC = new Warehouse(Long.valueOf(theNextSequenceGeneratorService.getNextWarehoseSequence("warehouseSequences")), "Warehouse C", wCl, wCc);
	    theWarehouseRepository.save(wC);
	}
}
