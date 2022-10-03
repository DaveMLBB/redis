package co.develhope.redis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class UserJPA extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;

    private String domicileAdress;
    private String domicileCity;
    private String domicileNumber;
    private String domicileState;

    private String fiscalCode;


}
