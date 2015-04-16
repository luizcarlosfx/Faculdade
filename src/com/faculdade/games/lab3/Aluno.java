package com.faculdade.games.lab3;

public class Aluno extends Pessoa
{
	private String matricula;

	public String getMatricula()
	{
		return matricula;
	}

	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public Aluno(int id, String nome, String email, String telefone, String matricula)
	{
		super(id, nome, email, telefone);
		this.matricula = matricula;
	}

	@Override
	public String toString()
	{
		return "Aluno[matricula=" + matricula + ", " + super.toString() + "]";
	}

	@Override
	public int hashCode()
	{
		return super.hashCode() * matricula.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;

		if (matricula.equals(other.matricula))
			return true;

		return super.equals(obj);
	}
}
