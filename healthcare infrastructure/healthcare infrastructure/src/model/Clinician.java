package model;
/**
 * Represents a clinician working within the healthcare system.
 * This model stores clinician details such as role, speciality,
 * workplace information, and employment status.
 */

public class Clinician {
    public final String clinicianId;
    public final String firstName;
    public final String lastName;
    public final String title;            // GP / Nurse / Specialist etc.
    public final String speciality;
    public final String gmcNumber;
    public final String phoneNumber;
    public final String email;
    public final String workplaceId;      // facility_id
    public final String workplaceType;
    public final String employmentStatus;
    public final String startDate;
    /**
     * Creates a new Clinician object with all required details.
     *
     * @param clinicianId       unique ID for the clinician
     * @param firstName         clinician's first name
     * @param lastName          clinician's last name
     * @param title             clinician role (GP, Nurse, Specialist)
     * @param speciality        clinician's area of expertise
     * @param gmcNumber         clinician's GMC registration number
     * @param phoneNumber       clinician's contact number
     * @param email             clinician's email address
     * @param workplaceId       ID of the facility where the clinician works
     * @param workplaceType     type of workplace (e.g. GP Surgery, Hospital)
     * @param employmentStatus  employment status (Full-time, Part-time, etc.)
     * @param startDate         date employment started
     */
    public Clinician(String clinicianId, String firstName, String lastName, String title,
                     String speciality, String gmcNumber, String phoneNumber, String email,
                     String workplaceId, String workplaceType, String employmentStatus, String startDate) {
        this.clinicianId = clinicianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.speciality = speciality;
        this.gmcNumber = gmcNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.workplaceId = workplaceId;
        this.workplaceType = workplaceType;
        this.employmentStatus = employmentStatus;
        this.startDate = startDate;
    }
    /**
     * Checks whether the clinician is a General Practitioner (GP).
     * @return true if clinician title is "GP", otherwise false
     */
    public boolean isGp() {
        return "GP".equalsIgnoreCase(title);
    }
    /**
     * Converts this Clinician object into a CSV-formatted line.
     * Used when saving clinician data to a CSV file.
     *
     * @return CSV representation of the clinician
     */
    public String toCsv() {
        return String.join(",",
                safe(clinicianId), safe(firstName), safe(lastName), safe(title),
                safe(speciality), safe(gmcNumber), safe(phoneNumber), safe(email),
                safe(workplaceId), safe(workplaceType), safe(employmentStatus), safe(startDate)
        );
    }
    /**
     * Ensures CSV safety by:
     * - Converting null values to empty strings
     * - Removing commas and line breaks to prevent CSV corruption
     */
    private String safe(String s) {
        return s == null ? "" : s.replace(",", " ").replace("\n"," ").replace("\r"," ");
    }
    /**
     * Returns a readable string representation of the clinician.
     * Useful for debugging and displaying in UI lists.
     */
    @Override
    public String toString() {
        return clinicianId + " - " + title + " " + firstName + " " + lastName;
    }
}
