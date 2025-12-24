package model;
/**
 * Represents a non-clinical staff member working within the healthcare system.
 *
 */

public class Staff {
    public final String staffId;
    public final String firstName;
    public final String lastName;
    public final String role;
    public final String department;
    public final String facilityId;
    public final String phoneNumber;
    public final String email;
    public final String employmentStatus;
    public final String startDate;
    public final String lineManager;
    public final String accessLevel;
    /**
     * Constructs a new Staff object with all required details.
     *
     * @param staffId            unique ID of the staff member
     * @param firstName          staff member's first name
     * @param lastName           staff member's last name
     * @param role               staff role or job title
     * @param department         department the staff member works in
     * @param facilityId         ID of the facility where the staff member works
     * @param phoneNumber        contact phone number
     * @param email              contact email address
     * @param employmentStatus   employment status (Full-time, Part-time, etc.)
     * @param startDate          date employment started
     * @param lineManager        line manager of the staff member
     * @param accessLevel        system access level
     */
    public Staff(String staffId, String firstName, String lastName, String role, String department,
                 String facilityId, String phoneNumber, String email, String employmentStatus,
                 String startDate, String lineManager, String accessLevel) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.department = department;
        this.facilityId = facilityId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employmentStatus = employmentStatus;
        this.startDate = startDate;
        this.lineManager = lineManager;
        this.accessLevel = accessLevel;
    }
    /**
     * Converts this Staff object into a single CSV-formatted line.
     * Used when saving staff data to a CSV file.
     *
     * @return CSV representation of the staff member
     */
    public String toCsv() {
        return String.join(",",
                safe(staffId), safe(firstName), safe(lastName), safe(role), safe(department),
                safe(facilityId), safe(phoneNumber), safe(email), safe(employmentStatus),
                safe(startDate), safe(lineManager), safe(accessLevel)
        );
    }
    /**
     * Ensures strings are safe for CSV output by:
     * Replacing null values with empty strings
     * Removing commas and line breaks to prevent CSV corruption
     */
    private String safe(String s) {
        return s == null ? "" : s.replace(",", " ").replace("\n"," ").replace("\r"," ");
    }
    /**
     * Returns a readable string representation of the staff member.
     * Useful for debugging and displaying staff lists in the UI.
     */
    @Override
    public String toString() { return staffId + " - " + role + " " + firstName + " " + lastName; }
}

