package sn.cisse410;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class DevController {
    
    @GetMapping("/home")
    public String home() {
        return "Hello you are at the dev profile";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to your admin dashboard";
    }
}
