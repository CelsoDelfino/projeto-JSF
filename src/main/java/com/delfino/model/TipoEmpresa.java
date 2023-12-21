package com.delfino.model;

public enum TipoEmpresa {

	MEI("Microempreendedor Individual"),
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LIDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String descricao;

	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
