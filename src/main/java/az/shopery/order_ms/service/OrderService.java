package az.shopery.order_ms.service;

import az.shopery.order_ms.model.dto.response.OrderResponseDto;
import az.shopery.order_ms.model.dto.shared.SuccessResponse;
import java.util.List;

public interface OrderService {
    SuccessResponse<List<OrderResponseDto>> checkoutFromCart(String userEmail);
    SuccessResponse<List<OrderResponseDto>> getMyOrders(String userEmail);
}
