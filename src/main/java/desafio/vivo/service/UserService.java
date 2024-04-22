package desafio.vivo.service;

import desafio.vivo.model.dao.UserDao;

public interface UserService {

    UserDao createUser(UserDao userDao);

    UserDao updateUser(UserDao userDao);

    UserDao findUserByDocument(String document);

    UserDao findUserById(Long id);
}
