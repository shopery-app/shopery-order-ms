package az.shopery.order_ms.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    OrderEntity order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    ProductEntity product;
    @Column(name = "product_name", nullable = false)
    String productName;
    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    BigDecimal unitPrice;
    @Column(name = "quantity", nullable = false)
    Integer quantity;
    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    BigDecimal subtotal;
}
