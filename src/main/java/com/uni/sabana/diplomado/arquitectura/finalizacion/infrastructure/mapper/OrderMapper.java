package com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.mapper;

import com.uni.sabana.diplomado.arquitectura.finalizacion.domain.models.OrderModel;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.dto.OrderDto;
import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderModel orderEntityToOrderModel(OrderEntity orderEntity);
    OrderEntity orderModelToOrderEntity(OrderModel orderModel);
    OrderDto orderModelToOrderDto(OrderModel orderModel);
    OrderModel orderDtoToOrderModel(OrderDto orderDto);
}
