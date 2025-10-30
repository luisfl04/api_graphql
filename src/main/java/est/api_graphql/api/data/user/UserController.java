package est.api_graphql.api.data.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/create")
    ResponseEntity<?> createUser(@RequestBody User newUser){
        repository.save(newUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("")
    List<User> getAllUsers(){
        List<User> users = repository.findAll().stream().toList();
        return users;
    }

}
