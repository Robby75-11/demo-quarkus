package com.example.controller;

import com.example.model.Corso;
import com.example.service.CorsoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/corsi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorsoController {

    @Inject
    CorsoService corsoService;

    // 📌 GET ALL
    @GET
    public List<Corso> getAll() {
        return corsoService.getAllCorsi();
    }

    // 📌 GET BY ID
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Corso corso = corsoService.getCorsoById(id);

        if (corso == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(corso).build();
    }

    // 📌 CREATE
    @POST
    public Response create(Corso corso) {
        Corso created = corsoService.createCorso(corso);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // 📌 UPDATE
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Corso corso) {
        Corso updated = corsoService.updateCorso(id, corso);

        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(updated).build();
    }

    // 📌 DELETE
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = corsoService.deleteCorso(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }
}