package com.event.wear.platform.shipping.interfaces.rest;

import com.event.wear.platform.shipping.domain.model.commands.CreateHistoryCommand;
import com.event.wear.platform.shipping.domain.services.ShippingHistoryCommandService;
import com.event.wear.platform.shipping.interfaces.rest.resources.CreateItemtoShippingHistory;
import com.event.wear.platform.shipping.interfaces.rest.transform.CreateShippingHistoryResourseFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class ShippingHistoryController {

/*
    private final ShippingHistoryCommandService shippingHistoryCommandService;

    @Autowired
    public ShippingHistoryController(ShippingHistoryCommandService shippingHistoryCommandService) {
        this.shippingHistoryCommandService = shippingHistoryCommandService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createShippingHistory(@RequestBody CreateItemtoShippingHistory resource) {
        CreateHistoryCommand command = CreateShippingHistoryResourseFromResourceAssembler.toCommandFromResource(resource);
        shippingHistoryCommandService.handle(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
*/
}
