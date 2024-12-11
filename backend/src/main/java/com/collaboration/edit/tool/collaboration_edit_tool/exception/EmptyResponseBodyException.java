package com.collaboration.edit.tool.collaboration_edit_tool.exception;


public class EmptyResponseBodyException extends NullPointerException {
    String errorMessage;
    
    public EmptyResponseBodyException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
