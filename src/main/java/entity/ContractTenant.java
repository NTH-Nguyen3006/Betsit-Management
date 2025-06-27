package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContractTenant {
    int Contract_id ;
    int Personal_id;
    int Role;
}

enum eRoles {
    Holder, Housemate;
}
