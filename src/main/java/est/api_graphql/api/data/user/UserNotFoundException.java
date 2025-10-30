package est.api_graphql.api.data.user;

class UserNotFoundException extends RuntimeException{
    UserNotFoundException(){
        super("Could not find this User in our data base");
    }
}
