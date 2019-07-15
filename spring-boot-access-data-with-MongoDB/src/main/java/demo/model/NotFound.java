package demo.model;

import lombok.Data;

@Data
public class NotFound {
    private String message;
    public NotFound(String message){
        this.message = message;
    }
}
