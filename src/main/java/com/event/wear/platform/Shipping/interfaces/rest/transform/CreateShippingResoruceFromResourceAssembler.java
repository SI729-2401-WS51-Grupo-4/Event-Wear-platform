package com.event.wear.platform.Shipping.interfaces.rest.transform;


import com.event.wear.platform.Shipping.domain.model.commands.CreateShippingCommand;
import com.event.wear.platform.Shipping.interfaces.rest.resources.CreateShippingResource;

public class CreateShippingResoruceFromResourceAssembler {

    public static CreateShippingCommand toCommandFromResource(CreateShippingResource resource) {
        return new CreateShippingCommand( resource.addres(), resource.deadeline(), resource.starday(), resource.rentid(),
                resource.shippingdetalid(), resource.trackingstatus(), resource.userid());
    }

}

