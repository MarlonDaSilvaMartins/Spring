package br.com.livraria.service;

import java.util.List;

import br.com.livraria.error.DataNotFoundException;
import br.com.livraria.model.book.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.livraria.repository.BookRepository;

@AllArgsConstructor
@Service
public class BookService {
    BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(String bookId){
        return bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException(bookId+" not found"));
    }

    public Book update(String bookId, Book bookUpdate){
        Book bookSaved = bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException(bookId+" not found"));
        bookUpdate.setBookId(bookSaved.getBookId());
        return bookRepository.save(bookUpdate);
    }

    public void delete(String bookId){
        bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException(bookId+" not found"));
        bookRepository.deleteById(bookId);
    }

    public void deleteMany(List<String> book){
        for(String bookId : book){
            bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException(bookId+" not found"));
            bookRepository.deleteById(bookId);
        }
    }
}
