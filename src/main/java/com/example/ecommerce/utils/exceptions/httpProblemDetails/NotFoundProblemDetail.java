package com.example.ecommerce.utils.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NotFoundProblemDetail extends ProblemDetail {
    public NotFoundProblemDetail(String detail){
        setDetail(detail);
        setTitle("Business Exception");
        setStatus(HttpStatus.BAD_REQUEST);

    }
}
