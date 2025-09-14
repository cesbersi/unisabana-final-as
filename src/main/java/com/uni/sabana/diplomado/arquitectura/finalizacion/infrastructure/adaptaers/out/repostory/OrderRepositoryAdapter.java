package com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.adaptaers.out.repostory;

import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.models.OrderModel;
import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.ports.out.OrderRepository;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectNotFoundException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectSaveException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.entity.OrderEntity;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    @Value("${pod}")
    private String podName;

    private final JpaOrderRepository jpaOrderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderModel> findAll() {
        return jpaOrderRepository.findAll()
                .stream()
                .map(orderMapper::orderEntityToOrderModel)
                .collect(Collectors.toList());
    }

    @Override
    public OrderModel findById(Long id) throws ObjectNotFoundException {
        return jpaOrderRepository.findById(id)
                .map(orderMapper::orderEntityToOrderModel)
                .orElseThrow(() -> new ObjectNotFoundException("Order not found with id: " + id));
    }

    @Override
    public OrderModel save(OrderModel orderModel) throws ObjectSaveException {

        try {
            orderModel.setIdTransaction(UUID.randomUUID().toString());
            orderModel.setPodName(podName);
            final OrderEntity order = jpaOrderRepository.save(orderMapper.orderModelToOrderEntity(
                    orderModel
            ));
            return orderMapper.orderEntityToOrderModel(order);
        } catch (Exception e) {
            throw new ObjectSaveException("Error saving Order: " + e.getMessage());
        }
    }
}
