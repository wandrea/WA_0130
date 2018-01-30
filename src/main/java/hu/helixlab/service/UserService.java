package hu.helixlab.service;

import hu.helixlab.domain.Contact;
import hu.helixlab.domain.User;

import javax.persistence.*;
import java.util.List;

public class UserService {

	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("helixlab_jpa_pu");

	public void save(User user){
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			//TODO külön contact service-be kell rakni
			Contact c = new Contact();
			c.setContactDescription("example contact");
			manager.persist(c);
			user.addContact(c);
			//////////////////////////////////////////////

			manager.persist(user);

			// Commit the transaction
			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	public List<User> findAll(){

		List<User> users = null;

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			//JPQL
			//users = manager.createQuery("select u from User u ").getResultList();
			users = manager.createNamedQuery("getAllUser").getResultList();
			// Commit the transaction
			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}

		return users;
	}

	public User findById(int id){
		User user = null;

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			//JPQL
			/*user = (User) manager.
					createQuery("select u from User u where u.id =" + id).getResultList();

			*/
			Query query = manager.createQuery("select u from User u where u.id = :id");
			query.setParameter("id", id);

			user = (User) query.getSingleResult();

			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}

		return user;
	}

	public void delete(User user){
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			manager.remove(user);

			// Commit the transaction
			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	public User update(User user){
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			manager.persist(user);

			// Commit the transaction
			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}

		return user;
	}






	public List<User> findAllWhereIdBiggerThen(int id){
		List<User> users = null;

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			//JPQL
			Query query = manager.createQuery("select u from User u where u.id> :id");
			query.setParameter("id", id);

			users = query.getResultList();
			//users = manager.createNamedQuery("getAllUser").getResultList();
			// Commit the transaction
			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}

		return users;

	}

	public void deleteById(int id){
		/*User user = null;

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();



			Query query = manager.createQuery("select u from User u where u.id = :id");
			query.setParameter("id", id);

			user = (User) query.getSingleResult();
			manager.remove(user);

			transaction.commit();

		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}*/
		User user=null;
		user = findById(id);
		delete(user);

	}
}
