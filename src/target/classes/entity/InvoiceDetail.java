package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDetail {
    int Id;
    int InvoiceId;
    int ServiceId;
    int Quantity;
    BigDecimal UnitPrice;
    BigDecimal Subtotal;
}
