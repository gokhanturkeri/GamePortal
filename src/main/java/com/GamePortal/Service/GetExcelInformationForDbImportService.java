package com.GamePortal.Service;

import com.GamePortal.Dto.GameInformationExcelImportDto;
import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Repository.IGameInformationExcelImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GetExcelInformationForDbImportService {
    @Autowired
    IGameInformationExcelImportRepository gameInformationExcelImportRepository;

    public void save(MultipartFile file){
        try{
            List<GameInformation> gameInformations = GameInformationExcelImportDto.excelToGameInformations(file.getInputStream());
            gameInformationExcelImportRepository.saveAll(gameInformations);
        } catch (IOException e) {
            throw new RuntimeException("excell saklamanadı" + e.getMessage());
        }
    }
    public List<GameInformation> getAllGameInformations(){
        return gameInformationExcelImportRepository.findAll();
    }
}
