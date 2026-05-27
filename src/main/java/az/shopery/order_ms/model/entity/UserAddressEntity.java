package az.shopery.order_ms.model.entity;

import az.shopery.payment_ms.utils.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_addresses")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAddressEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(name = "address_line1", nullable = false)
    String addressLine1;
    @Column(name = "address_line2")
    String addressLine2;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "country", nullable = false)
    String country;
    @Column(name = "postal_code", nullable = false)
    String postalCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false)
    @Builder.Default
    AddressType addressType = AddressType.HOUSE;
    @Column(name = "is_default", nullable = false)
    @Builder.Default
    boolean isDefault = Boolean.FALSE;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    UserEntity user;
}
