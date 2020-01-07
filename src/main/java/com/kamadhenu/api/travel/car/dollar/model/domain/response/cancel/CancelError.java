package com.kamadhenu.api.travel.car.dollar.model.domain.response.cancel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CancelError {

    private String code;

    private String error;
}
