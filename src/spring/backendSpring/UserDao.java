package spring.backendSpring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isLogin(String userName,String password){
        String sql="select count(1) from user where username=? and password=?";
        return jdbcTemplate.queryForList(sql,userName,password).size()>0;
    }

    public User findUserByUserName(final String userName){
        String sql="select * from t_user where user_name=?";
        final User user=new User();
        jdbcTemplate.query(sql,new Object[]{userName},new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUsername(rs.getString("setUsername"));
                user.setPassword(userName);
            }
        });
        return user;
    }

}
