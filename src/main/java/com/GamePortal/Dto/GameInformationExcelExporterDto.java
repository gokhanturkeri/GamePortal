package com.GamePortal.Dto;


import com.GamePortal.Entity.GameInformation;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

public class GameInformationExcelExporterDto {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<GameInformation> gameInformationList;

    public GameInformationExcelExporterDto(List<GameInformation> gameInformationList) {
        this.gameInformationList = gameInformationList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("GameInformation");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        createCell(row, 0, "gameId", style);
        createCell(row, 1, "gameName", style);
        createCell(row, 2, "gameCost", style);
        createCell(row, 3, "UsersGame", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (GameInformation gameInformation : gameInformationList) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            createCell(row, columnCount++, gameInformation.getGameId().intValue(), style);
            createCell(row, columnCount++, gameInformation.getGameName(), style);
            createCell(row, columnCount++, gameInformation.getGameCost(), style);
            createCell(row, columnCount++, gameInformation.getUsersGame().toString(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}