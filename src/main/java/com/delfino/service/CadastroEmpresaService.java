package com.delfino.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.delfino.model.Empresa;
import com.delfino.repository.Empresas;
import com.delfino.util.Transacional;

public class CadastroEmpresaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
    private Empresas empresas;

    @Transacional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }
}
