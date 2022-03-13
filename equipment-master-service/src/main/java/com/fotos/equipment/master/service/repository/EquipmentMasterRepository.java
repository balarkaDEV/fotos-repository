package com.fotos.equipment.master.service.repository;

import com.fotos.equipment.master.service.model.EquipmentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMasterRepository extends JpaRepository<EquipmentMaster, Long> {

    @Query(value = "from EquipmentMaster e where e.photographerId = :photogId")
    public List<EquipmentMaster> findByPhotographerId(long photogId);
}
