package shopping.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    name = "order",
    url = "${api.url.order}",
    fallback = OrderServiceImpl.class
)
public interface OrderService {
    @RequestMapping(method = RequestMethod.GET, path = "/orders/{id}")
    public Order getOrder(@PathVariable("id") Long id);
    // keep

}