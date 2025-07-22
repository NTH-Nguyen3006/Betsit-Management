package entity;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    String username;
    String password;
    String fullname;
    String email;
    String phoneNumber;
    int roleId;
    boolean status;
    Date created_at;
}
