package com.tutorial.mongocrudback.global.exceptions;

import com.tutorial.mongocrudback.global.dto.MessageDto;
import com.tutorial.mongocrudback.global.utils.Operations;
import jdk.dynalink.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageDto(HttpStatus.NOT_FOUND,e.getMessage()));
    }
    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException e){
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST,e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDto> generalException(Exception e){
        return ResponseEntity.internalServerError().body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> validation(MethodArgumentNotValidException e){
        List<String> message= new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((err)->{
            message.add(err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, Operations.trimBrackets(message.toString())));
    }
}
