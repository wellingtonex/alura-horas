package br.com.caelum.vraptor.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.models.HoraLancada;

public class HoraLancadaDao {

	private EntityManager entityManager;

	@Inject
	public HoraLancadaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public HoraLancadaDao() {
	}

	public List<HoraLancada> lista() {
		return entityManager
				.createQuery("select h from HoraLancada h", HoraLancada.class)
				.getResultList();
	}
	
	public void adiciona(HoraLancada horaLancada) {
		entityManager.getTransaction().begin();
		entityManager.persist(horaLancada);
		entityManager.getTransaction().commit();
	}
}
