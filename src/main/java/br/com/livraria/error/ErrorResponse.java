package br.com.livraria.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
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
