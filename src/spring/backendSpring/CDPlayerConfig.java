package spring.backendSpring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration//说明这是个配置类
@EnableAspectJAutoProxy//启动aop功能（只有在配置类中才能用这个）
@ComponentScan("spring.backendSpring")//启动组件扫描（只有在配置类中才能用这个）
public class CDPlayerConfig {

	@Bean
	public AOPTest aOPTest() {
		return new AOPTest();
	}
	@Bean
	public DataSource dataSource() {
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost:3306/laboratory");
	  ds.setUsername("root");
	  ds.setPassword("hello123");
	  return ds;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	  return new JdbcTemplate(dataSource);
	}
	
//	@Autowired
//    private JdbcOperations jdbcOperations;
//	
//	@Bean
//	public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
//	  return new JdbcSpitterRepository(jdbcTemplate);
//	}
}

