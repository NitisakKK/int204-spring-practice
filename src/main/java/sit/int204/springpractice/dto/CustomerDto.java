package sit.int204.springpractice.dto;

import lombok.Data;
import lombok.Value;
import sit.int204.springpractice.entities.Order;

import java.io.Serializable;
import java.util.Set;

@Data
public class CustomerDto {
    Integer id;
    String customerName;
    String contactLastName;
    String phone;
    String addressLine1;
    String city;
    String state;
    String postalCode;
    String country;
    Set<OrderDto> orderSet;
}