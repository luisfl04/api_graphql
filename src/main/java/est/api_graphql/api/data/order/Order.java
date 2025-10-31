package est.api_graphql.api.data.order;


import est.api_graphql.api.data.user.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tb_orders")
public class Order {

    private @Id @GeneratedValue Long id;
    @Autowired @ManyToOne User user;
    private String name_product;
    private Float price;

    Order(){}

    public Order(User user){
        this.user = user;
    }

    public Float getPrice() {
        return price;
    }

    public String getName_product() {
        return name_product;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Long getId() {
        return id;
    }

}
