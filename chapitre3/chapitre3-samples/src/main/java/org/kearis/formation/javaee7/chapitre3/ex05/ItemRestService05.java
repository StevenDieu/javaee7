package org.kearis.formation.javaee7.chapitre3.ex05;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//TODO add Path
@Path("/05/items")
public class ItemRestService05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  //TODO Inject context URI Information
  @Inject
  private UriInfo uriInfo;

  // ======================================
  // =           Public Methods           =
  // ======================================

  /**
   * curl http://localhost:8080/chapitre3-service-1.0/rs/05/items
   */
  //TODO define simple method that returns an item
  @GET
  public Items05 getItems() {
    return new Items05();
  }

  /**
   * curl http://localhost:8080/chapitre3-service-1.0/rs/05/items/books
   */
  //TODO define simple method that returns few books
  @GET
  @Path("/books")
  public List<Book05> getBooks() {
      List<Book05> listBook = new ArrayList<>();
      listBook.add(new Book05());
      listBook.add(new Book05());
      return listBook;
  }

  /**
   * curl http://localhost:8080/chapitre3-service-1.0/rs/05/items/books/1234
   */
  //TODO define HTTP method
  @GET
  //TODO define the path parameter
  //TODO the path parameter must be a numeric value : USE pattern in @Path annotation
  @Path("/books/{id : \\d+}")
  public Book05 getBook(@PathParam("id") String id) {
    System.out.println("getBook : " + id);
    return new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
  }

  /**
   * curl -X POST http://localhost:8080/chapitre3-service-1.0/rs/05/items/books
   */
  //TODO define HTTP method
  @POST
  //TODO define the path
  @Path("/books")
  public Response createBook(Book05 book) {
    System.out.println("createBook");
    book.setId(123L);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  /**
   * curl -X DELETE http://localhost:8080/chapitre3-service-1.0/rs/05/items/1234
   */
  //TODO define HTTP method
  @DELETE
  //TODO define the path parameter
  //TODO the path parameter must be a numeric value : USE pattern in @Path annotation
  @Path("/books/{id : \\d+}")
  public Response deleteBook(@PathParam("id") String id) {
    System.out.println("deleteBook : " + id);
    return Response.noContent().build();
  }
}
