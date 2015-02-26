package com.faculdade.linguagem_programacao.trabalho;

public class TestFacade {

	public static void main(String[] args) {
		ClienteDAOFacade daoFacade = new ClienteDAOFacade();
		Cliente cliente = new Cliente("Luiz Carlos", "9999-9999", "3292738317");
		daoFacade.insert(cliente);
		cliente.setCpf("836767231");
		daoFacade.update(cliente);
		daoFacade.delete(cliente);
	}

}
