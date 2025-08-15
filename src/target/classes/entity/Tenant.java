
package entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tenant {
    private String citizenId;
    private String fullName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private String vehiclePlate;
}
