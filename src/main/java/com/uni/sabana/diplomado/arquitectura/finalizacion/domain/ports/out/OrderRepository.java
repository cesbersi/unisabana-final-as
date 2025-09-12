package com.uni.sabana.diplomado.arquitectura.finalizacion.domain.ports.out;

import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.models.OrderModel;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectNotFoundException;
import com.uni.sabana.diplomado.arquitectura.finalizacion.exception.ObjectSaveException;

import java.util.List;

public interface OrderRepository {

    List<OrderModel> findAll();
    OrderModel findById( Long id) throws ObjectNotFoundException;
    OrderModel save(OrderModel orderModel) throws ObjectSaveException;
}
