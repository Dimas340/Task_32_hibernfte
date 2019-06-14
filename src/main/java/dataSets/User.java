package dataSets;

import javax.persistence.*;
import java.io.Serializable;

@Entity   // Указывает, что данный класс является сущностью
@Table(name = "users")   // указывает на имя таблицы, которая будет отображаться в этой сущности
public class User implements Serializable {

    @Id  // id колонки
    @Column(name = "id")  //указывает на имя колонки, которая отображается в свойство сущности
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  указывает, что данное свойство будет создаваться согласно указанной стратегии
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password", unique = true, updatable = false)
    private String password;

    @SuppressWarnings("UnusedDeclaration")
    public User() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

