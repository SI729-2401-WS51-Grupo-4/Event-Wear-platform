package com.event.wear.platform.Shipping.interfaces.rest.transform;

import com.event.wear.platform.Shipping.domain.model.commands.CreateDetailsCommand;
import com.event.wear.platform.Shipping.interfaces.rest.resources.CreateDetaildsResource;

public class CreateDetaildsResourceFromResourceAssembler {

    public static CreateDetailsCommand toCommandFromResource(CreateDetaildsResource resource) {
        return new CreateDetailsCommand( resource.descripcion(), resource.importancelevel());
    }

}
