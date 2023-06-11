package ltd.colingting.web.controller;

import javax.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import ltd.colingting.application.service.RegistrationService;
import ltd.colingting.domain.vo.Address;
import ltd.colingting.domain.vo.Name;
import ltd.colingting.domain.vo.PhoneNumber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 丁浩
 * @date 2022年07月23日 19:25
 */
@RestController("registration/")
@RequiredArgsConstructor
public class RegistrationController {


    private final RegistrationService service;

    @PostMapping("register")
    public String register() throws ValidationException {
        service.register(new Name("Colin Ting"), new PhoneNumber("0755-12345678"),
            new Address("深圳市南山区科技园"));
        return "SUCCESS";
    }

}
