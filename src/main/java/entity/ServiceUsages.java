package entity;

<<<<<<< HEAD
import lombok.*;
//import lombok.experimental.FieldDefaults;

=======
>>>>>>> Trinh
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
<<<<<<< HEAD
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceUsages {
    int serviceId;
    int contractId;
    Date startDate;
    Date endDate;
=======

public class ServiceUsages {    
    private int serviceId;
    private int contractId;
    
    @Builder.Default
    private Date startDate = new Date();
    private Date endDate;
>>>>>>> Trinh
}
