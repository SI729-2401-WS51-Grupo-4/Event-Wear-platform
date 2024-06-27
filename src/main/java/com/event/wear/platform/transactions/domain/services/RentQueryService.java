package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.aggregates.Rent;
import com.event.wear.platform.transactions.domain.model.queries.GetRentByIdQuery;

import java.util.Optional;

public interface RentQueryService {
    Optional<Rent> handle(GetRentByIdQuery command);
}