package com.GamePortal.Repository;

import com.GamePortal.Entity.GameInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameInformationRepository extends JpaRepository<GameInformation, Long> {

    List<GameInformation> findByGameName(String game_name);

}

