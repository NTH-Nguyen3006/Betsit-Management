package entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Role {
    private int id;
    private String roleName;
    private String description;
    
    @Override
    public String toString() {
        return this.roleName;
    }
}
