package com.faculdade.linguagem_programacao.database.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClientesDAO {

	private final static String INSERT = "INSERT INTO clientes (nome,cpf,telefone) VALUES (?,?,?)";
	private final static String UPDATE = "UPDATE clientes SET nome=? , cpf=?, telefone=? WHERE id=?";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  clientes (id int(3) NOT NULL AUTO_INCREMENT   PRIMARY KEY, nome VARCHAR(20) NOT NULL, cpf varchar(20) NOT NULL, telefone varchar(20) NOT NULL)";
	private final static String DELETE = "DELETE FROM clientes WHERE cpf = ?";
	private final static String GET_ALL = "SELECT * FROM clientes";
	private final static String GET_CLIENTE_BY_CPF = "SELECT * FROM clientes WHERE cpf = ?";

	public ClientesDAO() {
		createTable();
	}

	private void createTable() {
		try (Connection conn = ConnectionManager.getConnection();) {
			try (Statement st = conn.createStatement()) {
				st.executeUpdate(CREATE_TABLE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void delete(String cpf) {

		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(DELETE)) {
				st.setString(1, cpf);
				st.execute();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void delete(Cliente cliente) {

		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(DELETE)) {
				st.setString(1, cliente.getCpf());
				st.execute();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void insert(Cliente cliente) {
		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(INSERT)) {
				st.setString(1, cliente.getNome());
				st.setString(2, cliente.getCpf());
				st.setString(3, cliente.getTelefone());
				st.executeUpdate();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void update(Cliente cliente) {
		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(UPDATE)) {
				st.setString(1, cliente.getNome());
				st.setString(2, cliente.getCpf());
				st.setString(3, cliente.getTelefone());
				st.setInt(4, cliente.getId());
				st.executeUpdate();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try (Connection conn = ConnectionManager.getConnection()) {

			try (PreparedStatement st = conn.prepareStatement(GET_ALL)) {
				ResultSet rs = st.executeQuery(GET_ALL);
				while (rs.next()) {
					Cliente cli = new Cliente(rs.getString("nome"), rs.getString("telefone"),
							rs.getString("cpf"), rs.getInt("id"));
					clientes.add(cli);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return clientes;
	}

	public Cliente getClienteByCPF(String cpf) {
		Cliente cli = null;

		try (Connection conn = ConnectionManager.getConnection()) {
			try (PreparedStatement st = conn.prepareStatement(GET_CLIENTE_BY_CPF)) {
				st.setString(1, cpf);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					cli = new Cliente(rs.getString("nome"), rs.getString("telefone"),
							rs.getString("cpf"), rs.getInt("id"));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return cli;
	}
}
