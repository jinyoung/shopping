package shopping.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import shopping.DeliveryApplication;

@Entity
@Table(name = "Shipping_table")
@Data
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private Long orderId;

    private String test;

    @PostPersist
    public void onPostPersist() {}

    public static ShippingRepository repository() {
        ShippingRepository shippingRepository = DeliveryApplication.applicationContext.getBean(
            ShippingRepository.class
        );
        return shippingRepository;
    }

    public void cancelDelivery() {}

    public void trackDelivery() {}

    public static void startDelivery(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Shipping shipping = new Shipping();
        repository().save(shipping);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(shipping->{
            
            shipping // do something
            repository().save(shipping);


         });
        */

    }
}
