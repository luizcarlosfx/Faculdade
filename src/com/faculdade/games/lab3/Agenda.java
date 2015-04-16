package com.faculdade.games.lab3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Agenda implements Serializable
{
	private Collection<Professor> professores = new HashSet<Professor>();
	private Collection<Aluno> alunos = new HashSet<Aluno>();

	public void salvarAluno(Aluno aluno)
	{
		alunos.add(aluno);
	}

	public void salvarProfessor(Professor professor)
	{
		professores.add(professor);
	}

	public void salvarProfessores(Professor... professores)
	{
		for (Professor professor : professores)
		{
			salvarProfessor(professor);
		}
	}

	public void salvarAlunos(Aluno... alunos)
	{
		for (Aluno aluno : alunos)
		{
			salvarAluno(aluno);
		}
	}

	public void removerAluno(Aluno aluno)
	{
		alunos.remove(aluno);
	}

	public void removeProfessor(Professor professor)
	{
		professores.remove(professor);
	}

	public Aluno obterAluno(String id)
	{
		return alunos.stream().filter(a -> a.getMatricula().equals(id)).findFirst().get();
	}

	public Professor obterProfessor(String id)
	{
		return professores.stream().filter(a -> a.getRegristro().equals(id)).findFirst().get();
	}

	public void listarAlunos()
	{
		for (Aluno aluno : alunos)
		{
			System.out.println(aluno);
		}
	}

	public void listarProfessores()
	{
		for (Professor professor : professores)
		{
			System.out.println(professor);
		}
	}

	public void salvarAgenda()
	{
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(
				"agenda.ser")))
		{
			stream.writeObject(this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Agenda carregarAgendaSalva()
	{
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(
				"agenda.ser")))
		{
			return (Agenda) stream.readObject();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
