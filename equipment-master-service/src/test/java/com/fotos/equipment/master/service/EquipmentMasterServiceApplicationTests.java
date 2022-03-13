package com.fotos.equipment.master.service;

import com.fotos.equipment.master.service.business.EquipmentMasterBusiness;
import com.fotos.equipment.master.service.model.EquipmentMaster;
import com.fotos.equipment.master.service.repository.EquipmentMasterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class EquipmentMasterServiceApplicationTests {

	@Autowired
	private EquipmentMasterBusiness equipmentMasterBusiness;
	@MockBean
	private EquipmentMasterRepository equipmentMasterRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testFindAll(){
		when(equipmentMasterRepository.findAll()).thenReturn(
				Stream.of(
						new EquipmentMaster(1,"Nikon D800","Camera","Nikon",new Date(),1),
						new EquipmentMaster(2,"Nikon D750","Camera","Nikon",new Date(),1),
						new EquipmentMaster(3,"Canon 5dMII","Camera","Canon",new Date(),2)
				).collect(Collectors.toList()));

		assertThat(equipmentMasterBusiness.findAll().size()).isEqualTo(3);
	}

	@Test
	void testFindById(){
		long id = 1;
		when(equipmentMasterRepository.findById(id)).thenReturn(
				Optional.of(new EquipmentMaster(1,"Nikon D800","Camera","Nikon",new Date(),1)));

		assertThat(equipmentMasterBusiness.findById((long)1).get().getName()).isEqualTo("Nikon D800");
		assertThat(equipmentMasterBusiness.findById((long)1).get().getType()).isEqualTo("Camera");
		assertThat(equipmentMasterBusiness.findById((long)1).get().getMake()).isEqualTo("Nikon");
		assertThat(equipmentMasterBusiness.findById((long)1).get().getPhotographerId()).isEqualTo(1);
	}

	@Test
	void testFindByPhotographerId(){
		long photogId = 1;
		when(equipmentMasterRepository.findByPhotographerId(photogId)).thenReturn(Stream.of(
				new EquipmentMaster(1,"Nikon D800","Camera","Nikon",new Date(),1),
				new EquipmentMaster(2,"Nikon D750","Camera","Nikon",new Date(),1)
		).collect(Collectors.toList()));

		assertThat(equipmentMasterBusiness.findAll().size()).isEqualTo(2);
	}
}
