package egleeck.com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by egleeck on 5/9/17.
 */
@XmlRootElement(name = "Prescription")
public class Prescription {

    private long id;
    private String description;
    private Map<Long, Medicine> medicines;


    public Prescription() {
        init();
    }

    private void init() {
        medicines = new HashMap<>();
        Medicine med = new Medicine();
        med.setId(1);
        med.setDescription("MedicineA");
        medicines.put(med.getId(), med);


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @GET
    @Path("/medicines/{id}")
    public Medicine getMedicine(@PathParam("id") String id) {
        return medicines.get(Long.parseLong(id));
    }
}
