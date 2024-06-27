package com.event.wear.platform.shipping.interfaces.rest;

import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;
import com.event.wear.platform.shipping.domain.model.commands.CreateShippingCommand;
import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.queries.GetAllDetailsByShippingIdQuery;
import com.event.wear.platform.shipping.domain.model.queries.GetAllShippingsByHistoryIdQuery;
import com.event.wear.platform.shipping.domain.model.queries.GetAllShippingsQuery;
import com.event.wear.platform.shipping.domain.services.ShippingCommandService;
import com.event.wear.platform.shipping.domain.services.ShippingQueryService;
import com.event.wear.platform.shipping.interfaces.rest.resources.CreateItemToShippingResource;
import com.event.wear.platform.shipping.interfaces.rest.transform.CreateShippingResoruceFromResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shippings")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ShippingController {

    private final ShippingCommandService shippingCommandService;
    private final ShippingQueryService shippingQueryService;

    @Autowired
    public ShippingController(ShippingCommandService shippingCommandService, ShippingQueryService shippingQueryService) {
        this.shippingCommandService = shippingCommandService;
        this.shippingQueryService = shippingQueryService;
    }

    @PostMapping("/create/Shipping")
    public ResponseEntity<Void> createShipping(@RequestBody CreateItemToShippingResource resource) {
        CreateShippingCommand command = CreateShippingResoruceFromResourceAssembler.toCommandFromResource(resource);
        shippingCommandService.handle(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllShippings() {
        GetAllShippingsQuery query = new GetAllShippingsQuery();
        List<Map<String, Object>> allShippings = shippingQueryService.handle(query);
        return ResponseEntity.ok(allShippings);
    }


    @GetMapping("/history/{historyId}")
    @Transactional
    public ResponseEntity<List<Shipping>> getAllShippingsByHistoryId(@PathVariable Long historyId) {
        GetAllShippingsByHistoryIdQuery query = new GetAllShippingsByHistoryIdQuery(historyId);
        List<Shipping> shippings = shippingQueryService.handle(query);
        return ResponseEntity.ok(shippings);
    }
}