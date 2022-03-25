package br.com.livraria.error;


import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;


@RestControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleNotFoundException(DataNotFoundException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(NOT_FOUND.name())
                        .field("bookId")
                        .parameter(exception.getClass().getName())
                        .build()))
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleInvalidDateException(HttpMessageNotReadableException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getName())
                        .build()))
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(exception.getBindingResult().getAllErrors().stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.joining(", ")))
                        .parameter(exception.getClass().getName())
                        .build()))
                .build();
    }

    @ExceptionHandler(MissingRequestCookieException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMissingRequestCookieException(MissingRequestCookieException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getName())
                        .build()))
                .build();
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleResponseStatusException(ResponseStatusException exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(exception.getReason())
                        .parameter(exception.getClass().getName())
                        .build()))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse falhaConexaoBancoException(Exception exception){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(INTERNAL_SERVER_ERROR.name())
                        .field(exception.getMessage())
                        .parameter(exception.getClass().getName())
                        .build()))
                .build();
    }
}
