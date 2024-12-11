package com.collaboration.edit.tool.collaboration_edit_tool.exception;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.Optional;
// import java.util.UUID;
import java.util.List;

public class EmptyFieldsException extends NullPointerException{
    List<String> errors;

    public EmptyFieldsException(){}

    public EmptyFieldsException(List<String> errors){
        super("Errors occurred because there are empty fields");
        this.errors = errors;
    }
}
