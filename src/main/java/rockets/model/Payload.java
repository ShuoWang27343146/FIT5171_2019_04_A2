package rockets.model;

import java.util.Set;

import static org.apache.commons.lang3.Validate.notNull;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.description;

public class Payload {

    private String type;

    private Set<String> identity;

    private int weight;
    private String description;

    public Payload(){
        notNull(type);
        PayloadValidation.NotZero(weight);

        this.type = type;
        this.identity = identity;
        this.weight = weight;
    }

    public String getType(){
        return type;
    }

    public int getWeight(){

        return weight;
    }

    public void setIdentity(Set<String> identity){

        notNull(identity);
        PayloadValidation.isEmpty(identity);

        this.identity = identity;
    }

    public Set<String> getIdentity(){
        notNull(identity);
        PayloadValidation.isEmpty(identity);
        return identity;
    }

    public void setType(String type) {
        notNull(type);
        this.type = type;
    }

    public void setDescription(String description) {
        notNull(description);
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }
}
