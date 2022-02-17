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

@ControllerAdvice
public class CustomControllerAdvice {
    //TODO trocar de ResponseEntity para ErrorResponse
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> dataNotFoundException(DataNotFoundException exception){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage(),stackTrace),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> dataInvalidaException(HttpMessageNotReadableException exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "Valor incorreto inserido"),HttpStatus.BAD_REQUEST);
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
