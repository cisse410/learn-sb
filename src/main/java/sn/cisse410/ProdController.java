package sn.cisse410;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Profile(value = "prod")
public class ProdController {
    

    @GetMapping("/home")
    public String home() {
        return "Hello you are at the prod profile";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to your dashboard";
    }
}
