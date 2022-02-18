package br.com.livraria.error;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> dataNotFoundException(DataNotFoundException exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> dataInvalidaException(HttpMessageNotReadableException exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "Valor incorreto inserido"),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> camposEmBrancoException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "Campo obrigatorio não preenchido"),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> falhaConexaoBancoException(Exception exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Falha ao conectar"),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
