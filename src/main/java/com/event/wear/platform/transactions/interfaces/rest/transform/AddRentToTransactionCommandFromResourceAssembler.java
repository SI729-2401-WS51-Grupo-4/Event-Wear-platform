package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.commands.AddRentToTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionCommand;
import com.event.wear.platform.transactions.interfaces.rest.resources.AddRentToTransactionResource;

public class AddRentToTransactionCommandFromResourceAssembler {
    public static AddRentToTransactionCommand toCommandFromResource(AddRentToTransactionResource resource){
        return new AddRentToTransactionCommand(resource.rentId(), resource.transactionId());
    }
}
