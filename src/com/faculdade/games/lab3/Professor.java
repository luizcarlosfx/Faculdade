package com.faculdade.games.lab3;

public class Professor extends Pessoa
{
	private String regristro;
	private int horasAulas;

	public int getHorasAulas()
	{
		return horasAulas;
	}

	public void setHorasAulas(int horasAulas)
	{
		this.horasAulas = horasAulas;
	}

	public String getRegristro()
	{
		return regristro;
	}

	public void setRegristro(String regristro)
	{
		this.regristro = regristro;
	}

	public Professor(int id, String nome, String email, String telefone, String regristro,
			int horasAulas)
	{
		super(id, nome, email, telefone);
		this.regristro = regristro;
		this.horasAulas = horasAulas;
	}

	@Override
	public String toString()
	{
		return "Professor[regristro=" + regristro + ", horasAulas=" + horasAulas + ", "
				+ super.toString() + "]";
	}

	@Override
	public int hashCode()
	{
		return super.hashCode() * regristro.hashCode();
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
		Professor other = (Professor) obj;

		if (regristro.equals(other.regristro))
			return true;
		
		return super.equals(obj);
	}
}
