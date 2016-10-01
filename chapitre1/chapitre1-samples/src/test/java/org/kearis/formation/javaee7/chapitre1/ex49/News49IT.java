package org.kearis.formation.javaee7.chapitre1.ex49;

import org.kearis.formation.javaee7.chapitre1.AbstractPersistentTest;
import org.junit.Test;

import javax.persistence.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class News49IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateOneNewsWithFourComments() throws Exception {

    News49 news = new News49("Death of Michael Jackson");
    news.addComment(new Comment49("gonzo", "Third comment", 1, "2009-07-03"));
    news.addComment(new Comment49("elvis", "First comment", 3, "2009-07-01"));
    news.addComment(new Comment49("gonzo", "Second comment", 5, "2009-07-02"));
    news.addComment(new Comment49("elvis", "Fourth comment", 2, "2009-07-06"));

    tx.begin();
    em.persist(news);
    tx.commit();

    tx.begin();
    news = em.find(News49.class, news.getId());

    // Without the refresh the test will not work
    // The OrderBy annotation specifies the ordering of the elements of a collection valued association at the point when the association is retrieved."
    // The key here is the phrase "when the association is retrieved".  In this case, when your find is executed, the association is still managed and no retrieval logic occurs.
    em.refresh(news);

    tx.commit();


    assertEquals("Death of Michael Jackson", news.getContent());
    assertEquals(4, news.getComments().size());
    assertEquals("Fourth comment", news.getComments().get(0).getContent());
    assertEquals("Third comment", news.getComments().get(1).getContent());
    assertEquals("Second comment", news.getComments().get(2).getContent());
    assertEquals("First comment", news.getComments().get(3).getContent());

    em.remove(news);


    /*
    Dans la classe News49 En faite il y a plusieurs cas pour le cascade
    Soit :
     - CascadeType.PERSIST
     et la le test va fonctionner
     - CascadeType.ALL
     et la le test ne fonctionne plus !

     Explication :
     Dans le cas du CascadeType.PERSIST  on va ajouter tous les commentaire en cascade
     mais quand on fait un remove du news ca ne supprimer pas les commentaires

     Dans le cas du CascadeType.PERSIST  on va ajouter tous les commentaire en cascade
     et quand on fait un remove du news ca supprimer les commentaires

     */
    assertNotNull(em.find(Comment49.class, 3L));

  }
}