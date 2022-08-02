package shopping.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.domain.*;

@RestController
// @RequestMapping(value="/shippings")
@Transactional
public class ShippingController {

    @Autowired
    ShippingRepository shippingRepository;

    @RequestMapping(
        value = "shippings/{id}/canceldelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Shipping cancelDelivery(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /shipping/cancelDelivery  called #####");
        Optional<Shipping> optionalShipping = shippingRepository.findById(id);

        optionalShipping.orElseThrow(() -> new Exception("No Entity Found"));
        Shipping shipping = optionalShipping.get();
        shipping.cancelDelivery();

        shippingRepository.save(shipping);
        return shipping;
    }
    // keep
}
