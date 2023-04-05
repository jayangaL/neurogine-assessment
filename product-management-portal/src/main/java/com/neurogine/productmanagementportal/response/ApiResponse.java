package com.neurogine.productmanagementportal.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse <T>{
    private int statusCode;
    private String message;
    private Object result;
}
