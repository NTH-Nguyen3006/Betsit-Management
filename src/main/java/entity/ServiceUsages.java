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

public class ServiceUsages {    
    private int serviceId;
    private int contractId;
    
    @Builder.Default
    private Date startDate = new Date();
    private Date endDate;
}
