package egleeck.com;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by egleeck on 5/9/17.
 */
@XmlRootElement(name = "medicine")
public class Medicine {

    private long id;
    private String description;

    public Medicine() {
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
}
