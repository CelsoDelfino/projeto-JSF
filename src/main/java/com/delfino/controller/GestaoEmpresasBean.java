package com.delfino.controller;

import java.io.Serializable;
import java.util.List;

<<<<<<< HEAD
import javax.faces.view.ViewScoped;
=======
import javax.faces.bean.ViewScoped;
>>>>>>> fdff7f4448aea028e9cc045b35151e638d49d8bf
import javax.inject.Inject;
import javax.inject.Named;

import com.delfino.model.Empresa;
import com.delfino.repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
<<<<<<< HEAD
=======
    public GestaoEmpresasBean() {}
    
>>>>>>> fdff7f4448aea028e9cc045b35151e638d49d8bf
    @Inject
    private Empresas empresas;
    
    private List<Empresa> listaEmpresas;
    
    public void todasEmpresas() {
        listaEmpresas = empresas.todas();
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
}
