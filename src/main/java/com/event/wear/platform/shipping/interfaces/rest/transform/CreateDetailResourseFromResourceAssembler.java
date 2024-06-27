package com.event.wear.platform.shipping.interfaces.rest.transform;

import com.event.wear.platform.shipping.domain.model.commands.CreateDetailsCommand;
import com.event.wear.platform.shipping.interfaces.rest.resources.CreateItemtoDetailResource;

public class CreateDetailResourseFromResourceAssembler {

    public static CreateDetailsCommand toCommandFromResource(CreateItemtoDetailResource resource) {
        return new CreateDetailsCommand(
                resource.description(),
                resource.importancelevel()
        );
    }
}