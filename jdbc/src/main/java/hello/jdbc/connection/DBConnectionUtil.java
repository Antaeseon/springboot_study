package hello.jdbc.connection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectionUtil {
	public static Connection getConnection() {
		try{
			Connection connection = DriverManager.getConnection(ConnectionConst.URL,ConnectionConst.USERNAME,ConnectionConst.PASSWORD);
			log.info("get connection={}, class={}", connection, connection.getClass());
			return connection;
		}catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
}
