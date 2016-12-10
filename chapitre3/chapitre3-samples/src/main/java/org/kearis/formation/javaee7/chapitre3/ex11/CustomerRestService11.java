package org.kearis.formation.javaee7.chapitre3.ex11;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/11/customer")
public class CustomerRestService11 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  //TODO define method that returns customer as plain text
  @GET
  @Produces({MediaType.TEXT_PLAIN})
  public Response getAsPlainText() {
    Customer11 customer = new Customer11("John","Smith","jsmith@gmail.com","1234565");
    return Response.ok(customer.toString()).build();
  }

  //TODO define method that returns customer as plain text
  @GET
  @Produces({MediaType.TEXT_HTML})
  public Response getAsHtml() {
    Customer11 customer = new Customer11("John","Smith","jsmith@gmail.com","1234565");

    return Response.ok(customer.toString()).build();
  }

  //TODO define method that returns customer as json or xml
  public Response getAsJsonAndXML() {
    return Response.ok(new Customer11("John", "Smith", "jsmith@gmail.com", "1234565")).build();
  }

}