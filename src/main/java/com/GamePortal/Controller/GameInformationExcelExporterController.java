package com.GamePortal.Controller;

import com.GamePortal.Dto.GameInformationExcelExporterDto;
import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Service.ExcelExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GameInformationExcelExporterController {

    @Autowired
    private ExcelExportService excelExportService;

    @GetMapping("games/export/excel")
    public  void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDataType = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=gameinformation_" + currentDataType + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<GameInformation> listGameInformation = excelExportService.listAll();

        GameInformationExcelExporterDto gameInformationExcelExporterDto = new GameInformationExcelExporterDto(listGameInformation);

        gameInformationExcelExporterDto.export(response);
    }

}
