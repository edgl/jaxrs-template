package egleeck.com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Security;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by egleeck on 5/9/17.
 */
public class PatientServiceImpl implements PatientService {

    private long currentId = 23;
    private Map<Long, Patient> patients;
    private Map<Long, Prescription> prescriptions;
    public PatientServiceImpl() {
        init();
    }

    private void init() {
        patients = new HashMap<>();
        Patient p1 = Patient.createNewPatient(currentId++, "Edward Gleeck");
        Patient p2 = Patient.createNewPatient(currentId++, "James Comey");
        Patient p3 = Patient.createNewPatient(currentId++, "Ryan Seacrest");
        Patient p4 = Patient.createNewPatient(currentId++, "Scarlet Johansen");
        Patient p5 = Patient.createNewPatient(currentId++, "Tom Cruise");
        patients.put(p1.getId(), p1);
        patients.put(p2.getId(), p2);
        patients.put(p3.getId(), p3);
        patients.put(p4.getId(), p4);
        patients.put(p5.getId(), p5);

        prescriptions = new HashMap<>();
        Prescription prescription = new Prescription();
        prescription.setDescription("My Prescriptions");
        prescription.setId(1);
        prescriptions.put(prescription.getId(), prescription);

    }

    @Override
    public Response addPatient(Patient patient) {
        System.out.println("...invoking add patient Patient name is: " + patient.getName());
        patient.setId(currentId++);
        patients.put(patient.getId(), patient);
        return Response.ok(patient).build();
    }

    @Override
    public Patient getPatient(String id) {
        System.out.println("...Getting all patients...");
        if(patients.containsKey(Long.parseLong(id))) {
            return patients.get(Long.parseLong(id));
        }
        return null;
    }

    @Override
    public Collection<Patient> getAllPatients() {
        return patients.values();
    }

    @Override
    public Response updatePatient(Patient updatePatient) {
        return Response.ok().build();
    }

    @Override
    public Response deletePatient(SecurityContext sc, String id) {
        System.out.println(String.format("...invoking delete patient Patient id is %s: ", id));
        System.out.println(String.format("...invoking delete patient Patient id is %s: ;deleted by %s", id, sc.getUserPrincipal().getName()));
        Long patientId = Long.parseLong(id);
        if(patients.containsKey(patientId)) {
            patients.remove(patientId);
            return Response.ok().build();
        }
        else {
            return Response.noContent().build();
        }
    }

    @Override
    public Prescription getPrescription(String id) {
        Prescription prescription = null;
        if(prescriptions.containsKey(Long.parseLong(id)))
            prescription = prescriptions.get(Long.parseLong(id));

        return prescription;
    }
}
