package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.VehicleSequences;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.WarehouseSequences;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class NextSequenceGeneratorServiceTest {

	@Mock
	private MongoOperations mongoOperations;

	@InjectMocks
	private NextSequenceGeneratorService theNextSequenceGeneratorService = new NextSequenceGeneratorService();

	@Test
	void testGetNextWarehoseSequence() {
		final WarehouseSequences ws = new WarehouseSequences();
		ws.setSeq(1);
		when(mongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class),
				any())).thenReturn(ws);
		assertEquals(1, theNextSequenceGeneratorService.getNextWarehoseSequence("warehouseSequences"));
	}

	@Test
	void testGetNextVehicleSequence() {
		final VehicleSequences vs = new VehicleSequences();
		vs.setSeq(1);
		when(mongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class),
				any())).thenReturn(vs);
		assertEquals(1, theNextSequenceGeneratorService.getNextVehicleSequence("vehicleSequences"));
	}

}
