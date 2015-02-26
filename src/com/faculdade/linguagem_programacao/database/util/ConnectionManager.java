package com.faculdade.linguagem_programacao.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionManager {

	// Informacoes para conexao com banco de dados. Verificar antes de conectar
	// com outro banco.

	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATABASE = "lp";
	private static final String IP = "localhost";
	private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			return conn;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return conn;
	}

	public static void closeAll(Connection conn, Statement st) {
		try {
			conn.close();
			st.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st)
	{
		try {
			st.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
