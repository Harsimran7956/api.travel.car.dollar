package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class DomainVehicle {

    private Boolean airConditionInd;

    private String transmissionType;

    private String passengerQuantity;

    private String baggageQuantity;

    private String code;

    private String codeContext;

    private String vehType;

    private String vehClass;

    private String vehName;

    private String pictureURL;
}

