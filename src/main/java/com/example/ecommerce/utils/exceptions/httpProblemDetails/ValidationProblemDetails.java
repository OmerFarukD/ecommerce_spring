package com.example.ecommerce.utils.exceptions.httpProblemDetails;

import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;

public class ValidationProblemDetails extends ProblemDetail {

    private BindingResult bindingResult;

    public ValidationProblemDetails(BindingResult bindingResult) {
        this.bindingResult = bindingResult;


    }


    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
