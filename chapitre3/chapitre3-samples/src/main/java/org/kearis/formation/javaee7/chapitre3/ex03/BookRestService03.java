package org.kearis.formation.javaee7.chapitre3.ex03;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.ws.ResponseWrapper;

//TODO add Path
@Path("/03/book")
public class BookRestService03 {

    // ======================================
    // =           Public Methods           =
    // ======================================

    //TODO add http method
    @GET
    //TODO define responses type
    @Produces("text/plain")
    public String getBookTitle() {
        return "H2G2";
    }
}