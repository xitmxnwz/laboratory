package frame.swagger.withSpringfox;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class PersonService {
	public List<Person> selectAll(){
		List perl = new ArrayList();
		perl.add(new Person());
		return perl;
	}
}
