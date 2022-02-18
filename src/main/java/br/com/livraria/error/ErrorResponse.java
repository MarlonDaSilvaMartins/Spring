package br.com.livraria.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
    private LocalDateTime data;
    private int codigo;
    private HttpStatus status;
    private String mensagem;

}
