package egleeck.com;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by egleeck on 5/9/17.
 */
@Produces({"application/xml","application/json"})
public interface PatientService {

    @POST
    @Path("/patients")
    public Response addPatient(Patient patient);

    @GET
    @Path("/patients/{id}")
    public Patient getPatient(@PathParam("id") String id);

    @GET
    @Path("/patients")
    public Collection<Patient> getAllPatients();

    @PUT
    @Path("/patients/")
    public Response updatePatient(Patient updatePatient);

    @DELETE
    @Path("/patients/{id}")
    @RolesAllowed({"ADMIN"})
    public Response deletePatient(@Context SecurityContext sc, @PathParam("id") String id);

    @Path("/prescriptions/{id}")
    public Prescription getPrescription(@PathParam("id") String id);
}
