package com.faculdade.linguagem_programacao.lab11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.faculdade.linguagem_programacao.database.util.ConnectionManager;

public class ContasDAO {

	private final static String INSERT = "INSERT INTO contas (codigo,nome,senha,endereco,saldo) VALUES (?,?,?,?,?)";
	private final static String UPDATE = "UPDATE contas SET codigo=?, nome=? , senha=?, endereco=?, saldo=? WHERE codigo=?";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  contas (codigo varchar(10) NOT NULL  PRIMARY KEY, nome VARCHAR(20) NOT NULL,  senha varchar(20) NOT NULL, endereco varchar(200) NOT NULL, saldo numeric(15,3))";
	private final static String DELETE = "DELETE FROM contas WHERE codigo = ?";
	private final static String GET_ALL = "SELECT * FROM contas";
	private final static String GET_CLIENTE_BY_CPF = "SELECT * FROM contas WHERE codigo = ?";

	public ContasDAO() {
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

	public boolean delete(String codigo) {

		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(DELETE)) {
				st.setString(1, codigo);
				st.execute();
			}
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public boolean delete(Conta conta) {

		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(DELETE)) {
				st.setString(1, conta.getCodigo());
				st.execute();
			}
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public boolean insert(Conta conta) {
		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(INSERT)) {
				st.setString(1, conta.getCodigo());
				st.setString(2, conta.getNome());
				st.setString(3, conta.getSenha());
				st.setString(4, conta.getEndereco());
				st.setDouble(5, conta.getSaldo());
				st.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public boolean update(Conta conta) {
		try (Connection conn = ConnectionManager.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement(UPDATE)) {
				st.setString(1, conta.getCodigo());
				st.setString(2, conta.getNome());
				st.setString(3, conta.getSenha());
				st.setString(4, conta.getEndereco());
				st.setDouble(5, conta.getSaldo());
				st.setString(6, conta.getCodigo());
				st.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public List<Conta> getAll() {
		List<Conta> clientes = new ArrayList<Conta>();
		try (Connection conn = ConnectionManager.getConnection()) {

			try (PreparedStatement st = conn.prepareStatement(GET_ALL)) {
				ResultSet rs = st.executeQuery(GET_ALL);
				while (rs.next()) {
					Conta conta = new Conta(rs.getString("codigo"), rs.getString("nome"),
							rs.getString("senha"), rs.getString("endereco"), rs.getDouble("saldo"));
					clientes.add(conta);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return clientes;
	}

	public Conta getContaByCodigo(String codigo) {
		Conta conta = null;

		try (Connection conn = ConnectionManager.getConnection()) {
			try (PreparedStatement st = conn.prepareStatement(GET_CLIENTE_BY_CPF)) {
				st.setString(1, codigo);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					conta = new Conta(rs.getString("codigo"), rs.getString("nome"),
							rs.getString("senha"), rs.getString("endereco"), rs.getDouble("saldo"));
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return conta;
	}

	public boolean existeConta(String codigo) {
		Conta conta = null;

		try (Connection conn = ConnectionManager.getConnection()) {
			try (PreparedStatement st = conn.prepareStatement(GET_CLIENTE_BY_CPF)) {
				st.setString(1, codigo);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					if (rs.getString("codigo").equals(codigo)) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}
}
