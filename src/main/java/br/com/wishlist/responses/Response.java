package br.com.wishlist.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Response<T> {
    private T data;
    private List<String> errors;

    public Response(T data){
        this.data = data;
    }

    public Response(List<String> errors){
        this.errors = errors;
    }
}
