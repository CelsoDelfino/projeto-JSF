package com.delfino.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConfig {
	
	public Connection connect_to_db(String name, String user,String pass) {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/" + name, user,pass);
			if(conn!=null) {
				System.out.println("Conectado com sucesso");
			}else {
				System.out.println("ERRO");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return conn;
	}
	
	public void read_data(Connection conn) {
		Statement statement;
		ResultSet rs= null;
		
		try {
			String query = String.format("select * from Empresa");
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getString("id")+"");
				System.out.println(rs.getString("cnpj")+"");
				System.out.println(rs.getString("data_fundacao")+"");
				System.out.println(rs.getString("nome_fantasia")+"");
				System.out.println(rs.getString("razao_social")+"");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
