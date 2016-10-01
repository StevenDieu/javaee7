package org.kearis.formation.javaee7.chapitre5;

import java.io.Serializable;
import java.util.Date;

public class OrderDTO implements Serializable {

    private Long orderId;
    private Date creationDate;
    private String customerName;
    private Float totalAmount;

    // ======================================
    // =            Constructors            =
    // ======================================

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Date creationDate, String customerName, Float totalAmount) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OrderDTO");
        sb.append("{orderId=").append(orderId);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", totalAmount=").append(totalAmount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return orderId.equals(((OrderDTO)obj).orderId);
    }
}