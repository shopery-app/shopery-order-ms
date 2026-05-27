package az.shopery.order_ms.controller;

import az.shopery.order_ms.model.dto.response.OrderResponseDto;
import az.shopery.order_ms.model.dto.shared.SuccessResponse;
import az.shopery.order_ms.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/me/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/checkout")
    public ResponseEntity<SuccessResponse<List<OrderResponseDto>>> checkout(String email) {
        return ResponseEntity.ok(orderService.checkoutFromCart(email));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<OrderResponseDto>>> getMyOrders(String email) {
        return ResponseEntity.ok(orderService.getMyOrders(email));
    }
}
