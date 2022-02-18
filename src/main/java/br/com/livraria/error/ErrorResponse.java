package br.com.livraria.error;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private LocalDateTime data;
    private int codigo;
    private String status;
    private String mensagem;

    public ErrorResponse(HttpStatus httpStatus, String mensagem){
        this.data = LocalDateTime.now();
        this.codigo = httpStatus.value();
        this.status = httpStatus.name();
        this.mensagem = mensagem;
    }
}
