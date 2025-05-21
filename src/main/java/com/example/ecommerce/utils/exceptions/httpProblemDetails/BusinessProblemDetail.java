package com.example.ecommerce.utils.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;

public class BusinessProblemDetail extends ProblemDetail {
    public BusinessProblemDetail(String detail) {
        setDetail(detail);
        setTitle("Business Exception");
        setStatus(HttpStatus.BAD_REQUEST);
    }
}
