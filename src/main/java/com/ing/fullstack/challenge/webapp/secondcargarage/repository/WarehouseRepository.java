package com.ing.fullstack.challenge.webapp.secondcargarage.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Warehouse;

@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, Long> {

	List<Warehouse> findByName(String name);
}
