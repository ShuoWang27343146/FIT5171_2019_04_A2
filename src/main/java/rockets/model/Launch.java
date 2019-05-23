package rockets.model;

import org.neo4j.ogm.annotation.CompositeIndex;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;
import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@NodeEntity
@CompositeIndex(properties = {"launchDate", "launchVehicle", "launchSite", "orbit"}, unique = true)
public class Launch extends Entity {

    public enum LaunchOutcome {
        FAILED, SUCCESSFUL
    }

    @Property(name = "launchDate")
    private LocalDate launchDate;

    @Relationship(type = "PROVIDES", direction = INCOMING)
    private Rocket launchVehicle;

    /*private Set<String> payload;

    public void setPayload(Set<String> payload) {
        this.payload = payload;
    }

    public Set<String> getPayload() {
        notNull(payload);
        return payload;
    }
    */

    private Payload payload;

    public void setPayload(Payload payload) {

        this.payload = payload;
    }

    public Payload getPayload() {

        notNull(payload);

        return payload;
    }

    private LaunchServiceProvider launchServiceProvider;

    @Property(name = "launchSite")
    private String launchSite;

    @Property(name = "orbit")
    private String orbit;

    @Property(name = "function")
    private String function;

    @Property(name = "launchOutcome")
    private LaunchOutcome launchOutcome;

    @Property(name = "price")
    private int price;

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {

        LaunchValidation.yearCanNotGreaterThanCurrentYear(launchDate.getYear());
        this.launchDate = launchDate;
    }

    public void setLaunchVehicle(Rocket launchVehicle) {
        notNull(launchVehicle);
        this.launchVehicle = launchVehicle;
    }

    public void setOrbit(String orbit) {

        notBlank(orbit,"orbit cannot be null or empty");
        this.orbit = orbit;
    }

    public Rocket getLaunchVehicle() {
        return launchVehicle;
    }



    public String getLaunchSite() {
        return launchSite;
    }

    public String getOrbit() {
        return orbit;
    }

    public String getFunction() {
        return function;
    }

    public LaunchOutcome getLaunchOutcome() {
        return launchOutcome;
    }



    public void setLaunchSite(String launchSite) {

        notBlank(launchSite,"launchSite cannot be null or empty");
        this.launchSite = launchSite;
    }

    public void setFunction(String function) {

        notBlank(function,"function cannot be null or empty");
        this.function = function;
    }

    public void setLaunchOutcome(LaunchOutcome launchOutcome) {
        this.launchOutcome = launchOutcome;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LaunchServiceProvider getLaunchServiceProvider() {
        return launchServiceProvider;
    }

    public void setLaunchServiceProvider(LaunchServiceProvider launchServiceProvider) {
        this.launchServiceProvider = launchServiceProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Launch launch = (Launch) o;
        return Objects.equals(launchDate, launch.launchDate) &&
                Objects.equals(launchVehicle, launch.launchVehicle) &&
                Objects.equals(orbit, launch.orbit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(launchDate, launchVehicle, orbit);
    }
}
