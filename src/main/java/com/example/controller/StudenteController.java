package com.example.controller;

import com.example.model.Studente;
import com.example.service.StudenteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/studenti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudenteController {

    @Inject
    StudenteService studenteService;

    // GET ALL
    @GET
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    // GET BY ID
    @GET
    @Path("/{id}")
    public Response getStudenteById(@PathParam("id") Long id) {
        Studente studente = studenteService.getStudenteById(id);
        if (studente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(studente).build();
    }

    // CREATE
    @POST
    public Response createStudente(Studente studente) {
        Studente nuovoStudente = studenteService.createStudente(studente);
        return Response.status(Response.Status.CREATED).entity(nuovoStudente).build();
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Response updateStudente(@PathParam("id") Long id, Studente studente) {
        Studente updated = studenteService.updateStudente(id, studente);
        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteStudente(@PathParam("id") Long id) {
        boolean deleted = studenteService.deleteStudente(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}