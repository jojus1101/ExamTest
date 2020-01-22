/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.BikeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.BikeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author jojus1101
 */
@Path("bike")
public class BikeResource {
    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final BikeFacade FACADE = BikeFacade.getBikeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello tester\"}";
    }
    @GET
    @Path("populatebike")
    @Produces({MediaType.APPLICATION_JSON})
    public String populateDatabase() {

        FACADE.PopulateDB();
        return "{\"Message\":\"Database ready\"}";
    }
    @GET
    @Path("bikes")
    @Produces({MediaType.APPLICATION_JSON})
    public List<BikeDTO> getBikes() {
        return FACADE.getBikeList();
        
    }
}
