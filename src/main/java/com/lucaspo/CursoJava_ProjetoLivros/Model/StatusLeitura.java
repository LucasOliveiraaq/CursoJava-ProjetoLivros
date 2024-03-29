package com.lucaspo.CursoJava_ProjetoLivros.Model;

public enum StatusLeitura {
	Planejado(0, "Planejado"),
	Lendo(1, "Lendo"),
	Concluído(2, "Concluído");
	
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
	
	public static int retornoValue(String valueSelecionado) {
		for (StatusLeitura statusLeitura : StatusLeitura.values()) {
			if(statusLeitura.description == valueSelecionado) {
				return statusLeitura.value;
			}
		}
		return 0;
	}
}
