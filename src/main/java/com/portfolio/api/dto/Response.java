package com.portfolio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T> {
    
    private String mensaje;

    private T entity;
    
    public Response(String mensaje){
        this.mensaje = mensaje;
    }

    public Response(T entity){
        this.entity = entity;
    }
    
}
