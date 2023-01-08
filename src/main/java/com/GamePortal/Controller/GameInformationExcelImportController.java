package com.GamePortal.Controller;


import com.GamePortal.Dto.GameInformationExcelImportDto;
import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Service.GetExcelInformationForDbImportService;
import com.GamePortal.Utils.GameInformationExcelImportResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("games/import/excel")
public class GameInformationExcelImportController {

    @Autowired
    GetExcelInformationForDbImportService getExcelInformationForDbImportService;

    @PostMapping("/upload")
    public ResponseEntity<GameInformationExcelImportResponseMessage> uploadFile(@RequestParam("file")MultipartFile file){
        String message = " ";

        if (GameInformationExcelImportDto.hasExcelFormat(file)) {
            try{
                getExcelInformationForDbImportService.save(file);

                message = "Excell başarılı bir şekilde veri tabanına yüklendi " + file.getOriginalFilename() +"!";
                return ResponseEntity.status(HttpStatus.OK).body(new GameInformationExcelImportResponseMessage(message));
            } catch (Exception e) {
                message = "Excell veri tabanına yüklenemedi " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new GameInformationExcelImportResponseMessage(message));
            }
        }

        message = "lütfen Excel yükleyiniz";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GameInformationExcelImportResponseMessage(message));
    }

    public ResponseEntity<List<GameInformation>> getAllGameInformations(){
        try {
            List<GameInformation> gameInformations = getExcelInformationForDbImportService.getAllGameInformations();

            if(gameInformations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(gameInformations, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
