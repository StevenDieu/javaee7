package org.kearis.formation.javaee7.chapitre2.ex09;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kearis.formation.javaee7.chapitre2.AbstractEJBTest;
import org.kearis.formation.javaee7.chapitre2.ex01.BookEJBRemote01;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CacheEJB09IT extends AbstractEJBTest {


  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldAddRemoveAndGetThingsFromTheCache() throws Exception {

    Object ejb = ctx.lookup("java:global/chapitre2-samples-1.0.0-SNAPSHOT/CacheEJB09");
    assertNotNull(ejb);

    // Looks up the EJB
    CacheEJBRemote09 cacheEJB = (CacheEJBRemote09) PortableRemoteObject.narrow(ejb, CacheEJBRemote09.class);

    // Clear cache
    cacheEJB.clearCache();

    // Checks the cache is empty
    assertEquals("Cache should have no items", new Integer(0), cacheEJB.getNumberOfItems());

    // Adds one item to the cache
    cacheEJB.addToCache(1L, "First item in the cache");
    assertEquals("Cache should have one item", new Integer(1), cacheEJB.getNumberOfItems());
    assertEquals("First item in the cache", "First item in the cache", cacheEJB.getFromCache(1L));

    // Adds another item to the cache
    cacheEJB.addToCache(2L, "Second item in the cache");
    assertEquals("Cache should have two items", new Integer(2), cacheEJB.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cacheEJB.getFromCache(2L));

    // Removes the first item from the cache
    cacheEJB.removeFromCache(1L);
    assertEquals("Cache should have one item", new Integer(1), cacheEJB.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cacheEJB.getFromCache(2L));
  }
}