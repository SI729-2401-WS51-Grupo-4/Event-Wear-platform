package com.event.wear.platform.transactions.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class RentList {

    @Getter
    private List<Long> ids;

    public RentList() {
        ids = new ArrayList<Long>();
    }

    public void addRent(Long id) {
        ids.add(id);
    }
}