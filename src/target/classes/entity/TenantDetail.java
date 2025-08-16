
package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TenantDetail {
    private String citizenId;
    private String perCardFrontImage;
    private String perCardBackImage;
    private int residencyStatus;
    private String occupation;
    private String hometown;
}
