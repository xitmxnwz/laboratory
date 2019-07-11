package spring.backendSpring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest{

    @Autowired 
    private UserService userService;

    @Test 
    public void hasMatchUser() { 
        boolean b1 = userService.hasMatchUser("admin", "123456"); 
        System.out.println(b1);
    }

//    @Test 
//    public void findUserByUserName() { 
//        User user = userService.findUserByUserName("admin"); 
//        assertEquals(user.getUserName(), "admin"); 
//    }
//
//    @Test 
//    public void loginSuccess() { 
//        User user = userService.findUserByUserName("admin"); 
//        user.setUserId(1); 
//        user.setUserName("admin"); 
//        user.setLastIp("192.168.20.106"); 
//        user.setLastVisit(new Date()); 
//        userService.loginSuccess(user); 
//    } 
}
