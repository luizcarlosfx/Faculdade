package com.faculdade.linguagem_programacao.lab6;

public enum TipoTransacao {
	SAQUE(1), DEPOSITO(0);
	
	private int value;

	private TipoTransacao(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static TipoTransacao byValue(int value) {
		for (TipoTransacao tt : values()) {
			if (tt.getValue() == value) {
				return tt;
			}
		}
		return null;
	}
}
