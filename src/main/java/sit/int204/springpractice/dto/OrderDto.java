package sit.int204.springpractice.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OrderDto {
    Integer id;
    LocalDate orderDate;
    LocalDate requiredDate;
    LocalDate shippedDate;
    String status;
    String comments;
}