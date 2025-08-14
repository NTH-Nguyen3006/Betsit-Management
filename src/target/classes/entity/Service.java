package entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Service {
    private int id;
    private String serviceName;
    private String unit;
    private BigDecimal price;
    private String description;
}
