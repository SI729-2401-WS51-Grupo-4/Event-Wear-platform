package com.event.wear.platform.Shipping.domain.model.valueobjects;

public enum TrackingStatus {
    PACKAGING{
        @Override
        public TrackingStatus nextStatus() {
            return ONTHEWAY;
        }
    },
    ONTHEWAY {
        @Override
        public TrackingStatus nextStatus() {
            return DELIVERED;
        }
    },
    DELIVERED{
        @Override
        public TrackingStatus nextStatus() {
            return this; // No hay siguiente estado después de ENTREGADO
        }
    },
    CANCELLED{
        @Override
        public TrackingStatus nextStatus() {
            return this;
        }
    };

    public abstract TrackingStatus nextStatus();

}
