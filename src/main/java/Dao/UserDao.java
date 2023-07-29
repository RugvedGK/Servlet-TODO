package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import Dto.AddTask;
import Dto.User;

public class UserDao {
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction = entityManager.getTransaction();

public void save(User user)
{
	entityTransaction.begin();
	entityManager.persist(user);
	entityTransaction.commit();
}
public User fetchByEmail(String email) {
	List<User> list=entityManager.createQuery("Select x from User x where email=?1").setParameter(1, email).getResultList();
	if(list.isEmpty()) {
		return null;
	}
		else {
			return list.get(0);
		}
	}

public void save(AddTask addtask)
{
	entityTransaction.begin();
	entityManager.persist(addtask);
	entityTransaction.commit();
}
public List<AddTask> fetchAllTask() {
	return entityManager.createQuery("Select x from AddTask x").getResultList();
	
}
}
