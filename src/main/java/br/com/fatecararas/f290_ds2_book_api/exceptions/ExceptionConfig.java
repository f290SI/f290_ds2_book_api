package br.com.fatecararas.f290_ds2_book_api.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> notFoundException(ObjectNotFoundException ex,
            HttpServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), "Recurso não encontrado", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    //TODO: Criar uma exceção customizada para falha em regra de negócios, conforme a necessidade do Service criado; caso seja necessário...

}
