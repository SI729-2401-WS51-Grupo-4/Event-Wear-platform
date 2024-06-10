package com.event.wear.platform.Shipping.domain.model.aggregates;

import com.event.wear.platform.Shipping.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private LocalDateTime deadline;

    private LocalDateTime startdate;

    @Enumerated(EnumType.STRING)
    private TrackingStatus trackingstatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserId userid;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private RentId rentid;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_Details")
    private List<com.event.wear.platform.Shipping.domain.model.entities.ShippingDetails> ShippingDetails = new ArrayList<>();

    // Constructor
    public Shipping(String address, LocalDateTime deadline, TrackingStatus trackingstatus, UserId userid, LocalDateTime startdate) {
        this.address = address;
        this.deadline = deadline;
        this.trackingstatus = trackingstatus;
        this.startdate = startdate;
        this.userid = userid;
    }

    // Métodos de negocio

    public void updateStatus() {
        this.trackingstatus = this.trackingstatus.nextStatus();
    }

    public void calculeteremainingDays(LocalDateTime deadline,LocalDateTime startdate ){ this.remainingDays = this.remainingDays.calculate(deadline,startdate);}

    public String getStatus() {
        return this.trackingstatus.name();
    }

    public Long getUserId() {
        return this.rentid.getRentId();
    }
}
