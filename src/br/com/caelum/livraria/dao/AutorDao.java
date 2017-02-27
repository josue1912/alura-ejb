package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	void aposCriacao(){
		System.out.println("Criou AutorDAO");
	}
	
	public void salva(Autor autor) {
		System.out.println("Salvando autor");
		
//		try{
//			Thread.sleep(20000); //20 s
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		em.persist(autor);
		
		System.out.println("Autor salvo com sucesso!");
	}
	
	public List<Autor> todosAutores() {
		return em.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = em.find(Autor.class, autorId);
		return autor;
	}
	
}
