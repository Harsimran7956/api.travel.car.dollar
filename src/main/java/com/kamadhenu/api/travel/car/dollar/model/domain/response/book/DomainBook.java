package com.kamadhenu.api.travel.car.dollar.model.domain.response.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class DomainBook {

    private String status;

    private String referenceId;

    private String supplierReference;
}
