package wangju.microdoc.validators;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterForm {

    @NotNull
    @Size(min = 1)
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;

}
