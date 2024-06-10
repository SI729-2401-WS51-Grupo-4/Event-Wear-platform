package com.event.wear.platform.Shipping.interfaces.rest;

import com.event.wear.platform.Shipping.domain.services.*;
import com.event.wear.platform.Shipping.domain.model.commands.*;
import com.event.wear.platform.Shipping.domain.model.queries.*;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsByUserIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingCommandService shippingCommandService;
    private final ShippingQueryService shippingQueryService;

    public ShippingController(ShippingCommandService shippingCommandService,
                              ShippingQueryService shippingQueryService) {
        this.shippingCommandService = shippingCommandService;
        this.shippingQueryService = shippingQueryService;

    }

    @PostMapping("/create/Shipping")
    public void createShipping(@RequestBody CreateShippingCommand command) {
        shippingCommandService.handle(command);
    }

    @PostMapping("/cancel/shipping/{shippingId}")
    public void cancelShipping(@PathVariable long shippingId) {
        CancelShippingCommand command = new CancelShippingCommand(shippingId);
        shippingCommandService.handle(command);
    }

    @PostMapping("/add/shipping/{detailsId}/{shippingId}")
    public void addDetailsToShipping(@PathVariable long detailsId, @PathVariable long shippingId) {
        AddDetailsToShippingCommand command = new AddDetailsToShippingCommand(detailsId, shippingId);
        shippingCommandService.handle(command);
    }

    @GetMapping("/all/shippingId")
    public ResponseEntity<List<Map<String, Object>>> getAllShippings(@RequestParam long userId) {
        List<Map<String, Object>> shippings = shippingQueryService.handle(new GetAllShippingsQuery(userId));
        return ResponseEntity.ok(shippings);
    }
}