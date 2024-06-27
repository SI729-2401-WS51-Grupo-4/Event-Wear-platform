package com.event.wear.platform.shipping.application.internal.commandservices;

import com.event.wear.platform.shipping.domain.model.commands.CreateDetailsCommand;
import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.services.ShippingDetailsCommandService;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingDetailsRepository;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShippingDetailsCommandServiceslmpl implements ShippingDetailsCommandService {

    private final ShippingDetailsRepository shippingDetailsRepository;
    private final ShippingRepository shippingRepository;

    /*
    public ShippingDetailsCommandServiceslmpl(ShippingDetailsRepository shippingDetailsRepository) {
        this.shippingDetailsRepository = shippingDetailsRepository;
    }
    */

    public ShippingDetailsCommandServiceslmpl(ShippingDetailsRepository shippingDetailsRepository, ShippingRepository shippingRepository) {
        this.shippingDetailsRepository = shippingDetailsRepository;
        this.shippingRepository = shippingRepository;
    }

    @Override
    public void handle(CreateDetailsCommand command) {
        ShippingDetails shippingDetails = new ShippingDetails(command.description(), command.importancelevel());
        shippingDetailsRepository.save(shippingDetails);
    }
}
