package com.delfino.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.delfino.model.Empresa;
import com.delfino.model.RamoAtividade;
import com.delfino.model.TipoEmpresa;
import com.delfino.repository.Empresas;
import com.delfino.repository.RamoAtividades;
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
	
	@Inject
	private RamoAtividades ramoAtividades;

	private String termoPesquisa;
	
	private Converter ramoAtividadeConverter;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	private List<Empresa> listaEmpresas;
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		List<RamoAtividade> listaRamoAtividades = this.ramoAtividades.pesquisar(termo);
		
		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
		
		return listaRamoAtividades;
	}

	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}
	

	public Empresas getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}

	public RamoAtividades getRamoAtividades() {
		return ramoAtividades;
	}

	public void setRamoAtividades(RamoAtividades ramoAtividades) {
		this.ramoAtividades = ramoAtividades;
	}

	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}

	public void setRamoAtividadeConverter(Converter ramoAtividadeConverter) {
		this.ramoAtividadeConverter = ramoAtividadeConverter;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
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
