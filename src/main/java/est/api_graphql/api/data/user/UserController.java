package est.api_graphql.api.data.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.log.LogMessage.*;

import java.util.List;

@Controller
class UserController {

    @Autowired
    private UserRepository repository;

    @QueryMapping
    public User searchUserById(@Argument Long id){
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @QueryMapping
    public List<User> searchAllUsers(){
        return repository.findAll();
    }

    @MutationMapping
    public User createUser(@Argument User newUser){
        return repository.save(newUser);
    }

    @MutationMapping
    public User updateEmailUser(@Argument Long id, @Argument String email){
        User user = repository.findById(id).orElseThrow();

        user.setEmail(email);

        return repository.save(user);
    }

    @MutationMapping
    public String deleteUser(@Argument Long id){
        repository.deleteById(id);
        return "User deleted!";
    }

    @SchemaMapping(typeName = "User", field = "fullName")
    public String getFullName(User user){
        return user.getFirstName() + " " + user.getLastName();
    }

}
