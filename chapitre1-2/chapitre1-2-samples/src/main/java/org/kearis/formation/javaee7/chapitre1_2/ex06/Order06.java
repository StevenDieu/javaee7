package org.kearis.formation.javaee7.chapitre1_2.ex06;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

//@ChronologicalDates
public class Order06 {

  // ======================================
  // =             Attributes             =
  // ======================================

//  @NotNull
//  @Pattern(regexp = "[C,D,M][A-Z][0-9]*")
  private String orderId;
  private Date creationDate;
//  @NotNull
//  @Min(1)
  private Double totalAmount;
  private Date paymentDate;
  private Date deliveryDate;
  private List<OrderLine06> orderLines;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order06() {
  }

  public Order06(Date creationDate) {
    this.creationDate = creationDate;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public Double calculateTotalAmount(/*@GreaterThanZero*/ Double changeRate) {
    return 1d;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<OrderLine06> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine06> orderLines) {
    this.orderLines = orderLines;
  }
}