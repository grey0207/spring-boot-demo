package demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
    private Date timestamp = new Date();
    private Integer status = 200;
    private Object data;
    public BaseModel(Object data){
        this.data = data;
    }
}
