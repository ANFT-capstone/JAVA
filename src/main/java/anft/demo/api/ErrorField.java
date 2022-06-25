package anft.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorField {

    private int status;
    private String code;
    private String message;

}
