package sit.int204.springpractice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewEmployeeDto {
    private Integer id;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeId;
    private Integer reportsTo;
    private String jobTitle;
}
