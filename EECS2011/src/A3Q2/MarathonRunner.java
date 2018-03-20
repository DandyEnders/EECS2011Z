package A3Q2;

/**
 *
 * @author elder
 */
public class MarathonRunner {
    private int place;
    private String chipTime;
    private String bibID;
    private String lastName;
    private String firstName;
    private String category;
    
    protected MarathonRunner(int place, String chipTime, String bibID, String lastName, String firstName, String category) {
        setPlace(place);
        setChipTime(chipTime);
        setBibID(bibID);
        setLastName(lastName);
        setFirstName(firstName);
        setCategory(category);
    }

    protected int getPlace() {
        return place;
    }

    protected String getChipTime() {
        return chipTime;
    }

    protected String getBibNum() {
        return chipTime;
    }

    protected String getLastName() {
        return lastName;
    }

    protected String getFirstName() {
        return firstName;
    }

   protected String getCategory() {
        return category;
    }

    protected void setPlace(int place) {
        this.place = place;
    }

    protected void setChipTime(String chipTime) {
        this.chipTime = chipTime;
    }

    protected void setBibID(String bibID) {
        this.bibID = bibID;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Place: " + getPlace() + " Chip Time: " + getChipTime()
                + " Name: " + getFirstName() + " " + getLastName() + " " + getCategory();
    }
}
