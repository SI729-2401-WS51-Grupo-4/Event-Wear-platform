package com.event.wear.platform.shipping.application.internal.commandservices;

import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;
import com.event.wear.platform.shipping.domain.model.aggregates.ShippingHistory;
import com.event.wear.platform.shipping.domain.model.commands.CreateShippingCommand;
import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.valueobjects.RemainingDays;
import com.event.wear.platform.shipping.domain.model.valueobjects.RentId;
import com.event.wear.platform.shipping.domain.services.ShippingCommandService;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingDetailsRepository;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingHistoryRepository;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class ShippingCommandsServiceslmpl implements ShippingCommandService {

    /*
    private final ShippingRepository shippingRepository;

    public ShippingCommandsServiceslmpl(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }
    */

    private final ShippingRepository shippingRepository;
    private final ShippingHistoryRepository shippingHistoryRepository;

    @Autowired
    public ShippingCommandsServiceslmpl(ShippingRepository shippingRepository, ShippingHistoryRepository shippingHistoryRepository) {
        this.shippingRepository = shippingRepository;
        this.shippingHistoryRepository = shippingHistoryRepository;
    }

    /*
        @Override
        public void handle(CreateShippingCommand command) {
            RemainingDays remainingDays = new RemainingDays(command.remainingDaysValue());
            RentId rentid = new RentId(command.rentId());

            Shipping newShipping = new Shipping(
                    command.address(),
                    command.deadline(),
                    command.trackingstatus(),
                    command.startdate(),
                    remainingDays,
                    rentid,
                    command.shippingDetailsIds()
            );

            shippingRepository.save(newShipping);
        }
    */
    @Override
    public void handle(CreateShippingCommand command) {
        RemainingDays remainingDays = new RemainingDays(command.remainingDaysValue());
        RentId rentid = new RentId(command.rentId());

        /**
         Si quieres que los ShippingDetails se
         creen automáticamente cuando creas un Shipping,
         necesitarás cambiar tu enfoque. En lugar de buscar
         ShippingDetails existentes, deberías crear nuevos ShippingDetails
         basados en la información proporcionada en el comando.
         */

        List<ShippingDetails> newShippingDetails = command.shippingDetailsIds().stream()
                .map(detailCommand -> new ShippingDetails(detailCommand.getDescription(), detailCommand.getImportancelevel()))
                .collect(Collectors.toList());

        Shipping newShipping = new Shipping(
                command.address(),
                command.deadline(),
                command.trackingstatus(),
                command.startdate(),
                remainingDays,
                rentid,
                newShippingDetails
        );

        ShippingHistory newShippingHistory = new ShippingHistory();
        newShippingHistory.setDescription("Shipping created with ID: " + newShipping.getId());

        //newShipping.setShippingHistory(newShippingHistory);
        //shippingRepository.save(newShipping);

        // Guardar el ShippingHistory antes de crear el Shipping
        shippingHistoryRepository.save(newShippingHistory);

        newShipping.setShippingHistory(newShippingHistory);

        // Guardar el Shipping y obtener la ID generada
        newShipping = shippingRepository.save(newShipping);

        // Establecer la ID del Shipping en ShippingHistory
        //newShippingHistory.setShippingId(newShipping.getId());

        // Guardar el ShippingHistory con la ID del Shipping
        shippingHistoryRepository.save(newShippingHistory);
    }
}