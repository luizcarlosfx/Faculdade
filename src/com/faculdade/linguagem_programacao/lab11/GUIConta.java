package com.faculdade.linguagem_programacao.lab11;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import ch.randelshofer.quaqua.QuaquaLookAndFeel;

public class GUIConta extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEnd;
	private JTextField tfSenha;
	private JTextField tfSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new QuaquaLookAndFeel());
		} catch (Exception e) {
			System.out.println("Quaqua Look And Feel not found");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConta frame = new GUIConta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigo.setBounds(6, 76, 62, 24);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(96, 69, 290, 31);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNome.setBounds(6, 126, 62, 24);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(96, 122, 290, 31);
		contentPane.add(tfNome);
		
		tfEnd = new JTextField();
		tfEnd.setColumns(10);
		tfEnd.setBounds(96, 176, 290, 31);
		contentPane.add(tfEnd);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEndereo.setBounds(6, 180, 78, 24);
		contentPane.add(lblEndereo);
		
		JLabel lblNewLabel = new JLabel("Conta");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 524, 42);
		contentPane.add(lblNewLabel);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(96, 232, 290, 31);
		contentPane.add(tfSenha);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSenha.setBounds(6, 236, 78, 24);
		contentPane.add(lblSenha);
		
		tfSaldo = new JTextField();
		tfSaldo.setColumns(10);
		tfSaldo.setBounds(96, 284, 290, 31);
		contentPane.add(tfSaldo);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSaldo.setBounds(6, 288, 78, 24);
		contentPane.add(lblSaldo);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(263, 338, 62, 24);
		contentPane.add(lblStatus);
		
		final JTextArea tfStatus = new JTextArea();
		tfStatus.setEditable(false);
		tfStatus.setBounds(68, 374, 438, 47);
		contentPane.add(tfStatus);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(90, 433, 93, 29);
		contentPane.add(btCadastrar);
		btCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String codigo = tfCodigo.getText();
				String nome = tfNome.getText();
				String senha = tfSenha.getText();
				String ende = tfEnd.getText();
				double saldo = Double.parseDouble(tfSaldo.getText());
				Conta conta = new Conta(codigo, nome, senha, ende, saldo);
				if(new ContasDAO().insert(conta)){
					tfStatus.setText("Conta Inserida");
				}else {
					tfStatus.setText("Conta não Inserida");
				}
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(191, 433, 93, 29);
		contentPane.add(btnConsultar);
		
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(new ContasDAO().existeConta(tfCodigo.getText())){
					tfStatus.setText("Conta Existe");
				}else{
					tfStatus.setText("Conta não Existe");
				}
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(293, 433, 93, 29);
		contentPane.add(btnAlterar);
		
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String codigo = tfCodigo.getText();
				String nome = tfNome.getText();
				String senha = tfSenha.getText();
				String ende = tfEnd.getText();
				double saldo = Double.parseDouble(tfSaldo.getText());
				Conta conta = new Conta(codigo, nome, senha, ende, saldo);
				
				if(new ContasDAO().update(conta)){
					tfStatus.setText("Conta alterada");
				}else{
					tfStatus.setText("Conta Inalterada");
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(398, 433, 93, 29);
		contentPane.add(btnExcluir);
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ContasDAO dao = new ContasDAO();
				if(dao.delete(tfCodigo.getText())){
					tfStatus.setText("Registro Excluido com sucesso!");
				}else{
					tfStatus.setText("Registro não Excluido");
				}
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(293, 468, 93, 29);
		contentPane.add(btnFechar);
		
		btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(191, 468, 93, 29);
		contentPane.add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfCodigo.setText("");
				tfEnd.setText("");
				tfNome.setText("");
				tfSaldo.setText("");
				tfSenha.setText("");
			}
		});
	}
}
