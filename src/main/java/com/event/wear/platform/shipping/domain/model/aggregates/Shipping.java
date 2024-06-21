package com.event.wear.platform.shipping.domain.model.aggregates;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.valueobjects.RemainingDays;
import com.event.wear.platform.shipping.domain.model.valueobjects.RentId;
import com.event.wear.platform.shipping.domain.model.valueobjects.TrackingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private RemainingDays remainingDays;

    private String address;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "start_date")
    private LocalDateTime startdate;

    @Enumerated(EnumType.STRING)
    private TrackingStatus trackingstatus;

    @Embedded
    @JoinColumn(name = "rent_id")
    private RentId rentid;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_id")
    private List<ShippingDetails> shippingDetails = new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipping_history_id")
    private ShippingHistory shippingHistory;

    public Shipping() {
    }

    // Constructor
    public Shipping(String address, LocalDateTime deadline, TrackingStatus trackingstatus, LocalDateTime startdate, RemainingDays remainingDays, RentId rentid,List<ShippingDetails> shippingDetails)  {
        this.address = address;
        this.deadline = deadline;
        this.trackingstatus = trackingstatus;
        this.startdate = startdate;
        this.remainingDays = remainingDays;
        this.rentid = rentid;
        this.shippingDetails = shippingDetails;
        //this.shipping_history_id = shipping_history_id;
    }

    // MÃ©todos de negocio

    public void updateStatus() {
        this.trackingstatus = this.trackingstatus.nextStatus();
    }

    public void calculeteremainingDays(LocalDateTime deadline,LocalDateTime startdate ){ this.remainingDays = this.remainingDays.calculate(deadline,startdate);}

    public String getStatus() {
        return this.trackingstatus.name();
    }

    public Long getRentId() {
        return this.rentid.getRentId();
    }

    public long getRemainingDaysValue() {
        return this.remainingDays.getDays();
    }
}