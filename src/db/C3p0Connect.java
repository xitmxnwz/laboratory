package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Connect {
	public static void main(String[] args) { // 使用自定义配置
		ComboPooledDataSource dataSource1 = new ComboPooledDataSource();
		// 使用自定义配置
		// ComboPooledDataSource dataSource2 = new ComboPooledDataSource("");
		// 建立连接
		try {
			Connection conn = dataSource1.getConnection();
			String sql = "select * from user";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("username") + "->" + res.getString("password"));
			}
			res.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
