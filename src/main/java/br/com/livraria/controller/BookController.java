package br.com.livraria.controller;

import br.com.livraria.model.book.mapper.BookMapper;
import br.com.livraria.model.book.request.BookRequest;
import br.com.livraria.model.book.response.BookResponse;
import br.com.livraria.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("v1/book")
public class BookController {
    BookService bookService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse saveBook(@Valid @RequestBody BookRequest bookRequest){
        return BookMapper.bookToResponse(bookService.save(BookMapper.requestToBook(bookRequest)));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse>getAllBooks(){
        return bookService.getAllBooks().stream().map(BookMapper::bookToResponse).toList();
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBook(@PathVariable("bookId") String bookId){
        return BookMapper.bookToResponse(bookService.getBookById(bookId));
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookResponse updateBook(@PathVariable("bookId") String bookId, @Valid @RequestBody BookRequest bookRequest){
        return BookMapper.bookToResponse(bookService.update(bookId, BookMapper.requestToBook(bookRequest)));
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBook(@PathVariable("bookId") String bookId){
        return bookService.delete(bookId);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public String deleteMany(@RequestParam("bookId") List<String> bookId){
        return bookService.deleteMany(bookId);
    }

    @GetMapping("/readCookie")
    @ResponseStatus(HttpStatus.OK)
    public String readCookie(@CookieValue("theme")String theme){
        return "theme: "+theme;
    }

    @PostMapping("/setCookie")
    public void setCookie(@CookieValue(value = "theme", defaultValue = "light")String theme,
                          HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("theme", theme);
        cookie.setMaxAge(2592000);
        cookie.setPath("/v1/book");
        httpServletResponse.addCookie(cookie);
    }
}