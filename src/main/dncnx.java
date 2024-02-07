package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbcnx {

			public String url="jdbc:mysql://localhost/projetjava";
			private static String driver="com.mysql.cj.jdbc.Driver";
			private static Connection con=null;
			dbcnx(){
				try{
				Class.forName(driver);
				con= DriverManager.getConnection(url,"root","");
				}catch(ClassNotFoundException | SQLException e){
				System.out.println(e);
				}
				}
			
			public static Connection maConnexion(){
				if(con==null){
						new dbcnx();
				}
				return con;
			}
	}
