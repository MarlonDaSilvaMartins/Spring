package br.com.livraria.error;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomDataNotFoundException(Exception exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();
        return new ResponseEntity<>(new ErrorResponse(status,exception.getMessage(),stackTrace),status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> FalhaConexaoBancoException(Exception exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Falha ao conectar"),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
