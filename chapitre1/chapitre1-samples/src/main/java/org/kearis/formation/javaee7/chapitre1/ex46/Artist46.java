package org.kearis.formation.javaee7.chapitre1.ex46;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist46 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

  @ManyToMany
  @JoinTable(name = "jnd_art_cd",
          joinColumns = @JoinColumn(name = "artist_fk"),
          inverseJoinColumns = @JoinColumn(name = "cd_fk"))
  private List<CD46> appearsOnCDs;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Artist46() {
  }

  public Artist46(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<CD46> getToto() {
    return appearsOnCDs;
  }

  public void setAppearsOnCDs(List<CD46> appearsOnCDs) {
    this.appearsOnCDs = appearsOnCDs;
  }

  public void appearsOn(CD46 cd) {
    if (appearsOnCDs == null)
      appearsOnCDs = new ArrayList<CD46>();
    appearsOnCDs.add(cd);
  }

}