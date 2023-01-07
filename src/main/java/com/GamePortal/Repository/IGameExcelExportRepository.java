package com.GamePortal.Repository;

import com.GamePortal.Entity.GameInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameExcelExportRepository extends JpaRepository<GameInformation, Long> {

}

