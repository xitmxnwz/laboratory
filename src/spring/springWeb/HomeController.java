package spring.springWeb;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/test","/homepage"})
public class HomeController {
	@RequestMapping(method=GET)
	public String home() {
		return "home";
	}
}
