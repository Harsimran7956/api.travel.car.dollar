package com.kamadhenu.api.travel.car.dollar.model.domain.response.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class DomainVehAvailCore {

    private Boolean arriveByFlight;

    private String status;

    private DomainVehicle vehicle;

    private List<DomainIncludedPrices> domainIncludedPrices;

    private List<DomainExtras> domainExtras;

    private DomainTotalCharge totalCharge;

    private DomainRateQualifier domainRateQualifier;

    private DomainReference domainReference;
}
