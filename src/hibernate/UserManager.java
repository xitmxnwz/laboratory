package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserManager {
	public static void main(String[] args) {
		Configuration conf = new Configuration()
				.configure();
				
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		User u = new User();
		u.setUsername("56");
		u.setPassword("123");
		sess.save(u);
		tx.commit();
		sess.close();
		sf.close();
	}
}
