package com.event.wear.platform.shipping.application.internal.queryservices;

import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;
import com.event.wear.platform.shipping.domain.model.queries.GetAllShippingsByHistoryIdQuery;
import com.event.wear.platform.shipping.domain.services.ShippingQueryService;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingRepository;
import org.springframework.stereotype.Service;

import com.event.wear.platform.shipping.domain.model.queries.GetAllShippingsQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShippingQueryServiceslmpl implements ShippingQueryService {

    private final ShippingRepository shippingRepository;

    public ShippingQueryServiceslmpl(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Override
    public List<Map<String, Object>> handle(GetAllShippingsQuery query) {
        List<Shipping> allShippings = shippingRepository.findAll();

        // Convertir la lista de envíos a una lista de mapas para cumplir con la firma del método
        List<Map<String, Object>> result = allShippings.stream()
                .map(shipping -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", shipping.getId());
                    map.put("address", shipping.getAddress());
                    map.put("deadline", shipping.getDeadline());
                    map.put("startdate", shipping.getStartdate());
                    map.put("trackingstatus", shipping.getTrackingstatus());
                    map.put("remainingDaysValue", shipping.getRemainingDaysValue());
                    map.put("rentId", shipping.getRentId());

                    // Añadir los shippingDetails al mapa
                    List<Map<String, Object>> shippingDetailsList = shipping.getShippingDetails().stream()
                            .map(detail -> {
                                Map<String, Object> detailMap = new HashMap<>();
                                detailMap.put("id", detail.getId());
                                detailMap.put("description", detail.getDescription());
                                detailMap.put("importancelevel", detail.getImportancelevel());
                                return detailMap;
                            })
                            .collect(Collectors.toList());
                    map.put("shippingDetails", shippingDetailsList);

                    return map;
                })
                .collect(Collectors.toList());

        return result;
    }


    @Override
    public List<Shipping> handle(GetAllShippingsByHistoryIdQuery query) {
        return shippingRepository.findShippingByShippingHistory_Id(query.shippingHistoryId());
    }
}