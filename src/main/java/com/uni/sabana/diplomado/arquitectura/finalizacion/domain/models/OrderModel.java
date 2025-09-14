package com.uni.sabana.diplomado.arquitectura.finalizacion.domain.models;

public class OrderModel {

    private Long id;
    private String name;
    private Integer quantity;
    private String idTransaction;
    private String podName;

    public OrderModel( ) { }

    public OrderModel(
            Long id,
            String name,
            Integer quantity,
            String idTransaction,
            String podName) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.idTransaction = idTransaction;
        this.podName = podName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }
}
