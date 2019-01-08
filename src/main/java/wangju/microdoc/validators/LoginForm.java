package wangju.microdoc.validators;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginForm {

    @NotNull
    @Size(min = 1,max = 30)
    private String username;

    @NotNull
    @Min(6)
    private String password;
}
