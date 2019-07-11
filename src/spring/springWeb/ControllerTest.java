package spring.springWeb;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  

public class ControllerTest {
	
  @Test
  public void testHomePage() throws Exception {
    HomeController controller = new HomeController();
    
    MockMvc mokMvc = standaloneSetup(controller).build();
    
    
    
    mokMvc.perform(get("/aaa")).andExpect(view().name("home"));
//    mokMvc.perform(get("/test")).andExpect(view().name("home"));
    
    
  }
}
