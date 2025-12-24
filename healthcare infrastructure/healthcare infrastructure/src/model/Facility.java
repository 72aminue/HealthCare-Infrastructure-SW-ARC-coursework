package model;
/**
 * Represents a healthcare facility such as a GP surgery, hospital, or clinic.
 */

public class Facility {
    public final String facilityId;
    public final String facilityName;
    public final String facilityType;
    public final String address;
    public final String postcode;
    public final String phoneNumber;
    public final String email;
    public final String openingHours;
    public final String managerName;
    public final String capacity;
    public final String specialitiesOffered; // raw "A|B|C"
    /**
     * Constructs a new Facility object with all required details.
     *
     * @param facilityId           unique ID of the facility
     * @param facilityName         name of the facility
     * @param facilityType         type of facility (GP Surgery, Hospital, etc.)
     * @param address              address of the facility
     * @param postcode             postcode of the facility
     * @param phoneNumber          contact phone number
     * @param email                contact email address
     * @param openingHours         opening hours of the facility
     * @param managerName          name of the facility manager
     * @param capacity             capacity of the facility (stored as text)
     * @param specialitiesOffered  list of specialities offered (raw CSV format)
     */
    public Facility(String facilityId, String facilityName, String facilityType, String address,
                    String postcode, String phoneNumber, String email, String openingHours,
                    String managerName, String capacity, String specialitiesOffered) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.address = address;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.openingHours = openingHours;
        this.managerName = managerName;
        this.capacity = capacity;
        this.specialitiesOffered = specialitiesOffered;
    }
    /**
     * Converts this Facility object into a single CSV-formatted line.
     * This method is used when saving facility data back to a CSV file.
     *
     * @return CSV representation of the facility
     */
    public String toCsv() {
        return String.join(",",
                safe(facilityId), safe(facilityName), safe(facilityType), safe(address),
                safe(postcode), safe(phoneNumber), safe(email), safe(openingHours),
                safe(managerName), safe(capacity), safe(specialitiesOffered)
        );
    }
    /**
     * Makes a string safe for CSV output by:
     * - Replacing null values with empty strings
     * - Removing commas and line breaks to prevent CSV corruption
     */
    private String safe(String s) {
        //we could use traditional if statement for this method,but I decided to try learning something new
        return s == null ? "" : s.replace(",", " ").replace("\n"," ").replace("\r"," ");
    }
    /**
     * Returns a readable string representation of the facility.
     * Useful for debugging and displaying facility lists in the UI.
     */
    @Override
    public String toString() { return facilityId + " - " + facilityName + " (" + facilityType + ")"; }
}

