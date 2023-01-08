package com.GamePortal.Dto;

import com.GamePortal.Entity.GameInformation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameInformationExcelImportDto {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADER = {"gameId", "gameName", "gameCost"};
    static String SHEET = "GameInformation";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<GameInformation> excelToGameInformations(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<GameInformation> gameInformations = new ArrayList<GameInformation>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                GameInformation gameInformation = new GameInformation();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx){
                        case 0:
                            gameInformation.setGameId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            gameInformation.setGameName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            gameInformation.setGameCost((int) currentCell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                gameInformations.add(gameInformation);
            }
            workbook.close();

            return gameInformations;
        } catch (IOException e){
            throw new RuntimeException("Excell dosyası yüklenemedi" + e.getMessage());
        }
    }
}
