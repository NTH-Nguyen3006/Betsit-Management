package entity;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    int roomId;
    double area;
    BigDecimal rentPrice;
    int status;
    String roomType;
    String notes;

    public enum eStatus {
        Rented, Available, Repair;
    }
}