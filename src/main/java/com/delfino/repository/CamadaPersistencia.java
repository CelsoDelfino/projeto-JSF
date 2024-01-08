package com.delfino.repository;

public class CamadaPersistencia {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando as informações do banco
		List<Empresa> listaDeEmpresas = empresas.todas();
		System.out.println(listaDeEmpresas);
		

		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
		System.out.println(listaDeEmpresas2);
		
		
		em.close();
		emf.close();
	}


}
