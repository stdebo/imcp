package com.imcp.objects.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection getConnnection(){
		String url = CreateDataSource.newUrl;
		String username = CreateDataSource.username;
		String password = CreateDataSource.password;
		try {
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 关闭数据库
	 */
	public static void closeDB(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
}