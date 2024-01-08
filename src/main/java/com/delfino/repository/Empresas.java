package com.delfino.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.delfino.model.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
<<<<<<< HEAD
	
	private Empresa empresa;
	
	public Empresas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresas() {
		// TODO Auto-generated constructor stub
	}
	
=======

	public Empresas() {}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

>>>>>>> fdff7f4448aea028e9cc045b35151e638d49d8bf
	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where nomeFantasia like :nomeFantasia";
		
		TypedQuery<Empresa> query = manager
				.createQuery(jpql, Empresa.class);
		
		query.setParameter("nomeFantasia", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Empresa> todas() {
<<<<<<< HEAD
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
   }
	
=======
         return manager.createQuery("from Empresa", Empresa.class).getResultList();
    }

>>>>>>> fdff7f4448aea028e9cc045b35151e638d49d8bf
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}
