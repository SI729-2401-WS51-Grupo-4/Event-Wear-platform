package com.event.wear.platform.Shipping.interfaces.rest;

import com.event.wear.platform.Shipping.domain.services.ShippingHistoryCommandService;
import com.event.wear.platform.Shipping.domain.services.ShippingHistoryQueryService;
import com.event.wear.platform.Shipping.domain.model.commands.CreateShippingHistoryCommand;
import com.event.wear.platform.Shipping.domain.model.commands.AddShippingToShippingHisotryCommand;
import com.event.wear.platform.Shipping.domain.model.queries.GetAllShippingHistoryByIdUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shipping-history")
public class ShippingHistoryController {

    private final ShippingHistoryCommandService shippingHistoryCommandService;
    private final ShippingHistoryQueryService shippingHistoryQueryService;

    public ShippingHistoryController(ShippingHistoryCommandService shippingHistoryCommandService,
                                     ShippingHistoryQueryService shippingHistoryQueryService) {
        this.shippingHistoryCommandService = shippingHistoryCommandService;
        this.shippingHistoryQueryService = shippingHistoryQueryService;
    }

    @PostMapping("/create/ShippingHistory")
    public void createShippingHistory(@RequestBody CreateShippingHistoryCommand command) {
        shippingHistoryCommandService.handle(command);
    }

    @PostMapping("/add/ShippingHistory")
    public void addShippingToHistory(@RequestBody AddShippingToShippingHisotryCommand command) {
        shippingHistoryCommandService.handle(command);
    }

    @GetMapping("/ShippingHistory/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getAllShippingHistoryByIdUser(@PathVariable long userId, long shippingid) {
        List<Map<String, Object>> shippingHistory = shippingHistoryQueryService.handle(new GetAllShippingHistoryByIdUser(userId,shippingid ));
        return ResponseEntity.ok(shippingHistory);
    }
}