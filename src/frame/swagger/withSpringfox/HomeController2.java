package frame.swagger.withSpringfox;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/aaa/a","/bbb"})
public class HomeController2 {
	@RequestMapping(value="a",method=GET)
	public String home() {
		return "home";
	}
}
