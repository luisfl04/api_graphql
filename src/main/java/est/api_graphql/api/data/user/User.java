package est.api_graphql.api.data.user;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_users")
public class User {

    private @Id @GeneratedValue @Column(name = "id") Long id;
    private @Column(name = "email", unique = true) String email;
    private @Column(name = "first_name") String first_name;
    private @Column(name = "last_name") String last_name;
    private @Column(name = "age") int age;
    private @Column(name = "phone") String phone;

    private @Column(name = "gender") Gender gender;

    User(){}
    public User(String first_name, String last_name, String email, int age, String phone, Gender gender){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
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

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
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
        return  "User -> [id: " + this.id + ", first_name: " + this.first_name + ", email: " + this.email + "]";
    }

}


