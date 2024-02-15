package com.lucaspo.CursoJava_ProjetoLivros.Model;

public enum StatusLeitura {
	Planejado(1, "Planejado"),
	Lendo(2, "Lendo"),
	Concluído(3, "Concluído");
	
	private final int value;
	private final String description;
	
	private StatusLeitura(Integer value, String description) {
	    this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}
	
	public String getDescription() {
		 return description;
	}
	
	public static String retornoDescription(int valueSelecionado) {
		for (StatusLeitura statusLeitura : StatusLeitura.values()) {
			if(statusLeitura.value == valueSelecionado) {
				return statusLeitura.description;
			}
		}
		return null;
	}
}
