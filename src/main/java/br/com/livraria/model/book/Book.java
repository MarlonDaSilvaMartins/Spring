package br.com.livraria.model.book;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document("books")
public class Book {
    @Id
    private String bookId;
    private String name;
    private String author;
    private LocalDate date;
    private Double price;
}