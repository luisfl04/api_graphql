package est.api_graphql.api.data.user;

class UserNotFoundException extends RuntimeException{
    UserNotFoundException(){
        super("Null resource");
    }
}
