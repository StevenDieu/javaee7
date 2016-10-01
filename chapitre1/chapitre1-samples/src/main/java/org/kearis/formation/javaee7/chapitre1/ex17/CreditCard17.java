package org.kearis.formation.javaee7.chapitre1.ex17;

import javax.persistence.*;

@Entity
public class CreditCard17 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String number;
  private String expiryDate;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer controlNumber;

  @Enumerated(EnumType.STRING)
  private CreditCardType17 creditCardType;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CreditCard17() {
  }

  public CreditCard17(String number, String expiryDate, Integer controlNumber, CreditCardType17 creditCardType) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.creditCardType = creditCardType;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Integer getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
  }

  public CreditCardType17 getType() {
    return creditCardType;
  }

  public void setType(CreditCardType17 creditCardType) {
    this.creditCardType = creditCardType;
  }
}
