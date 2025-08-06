package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    Integer Id;
    int InvoiceId; // ✅ sửa cho khớp cột SQL
    String Tenant;
    BigDecimal Amount;
    Date PaymentDate; // ✅
    String PaymentMethod; // ✅
    String TransactionCode; // ✅
    String Note;
}