package kz.singularity.bankappdelivery.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Getter
@Setter

public class LoginReq {
    private String username;
    private String password;
}
