package com.GamePortal.Service;

import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Repository.IGameExcelExportRepository;
import com.GamePortal.Repository.IGameInformationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ExcelExportService {

    @Autowired
    private IGameExcelExportRepository excelExportRepository;

    public List<GameInformation> listAll(){
        return excelExportRepository.findAll(Sort.by("gameName").ascending());
    }




}
