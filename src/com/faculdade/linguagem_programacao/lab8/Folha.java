package com.faculdade.linguagem_programacao.lab8;

public class Folha {
	
	public static void main(String[] args) {		
		Empregado emp = new Empregado("Luiz carlos", "São José", 10000);
		System.out.println("Inss: " + emp.callINSS());
		System.out.println("Rpf: " + emp.calRPF());
		
		Horista horista = new Horista("Sei lá", "Não sei", 1000,200);
		System.out.println("Salario horista " + horista.calSalario());
		
		Mensalista mensalista = new Mensalista("Nome", "Rua Rua", 100, Cargo.PLENO);
		System.out.println("Salario mensalista: " + mensalista.calSalario());
	}
	
}
