package dao;

import dataSets.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Util;

public class UsersDAO {

    private Util util = new Util();
    private Session session = util.getSesion();

    public UsersDAO() {
    }

    public User get(long id) throws HibernateException {
        return (User) session.get(User.class, id);
    }

    public void insertUser(String login, String password) throws HibernateException {
        Transaction transaction = session.beginTransaction();
        session.save(new User(login, password));
        transaction.commit();
        //Транзакция - это набор из одного или нескольких операторов, которые выполняются как единое целое,
    // поэтому либо все операторы выполняются, либо ни один из операторов не выполняется.
}

    public User getUserByLogin(String login) { // по логину юзера написать метод
        Query query = session.createQuery("FROM User WHERE login = :login");
        query.setParameter("login", login);
        return (User) query.uniqueResult();
    }
}
