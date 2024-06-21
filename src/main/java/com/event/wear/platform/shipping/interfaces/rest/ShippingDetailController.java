package com.event.wear.platform.shipping.interfaces.rest;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.queries.GetAllDetailsByShippingIdQuery;
import com.event.wear.platform.shipping.domain.services.ShippingDetailsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.event.wear.platform.shipping.domain.model.commands.CreateDetailsCommand;
import com.event.wear.platform.shipping.interfaces.rest.resources.CreateItemtoDetailResource;
import com.event.wear.platform.shipping.interfaces.rest.transform.CreateDetailResourseFromResourceAssembler;
import com.event.wear.platform.shipping.domain.services.ShippingDetailsCommandService;

import java.util.List;

@RestController
@RequestMapping("/shippingDetails")
public class ShippingDetailController {

    private final ShippingDetailsCommandService shippingDetailsCommandService;
    private final ShippingDetailsQueryService shippingDetailsQueryService;

    @Autowired
    public ShippingDetailController(ShippingDetailsCommandService shippingDetailsCommandService, ShippingDetailsQueryService shippingDetailsQueryService) { //
        this.shippingDetailsCommandService = shippingDetailsCommandService;
        this.shippingDetailsQueryService = shippingDetailsQueryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createShippingDetail(@RequestBody CreateItemtoDetailResource resource) {
        CreateDetailsCommand command = CreateDetailResourseFromResourceAssembler.toCommandFromResource(resource);
        shippingDetailsCommandService.handle(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{shippingId}")
    public ResponseEntity<List<ShippingDetails>> getAllDetailsByShippingId(@PathVariable Long shippingId) {
        GetAllDetailsByShippingIdQuery query = new GetAllDetailsByShippingIdQuery(shippingId);
        List<ShippingDetails> details = shippingDetailsQueryService.handle(query);
        return ResponseEntity.ok(details);
    }

}