package com.faculdade.games.lab3;

public class Main
{
	public static void main(String[] args)
	{
		Agenda agenda = Agenda.carregarAgendaSalva();

		if (agenda == null)
		{
			agenda = new Agenda();
			Aluno luiz = new Aluno(1, "luiz", "email1@qualquercoisa.com", "12345", "127701");
			Aluno luiz2 = new Aluno(2, "luiz2", "email2@qualquercoisa.com", "12345", "127702");
			Aluno luiz3 = new Aluno(3, "luiz3", "email3@qualquercoisa.com", "12345", "127703");
			Aluno luiz4 = new Aluno(4, "luiz4", "email4@qualquercoisa.com", "12345", "127704");
			Aluno luiz5 = new Aluno(5, "luiz5", "email5@qualquercoisa.com", "12345", "127705");
			Aluno luiz6 = new Aluno(6, "luiz6", "email6@qualquercoisa.com", "12345", "127706");

			Professor walter = new Professor(7, "walter", "email", "telefone", "professor1", 12);
			Professor gerson = new Professor(8, "gerson", "email", "telefone", "professor2", 12);
			Professor gatto = new Professor(9, "gatto", "email", "telefone", "professor3", 12);
			Professor juliana = new Professor(10, "juliana", "email", "telefone", "professor4", 12);

			agenda.salvarProfessores(walter, gerson, gatto, juliana);

			agenda.salvarAlunos(luiz, luiz2, luiz3, luiz4, luiz5, luiz6);

			agenda.listarAlunos();

			System.out.println();

			agenda.listarProfessores();

			System.out.println();

			Aluno a = agenda.obterAluno("127704");

			a.setNome("Qualquer bosta de nome");

			agenda.salvarAluno(a);

			agenda.removeProfessor(gerson);

			agenda.listarAlunos();

			System.out.println();

			agenda.listarProfessores();

			agenda.salvarAgenda();
		}
		else
		{
			System.out.println("Carregando dados da agenda salva");

			agenda.listarAlunos();
			agenda.listarProfessores();
		}
	}
}
