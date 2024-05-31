package com.event.wear.platform.Shipping.domain.model.entities;

import com.event.wear.platform.Shipping.domain.model.valueobjects.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private RemainingDays remainingDays;

    private String address;

    @Embedded
    private Deadline deadline;

    @Embedded
    private StartDate startdate;

    @Enumerated(EnumType.STRING)
    private TrackingStatus trackingstatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserId userid;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_id")
    private List<ShippingDetails> ShippingDetails = new ArrayList<>();

    // Constructor
    public Shipping(RemainingDays remainingDays, String address, Deadline deadline, TrackingStatus trackingstatus, UserId userid, StartDate startdate) {
        this.address = address;
        this.deadline = deadline;
        this.trackingstatus = trackingstatus;
        this.startdate = startdate;
        this.remainingDays = remainingDays;
        this.userid = userid;
    }

    // Métodos de negocio

    public void updateStatus() {
        this.trackingstatus = this.trackingstatus.nextStatus();
    }


}
