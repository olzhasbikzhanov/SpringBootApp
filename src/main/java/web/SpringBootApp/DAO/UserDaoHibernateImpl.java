package web.SpringBootApp.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.SpringBootApp.models.User;

import java.util.List;
@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> indexUser() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = entityManager.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
