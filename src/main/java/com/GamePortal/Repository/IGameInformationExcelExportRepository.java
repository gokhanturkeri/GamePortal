package com.GamePortal.Repository;

import com.GamePortal.Entity.GameInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameInformationExcelExportRepository extends JpaRepository<GameInformation, Long> {

}

