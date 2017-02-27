package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;

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
		
		banco.save(autor);
		
		System.out.println("Autor salvo com sucesso!");
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
