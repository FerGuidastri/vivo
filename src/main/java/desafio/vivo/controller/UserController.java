package desafio.vivo.controller;

import desafio.vivo.model.dao.UserDao;
import desafio.vivo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDao> createUser(@RequestBody UserDao user) {
        UserDao result = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<UserDao> updateUser(@RequestBody UserDao user){
        UserDao result = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }
    @GetMapping("/document/{document}")
    public ResponseEntity<UserDao> findUserByDocument(@PathVariable String document){
        UserDao result = userService.findUserByDocument(document);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDao> findUserById(@PathVariable Long id){
        UserDao result = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    public UserController(UserService userService) {
        this.userService = userService;
    }

}
