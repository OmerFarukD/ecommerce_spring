package com.example.ecommerce.utils.exceptions;

import com.example.ecommerce.utils.exceptions.httpProblemDetails.BusinessProblemDetail;
import com.example.ecommerce.utils.exceptions.httpProblemDetails.NotFoundProblemDetail;
import com.example.ecommerce.utils.exceptions.types.BusinessException;
import com.example.ecommerce.utils.exceptions.types.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetail handleBusinessException(BusinessException exception){

        return new BusinessProblemDetail(exception.getMessage());

    }

    @ExceptionHandler(NotFoundException.class)
    public NotFoundProblemDetail handleNotFoundException(NotFoundException exception){
        return  new NotFoundProblemDetail(exception.getMessage());
    }


}
