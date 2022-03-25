package br.com.livraria.controller;

import br.com.livraria.model.book.mapper.BookMapper;
import br.com.livraria.model.book.request.BookRequest;
import br.com.livraria.model.book.response.BookResponse;
import br.com.livraria.service.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("v1/book")
public class BookController {
    LivroService livroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse saveBook(@Valid @RequestBody BookRequest book){
        return BookMapper.bookToResponse(livroService.save(BookMapper.requestToBook(book)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse>getAllBooks(){
        return livroService.getAllBooks().stream().map(BookMapper::bookToResponse).collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBook(@PathVariable("bookId") String bookId){
        return BookMapper.bookToResponse(livroService.getBookById(bookId));
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookResponse updateBook(@PathVariable("bookId") String bookId, @Valid @RequestBody BookRequest book){
        return BookMapper.bookToResponse(livroService.update(bookId, BookMapper.requestToBook(book)));
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("bookId") String bookId){
        livroService.delete(bookId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteMany(@RequestParam("bookId") List<String> bookId){
        livroService.deleteMany(bookId);
    }

    @GetMapping("/cookie")
    @ResponseStatus(HttpStatus.OK)
    public String readCookie(@CookieValue("name")String name){
        return livroService.readCookie(name);
    }
}//livroController