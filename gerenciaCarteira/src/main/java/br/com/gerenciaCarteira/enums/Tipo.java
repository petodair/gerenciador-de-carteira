package br.com.gerenciaCarteira.enums;

public enum Tipo {
	
	GANHO("Ganho"),
	GASTO("Gasto");
	
	private String tipo;

	private Tipo(String tipo) {
		this.tipo = tipo;
	}

}
