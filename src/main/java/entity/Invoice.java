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
public class Invoice {
    int id;
    int contractid;
    int billing_period_month;
    int billing_period_year;
    BigDecimal previous_debt;
    BigDecimal discount;
    BigDecimal totalamount;
    Boolean status;
    Date due_date;
    Date created_at;
}
