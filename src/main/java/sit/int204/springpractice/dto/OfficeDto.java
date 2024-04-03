package sit.int204.springpractice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OfficeDto {
    private String id;
    private String city;
    private String phone;
    private String addressLine1;
    private String country;
}
