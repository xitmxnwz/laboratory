package spring.backendSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

//    @Autowired
//    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        return userDao.isLogin(userName, password);
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

//    public void loginSuccess(User user){
//        LoginLog loginLog =new LoginLog();
//        loginLog.setUserId(user.getUserId());
//        loginLog.setIp(user.getLastIp());
//        loginLog.setLoginDate(user.getLastVisit());
//        loginLogDao.insertLoginLog(loginLog);
//    }


}
