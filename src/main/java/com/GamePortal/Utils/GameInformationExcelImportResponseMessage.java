package com.GamePortal.Utils;

public class GameInformationExcelImportResponseMessage {
    private String message;

    public GameInformationExcelImportResponseMessage (String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
