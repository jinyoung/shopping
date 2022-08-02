package shopping.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    code = HttpStatus.BAD_REQUEST,
    reason = "Order over 10 quantity Is Not Cancellable"
)
public class OverQuantityIsNotCancellableException extends RuntimeException {

    public OverQuantityIsNotCancellableException() {
        super("Order over 10 quantity Is Not Cancellable");
    }
}
