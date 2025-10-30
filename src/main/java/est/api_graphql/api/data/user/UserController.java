package est.api_graphql.api.data.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
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

    @QueryMapping
    public User searchUserById(@Argument Long id){
        User user = repository.findById(id).orElseThrow( () -> new UserNotFoundException());
        return user;
    }

    @SchemaMapping(typeName = "User", field = "fullEmail")
    public String getFullName(User user){
        return user.getEmail() + "full";
    }

}
