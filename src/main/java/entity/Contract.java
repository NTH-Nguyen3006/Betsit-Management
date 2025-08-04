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
public class Contract {
    Integer Id;                     // Integer
    Integer RoomId;                 // Integer
    String Tenant;                  // VARCHAR(12)
    Date StartDate;                 // DATETIME
    Date EndDate;                   // DATETIME
    BigDecimal DepositAmount;      // DECIMAL(10,2)
    Integer PaymentCycleMonths;  //  Integer
    String File_scan_url;          // VARCHAR(20)
    String Notes;                  // NVARCHAR(MAX)
}
