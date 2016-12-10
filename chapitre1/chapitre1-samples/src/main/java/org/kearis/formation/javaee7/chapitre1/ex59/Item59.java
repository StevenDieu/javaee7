package org.kearis.formation.javaee7.chapitre1.ex59;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE")
public class Item59 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;
  protected String title;
  protected Float price;
  protected String description;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Item59() {
  }

  public Item59(String title, Float price, String description) {
    this.title = title;
    this.price = price;
    this.description = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}