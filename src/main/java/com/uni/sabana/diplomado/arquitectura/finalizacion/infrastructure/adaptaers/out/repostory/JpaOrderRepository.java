package com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.adaptaers.out.repostory;

import com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
