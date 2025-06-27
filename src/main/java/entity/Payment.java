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
    int Id ;
    int Invoice_id;
    String Tenant;
    BigDecimal Amount;
    Date Payment_date;
    String Payment_method;
    String Transaction_code;
    String Note;

}
