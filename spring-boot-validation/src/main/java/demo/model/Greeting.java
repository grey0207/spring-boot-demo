package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Greeting {
    private int id;
    @NotBlank(message = "name not blank")
    @Size(min = 1, max = 4)
    private String name;
    @NotBlank(message = "email not blank")
    @Email
    private String email;

    public Greeting(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
