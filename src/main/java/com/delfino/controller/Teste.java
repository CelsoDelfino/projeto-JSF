package com.delfino.controller;

import java.sql.Connection;

public class Teste {

	public static void main(String[] args) {
		DbConfig db = new DbConfig();
		
		Connection conn = db.connect_to_db("cursojsfprimefaces", "postgres", "pwd");		
		
		db.read_data(conn);
	}
}

