package com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.adaptaers.in.controller;

import com.uni.sabana.diplomado.arquitectura.finalizacion.application.service.OrderService;
import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.models.OrderModel;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectNotFoundException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectSaveException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.adaptaers.out.repostory.JpaOrderRepository;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.dto.OrderDto;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    private final OrderMapper mapper;

    @GetMapping
    public List<OrderDto> findAll() {
        return service.findAll().stream()
                .map(mapper::orderModelToOrderDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderDto findOne(@PathVariable Long id) throws ObjectNotFoundException {
        return service.findById(id) != null ?
                mapper.orderModelToOrderDto(service.findById(id)) : null;
    }

    @PostMapping
    public OrderModel save(@RequestBody OrderDto orderModel) throws ObjectSaveException {
        return service.save(mapper.orderDtoToOrderModel(orderModel));
    }
}
