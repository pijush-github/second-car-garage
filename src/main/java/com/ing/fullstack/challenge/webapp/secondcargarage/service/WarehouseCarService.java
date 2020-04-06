package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Warehouse;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDetailDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.error.ResourceNotFoundException;
import com.ing.fullstack.challenge.webapp.secondcargarage.repository.WarehouseRepository;

@Service
public class WarehouseCarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseCarService.class);

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private ShoppingCartService shoppingCartService;

	/*
	 * This method is used to populates list of Cars present under all warehouses
	 */
	public Iterable<CarDto> getAllWraehouseCars() {
		LOGGER.info("CarService.getAllWraehouseCars() invocation started");
		List<CarDto> theCarDtos = new ArrayList<>();
		warehouseRepository.findAll().forEach(inWareHouse -> inWareHouse.getCar().getVehicles().forEach(v -> {
			CarDto e = new CarDto(String.valueOf(v.get_id()), String.valueOf(inWareHouse.get_id()), v.getMake(),
					v.getModel(), String.valueOf(v.getYear_model()), String.valueOf(v.getPrice()),
					String.valueOf(v.isLicensed()), v.getDate_added(),
					String.valueOf(shoppingCartService.isPresentUnderCart(
							String.valueOf(inWareHouse.get_id())+String.valueOf(v.get_id()))));
			theCarDtos.add(e);
		}));

		return theCarDtos.stream().sorted((a, b) -> {
			return a.getDate_added().compareTo(b.getDate_added());
		}).collect(Collectors.toList());
	}

	/*
	 * This method is used to populates individual Car details
	 */
	public CarDetailDto getCarDetail(final String inWarehouseId, final String inVehicleId) {
		LOGGER.info("CarService.getCarDetail() invocation started");
		Warehouse theWarehouse = warehouseRepository.findById(Long.valueOf(inWarehouseId))
				.orElseThrow(() -> new ResourceNotFoundException("Wearhouse is not found"));
		CarDetailDto theCarDetailDto = new CarDetailDto(String.valueOf(theWarehouse.get_id()), theWarehouse.getName(),
				theWarehouse.getLocation(), theWarehouse.getCar().getVehicles().stream()
						.filter(v -> String.valueOf(v.get_id()).equalsIgnoreCase(inVehicleId)).findAny());
		return theCarDetailDto;
	}
}
