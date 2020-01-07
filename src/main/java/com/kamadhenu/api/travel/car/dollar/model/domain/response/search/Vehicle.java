package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Vechile Response Model
 */
@Data
@ToString
@AllArgsConstructor
public class Vehicle {

    private String sipp;

    private String name;

    private Boolean isAvailable;

    private Boolean isAirCondition;

    private String transmissionType;

    private String fuelType;

    private Integer passengerQuantity;

    private Integer baggageQuantity;

    private String pictureUrl;

    private String vechileModelName;

    private String vehicleModelCode;

    private String vechileReferenceId;

    private Rate rate;
}
