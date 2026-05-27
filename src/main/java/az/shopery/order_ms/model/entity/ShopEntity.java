package az.shopery.order_ms.model.entity;

import az.shopery.payment_ms.utils.enums.ShopStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shops")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class ShopEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    UserEntity user;
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProductEntity> products;
    @Column(name = "shop_name", nullable = false, unique = true, length = 40)
    String shopName;
    @Column(name = "description", length = 2000)
    String description;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;
    @Column(name = "total_income")
    BigDecimal totalIncome;
    @Column(name = "rating")
    Double rating;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(name = "status", nullable = false)
    ShopStatus status = ShopStatus.PENDING;
}
