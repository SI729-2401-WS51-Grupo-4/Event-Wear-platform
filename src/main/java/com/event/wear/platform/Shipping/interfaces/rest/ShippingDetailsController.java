package com.event.wear.platform.Shipping.interfaces.rest;

import com.event.wear.platform.Shipping.domain.services.ShippingDetailsCommandService;
import com.event.wear.platform.Shipping.domain.services.ShippingDetailsQueryService;
import com.event.wear.platform.Shipping.domain.model.commands.DeleteDetailsCommand;
import com.event.wear.platform.Shipping.domain.model.commands.CreateDetailsCommand;
import com.event.wear.platform.Shipping.domain.model.queries.GetDetailsByIdUser;
import com.event.wear.platform.Shipping.domain.model.queries.GetAllDetailsQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shipping-details")
public class ShippingDetailsController {

    private final ShippingDetailsCommandService shippingDetailsCommandService;
    private final ShippingDetailsQueryService shippingDetailsQueryService;

    public ShippingDetailsController(ShippingDetailsCommandService shippingDetailsCommandService,
                                     ShippingDetailsQueryService shippingDetailsQueryService) {
        this.shippingDetailsCommandService = shippingDetailsCommandService;
        this.shippingDetailsQueryService = shippingDetailsQueryService;
    }

    @PostMapping("/create/Details")
    public void createDetails(@RequestBody CreateDetailsCommand command) {
        shippingDetailsCommandService.handle(command);
    }

    @DeleteMapping("/delete/Details")
    public void deleteDetails(@RequestBody DeleteDetailsCommand command) {
        shippingDetailsCommandService.handle(command);
    }

    @GetMapping("/Details/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getDetailsByIdUser(@PathVariable long userId, long detailsid) {
        List<Map<String, Object>> details = shippingDetailsQueryService.handle(new GetDetailsByIdUser(userId, detailsid));
        return ResponseEntity.ok(details);
    }

    @GetMapping("/all/Details")
    public ResponseEntity<List<Map<String, Object>>> getAllDetails(@PathVariable long detailsid ) {
        List<Map<String, Object>> allDetails = shippingDetailsQueryService.handle(new GetAllDetailsQuery(detailsid));
        return ResponseEntity.ok(allDetails);
    }
}