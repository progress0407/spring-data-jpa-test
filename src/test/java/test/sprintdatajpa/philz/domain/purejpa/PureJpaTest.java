package test.sprintdatajpa.philz.domain.purejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import test.sprintdatajpa.philz.domain.Post;

public class PureJpaTest {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
	EntityManager em = emf.createEntityManager();

	public PureJpaTest() {
		System.out.println("--------- #init ----------");
	}

	@Test
	void test() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Post post = new Post("post test");
			em.persist(post);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("rollback !");
			e.printStackTrace();
		}

	}
}
