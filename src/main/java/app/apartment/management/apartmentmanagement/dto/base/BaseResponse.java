package app.apartment.management.apartmentmanagement.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private int code;
    private boolean success;
    private String message;
    private T data;


}
