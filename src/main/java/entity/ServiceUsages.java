package entity;

import java.time.LocalDateTime;
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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
