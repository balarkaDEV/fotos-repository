package com.fotos.award.master.service.repository;

import com.fotos.award.master.service.model.AwardMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardMasterRepository extends JpaRepository<AwardMaster, Long> {
}
