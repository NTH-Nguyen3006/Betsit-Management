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
    int Invoice_id;
    int Service_id;
    int Quantity;
    BigDecimal Unit_price;
    BigDecimal Subtotal;
}
