package spring.backendSpring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class CDPlayer {
	  @Autowired
	  private CompactDisc cd;	
//	@Bean
//	public CompactDisc sgtPeppers() {
//		return new SgtPeppers();
//	}
//	  @Bean
//	  public CDPlayer cDPlayer(CompactDisc sgtPeppers) {
//		  return new CDPlayer(sgtPeppers);
//	  }

	
	  public CDPlayer() {
		  
	  }
	  public CDPlayer(CompactDisc sgtPeppers) {
		  this.cd = sgtPeppers;
	}
	

	  public void aa() {
		  cd.play();
	  }
}
