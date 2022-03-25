package br.com.livraria.model.book.mapper;

import br.com.livraria.model.book.request.BookRequest;
import br.com.livraria.model.book.response.BookResponse;
import br.com.livraria.model.book.Book;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookMapper {
    public static Book requestToBook(BookRequest bookRequest){
        return Book.builder()
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .date(bookRequest.getDate())
                .price(bookRequest.getPrice())
                .build();
    }

    public static BookResponse bookToResponse(Book book){
        return BookResponse.builder()
                .bookId(book.getBookId())
                .name(book.getName())
                .author(book.getAuthor())
                .date(book.getDate())
                .price(book.getPrice())
                .build();
    }
}
