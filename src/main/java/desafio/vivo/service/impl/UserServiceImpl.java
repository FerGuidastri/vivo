package desafio.vivo.service.impl;

import desafio.vivo.exception.UserNotFoundException;
import desafio.vivo.model.dao.UserDao;
import desafio.vivo.model.entity.UserModel;
import desafio.vivo.repository.UserRepository;
import desafio.vivo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDao createUser(UserDao userDao) {
        UserModel entity = UserModel.fromUserDao(userDao);
        entity.setId(null);
        return userRepository.save(entity)
                .toUserDao();
    }

    @Override
    public UserDao updateUser(UserDao userDao) {
        return userRepository.save(UserModel.fromUserDao(userDao))
                .toUserDao();
    }

    @Override
    public UserDao findUserByDocument(String document) {
        return userRepository.findByDocument(document)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"))
                .toUserDao();
    }

    @Override
    public UserDao findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"))
                .toUserDao();
    }



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
