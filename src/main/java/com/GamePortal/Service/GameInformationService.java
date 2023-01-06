package com.GamePortal.Service;

import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Repository.IGameInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameInformationService {

    @Autowired(required = false)
    private IGameInformationRepository GameInformationRepository;

    public String addGameInformation(GameInformation gameInformation) {
        GameInformationRepository.save(gameInformation);
        return "Yeni oyun veri tabanına kaydedildi" + "==>" + gameInformation.getGameId();
    }

    public GameInformation getGameInformation(Long id){
        return GameInformationRepository.findById(id).get();
    }

    public String deleteGameInformation(Long id){
        GameInformation gameInformation = GameInformationRepository.findById(id).get();
        GameInformationRepository.delete(gameInformation);
        return "Oyun veri tabanından silindi" + "==>" + id;
    }

    public String updateGameInformation(GameInformation gameInformation){
        GameInformationRepository.save(gameInformation);
        return gameInformation.getGameId() + "==>" + "Oyun veri tabanına bilgileri güncellendi";
    }

}
