package com.event.wear.platform.transactions.application.internal.queryservices;

import com.event.wear.platform.transactions.domain.model.aggregates.Rent;
import com.event.wear.platform.transactions.domain.model.queries.GetRentByIdQuery;
import com.event.wear.platform.transactions.domain.services.RentQueryService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.RentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentQueryServiceImpl implements RentQueryService {
    private final RentRepository rentRepository;

    public RentQueryServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Optional<Rent>handle(GetRentByIdQuery query){
        return rentRepository.findById(query.rentId().rentId());
    }
}