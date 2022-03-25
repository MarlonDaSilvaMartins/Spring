package br.com.livraria.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class BookRequest {
    @NotBlank(message = "Empty name")
    private String name;
    @NotBlank(message = "Empty author")
    private String author;
    @NotNull(message = "Empty release date")
    private LocalDate date;
    @NotNull(message = "Empty price")
    @DecimalMin(value = "0.1",message = "Minimum value 0.10")
    private Double price;
}
