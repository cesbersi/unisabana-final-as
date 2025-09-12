package com.uni.sabana.diplomado.arquitectura.finalizacion.application.service;

import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.models.OrderModel;
import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.ports.out.OrderRepository;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectNotFoundException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectSaveException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.adaptaers.out.repostory.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderModel save(OrderModel orderModel) throws ObjectSaveException {
        return orderRepository.save(orderModel);
    }

    public OrderModel findById(Long id) throws ObjectNotFoundException {
        return orderRepository.findById(id);
    }

    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }
}
