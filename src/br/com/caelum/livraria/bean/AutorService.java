package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	private AutorDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(Autor autor){
		dao.salva(autor);
		//throw new RuntimeException("Erro lançado para testar rollback");
	}
	
	public List<Autor> todosAutores(){
		return dao.todosAutores();
	}
}
