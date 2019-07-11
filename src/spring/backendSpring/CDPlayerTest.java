package spring.backendSpring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {


  @Autowired
  private CompactDisc cd;
//  @Autowired
//  private CDPlayer cdp;	


//  @Test
  public void cdShouldNotBeNull() {
//			  cdp.aa();
			  cd.play();
//	  System.out.println(cd.getClass());
//    assertNotNull(cd);
  }
  
  @Autowired 
  private UserService userService;

  @Test 
  public void hasMatchUser() { 
      boolean b1 = userService.hasMatchUser("admin", "admin"); 
      System.out.println(b1);
  }
}