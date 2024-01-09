package com.delfino.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.delfino.model.Empresa;
import com.delfino.model.TipoEmpresa;
import com.delfino.repository.Empresas;
import com.delfino.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public GestaoEmpresasBean() {
	}

	@Inject
	private Empresas empresas;
	
	@Inject
	private FacesMessages messages;

	private String termoPesquisa;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	private List<Empresa> listaEmpresas;

	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
}
