package org.kearis.formation.javaee7.chapitre1.ex51;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class News51 {

  // ======================================
  // =             Attributes             =
  // ======================================


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String content;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "comment_line",
          joinColumns = @JoinColumn(name = "comments_fk"),
          inverseJoinColumns = @JoinColumn(name = "comment49_fk"))
  private List<Comment51> comments;

  // ======================================
  // =            Constructors            =
  // ======================================

  public News51() {
  }

  public News51(String content) {
    this.content = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void addComment(Comment51 comment) {
    if (comments == null)
      comments = new ArrayList<Comment51>();
    comments.add(comment);
  }

  public List<Comment51> getComments() {
    return comments;
  }
}