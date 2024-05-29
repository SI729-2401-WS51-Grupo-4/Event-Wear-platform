package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.aggregates.RentAggregate;
import com.event.wear.platform.transactions.domain.model.queries.GetRentDataQuery;

import java.util.Optional;

public interface RenQueryService {
    Optional<RentAggregate> handle(GetRentDataQuery command);
}