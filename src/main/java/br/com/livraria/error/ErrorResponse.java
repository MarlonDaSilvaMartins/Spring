package br.com.livraria.error;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private LocalDateTime data = LocalDateTime.now();
    private String status;
    private String mensagem;
    private String stackTrace;

    public ErrorResponse(HttpStatus httpStatus, String mensagem){
        this.status = httpStatus.toString();
        this.mensagem = mensagem;
    }

    public ErrorResponse(HttpStatus httpStatus, String mensagem ,String stackTrace){
        this.status = httpStatus.toString();
        this.mensagem = mensagem;
        this.stackTrace = stackTrace;
    }
}
