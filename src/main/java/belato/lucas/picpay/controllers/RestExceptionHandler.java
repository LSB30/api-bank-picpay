package belato.lucas.picpay.controllers;

import belato.lucas.picpay.expections.PicpayExpection;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicpayExpection.class)
    public ProblemDetail handlePicPayException(PicpayExpection e) {
        return e.toProblemDetail();
    }

}
