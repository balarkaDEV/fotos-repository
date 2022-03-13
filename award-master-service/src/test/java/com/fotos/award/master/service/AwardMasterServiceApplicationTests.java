package com.fotos.award.master.service;

import com.fotos.award.master.service.business.AwardMasterBusiness;
import com.fotos.award.master.service.model.AwardMaster;
import com.fotos.award.master.service.repository.AwardMasterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
@SpringBootTest
class AwardMasterServiceApplicationTests {

	@Autowired
	private AwardMasterBusiness awardMasterBusiness;
	@MockBean
	private AwardMasterRepository awardMasterRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFindAll(){
		when(awardMasterRepository.findAll()).thenReturn(
				Stream.of(
						new AwardMaster(1,"Wedding Photographer of the Year","",2019, "India","Better Photography", new Date(),1),
						new AwardMaster(2,"World Press Photo","",2019, "Netherlands","WPP", new Date(),1),
						new AwardMaster(3,"Wedding Photographer of the Year","",2001, "India","Better Photography", new Date(),2)
				).collect(Collectors.toList()));

		assertThat(awardMasterBusiness.findAll().size()).isEqualTo(3);
		assertThat(awardMasterBusiness.findAll().get(0).getName()).isEqualTo("Wedding Photographer of the Year");
	}
}

