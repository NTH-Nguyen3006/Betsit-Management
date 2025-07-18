package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {
    int id;
    String username;
    String password;
    String fullname;
    String email;
    String phone_number;
    int role_id;
    boolean status;
    Date created_at;
    private boolean enabled;
}
