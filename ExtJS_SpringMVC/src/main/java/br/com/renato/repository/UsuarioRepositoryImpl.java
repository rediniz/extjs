package br.com.renato.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.renato.model.Usuario;


//Informar que é componente do Spring e um Repositório
@Repository 
@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {

	
	@PersistenceContext
	EntityManager manager; // Ineja um gerenciador de entidade que é responsável por todas a comunicação com o banco
	
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {

		/*Seleciona todos os usuários do banco usando linguagem de consulta do Hibernate (HQL)
		*(note que Usuario é o nome da classe modelo, e não da tabela no banco)
		*/
		return manager.createQuery("select u from Usuario u").getResultList();
	}

	public Usuario inserirUsuario(Usuario usuario) {
		//.persist é responsável por inserir dados no banco.
		manager.persist(usuario);
		return usuario;
	}
	public Usuario apagarUsuario(Usuario usuario) {
		//.remove deleta linhas do banco
		Usuario u = manager.find(Usuario.class, usuario.getId());
		manager.remove(u);
		return u;
	}
	
	/*
	 * Não utilizado, mas também existe o .merge que faz o update.
	 * 
	 */

}
