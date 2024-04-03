package sit.int204.springpractice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private OfficeDto office;
}
