package desafio.vivo.model.dao;

public class UserDao {

    private final Long id;
    private final String name;
    private final String email;
    private final String document;

    public UserDao(Long id, String email, String document, String name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }
}
