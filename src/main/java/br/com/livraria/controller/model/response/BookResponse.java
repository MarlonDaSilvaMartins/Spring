package br.com.livraria.controller.model.response;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class BookResponse {
    private String bookId;
    private String name;
    private String author;
    private LocalDate date;
    private Double price;
}
