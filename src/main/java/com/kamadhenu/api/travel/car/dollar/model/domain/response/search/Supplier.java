package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Supplier Response Model
 */
@Data
@ToString
@AllArgsConstructor
public class Supplier {

    private String code;

    private String name;

    private List<Vehicle> vehicles;

}
