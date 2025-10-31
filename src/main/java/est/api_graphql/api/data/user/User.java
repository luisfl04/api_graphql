package est.api_graphql.api.data.user;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_users")
public class User {

    enum Gender{
        MASUCULINO,
        FEMININO,
        OUTRO
    }

    private @Id @GeneratedValue @Column(name = "id") Long id;
    private @Column(name = "email", unique = true) String email;
    private @Column(name = "name") String name;
    private @Column(name = "age") int age;
    private @Column(name = "phone") String phone;

    private @Column(name = "gender") Gender gender;

    User(){}
    public User(String name, String email, int age, String phone, Gender gender){
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return  "User -> [id: " + this.id + ", name: " + this.name + ", email: " + this.email + "]";
    }

}


