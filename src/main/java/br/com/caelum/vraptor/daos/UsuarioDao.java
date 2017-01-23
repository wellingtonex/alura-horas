package br.com.caelum.vraptor.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.models.Usuario;

@RequestScoped
public class UsuarioDao {

	private EntityManager manager;

	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public UsuarioDao(){}
	
	public void adicionar(Usuario usario) {
		manager.getTransaction().begin();
		manager.persist(usario);
		manager.getTransaction().commit();
	}

	public List<Usuario> lista() {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
		return usuarios;
	}

	public Usuario busca(String login, String senha){
	    TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class);
	    query.setParameter("login", login);
	    query.setParameter("senha", senha);
	    return query.getSingleResult();
	}
}
