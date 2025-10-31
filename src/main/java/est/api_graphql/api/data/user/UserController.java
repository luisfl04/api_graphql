package est.api_graphql.api.data.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

class UserController {

    @Autowired
    private UserRepository repository;

    @QueryMapping
    public User searchUserById(@Argument Long id){
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

//    public List searchAllUsers(){};
//
//    public User createUser(){};
//
//    public User updateUser(){};
//
//    public User deleteUser();


    @SchemaMapping(typeName = "User", field = "fullEmail")
    public String getFullName(User user){
        return user.getEmail() + "full";
    }

}
