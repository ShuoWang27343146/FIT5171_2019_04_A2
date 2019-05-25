package rockets.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notNull;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.description;

public class Payload {

    private String type;

    private Set<String> identity;

    private int weight;
    private String description;

    public Payload(){
        type="";
        identity=new Set<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        weight=0;
        description="";
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
        if(type.trim().isEmpty())
            throw new IllegalArgumentException("The validated object is null");
        this.type = type;
    }

    public void setDescription(String description) {
        notNull(description);
        if(description.trim().isEmpty())
            throw new IllegalArgumentException("The validated object is null");
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }
}
