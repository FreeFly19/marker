package marker.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by FreeFly on 02.11.2016.
 */
@Controller
public class HomeController {
    @GetMapping("")
    public @ResponseBody String index() {
        return "Hello, world!!!";
    }
}
