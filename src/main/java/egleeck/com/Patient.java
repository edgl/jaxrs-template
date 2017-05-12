package egleeck.com;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by egleeck on 5/9/17.
 */
@XmlRootElement(name = "Patient")
public class Patient {

    private String name;
    private Long Id;

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public static Patient createNewPatient(Long id, final String name) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setId(id);

        return patient;
    }
}
