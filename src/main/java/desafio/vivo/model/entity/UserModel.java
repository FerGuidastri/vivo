package desafio.vivo.model.entity;

import desafio.vivo.model.dao.UserDao;
import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;

    public UserDao toUserDao() {
        return new UserDao(id, email, document, name);
    }

    public static UserModel fromUserDao(UserDao userDao) {
        return new UserModel(userDao.getId(), userDao.getName(), userDao.getEmail(), userDao.getDocument());
    }


    public UserModel() {
    }

    public UserModel(Long id, String name, String email, String document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
