package co.develhope.redis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String firstName;
    private String lastName;

    private String domicileAdress;
    private String domicileCity;
    private String domicileNumber;
    private String domicileState;

    private String fiscalCode;
}
