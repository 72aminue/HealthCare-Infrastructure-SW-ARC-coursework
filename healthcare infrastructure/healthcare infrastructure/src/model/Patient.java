package model;
/**
 * Represents a patient in the healthcare system.
 * This class is  used to store patient information.
 */
public class Patient {
    public final String patientId;
    public final String firstName;
    public final String lastName;
    public final String dateOfBirth;
    public final String nhsNumber;
    public final String gender;
    public final String phoneNumber;
    public final String email;
    public final String address;
    public final String postcode;
    public final String emergencyContactName;
    public final String emergencyContactPhone;
    public final String registrationDate;
    public final String gpSurgeryId;
    /**
     * Creates a new Patient object with all required details.
     *
     * @param patientId               unique ID for the patient
     * @param firstName               patient's first name
     * @param lastName                patient's last name
     * @param dateOfBirth             patient's date of birth
     * @param nhsNumber               patient's NHS number
     * @param gender                  patient's gender
     * @param phoneNumber             patient's phone number
     * @param email                   patient's email address
     * @param address                 patient's home address
     * @param postcode                patient's postcode
     * @param emergencyContactName    name of emergency contact
     * @param emergencyContactPhone   phone number of emergency contact
     * @param registrationDate        date patient registered with GP
     * @param gpSurgeryId             ID of the GP surgery
     */
    public Patient(String patientId, String firstName, String lastName, String dateOfBirth,
                   String nhsNumber, String gender, String phoneNumber, String email,
                   String address, String postcode, String emergencyContactName,
                   String emergencyContactPhone, String registrationDate, String gpSurgeryId) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nhsNumber = nhsNumber;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.registrationDate = registrationDate;
        this.gpSurgeryId = gpSurgeryId;
    }
    /**
     * Converts this Patient object into a single CSV-formatted line.
     * This is used when saving patient data to a CSV file.
     *
     * @return CSV representation of the patient
     */
    public String toCsv() {
        return String.join(",",
                safe(patientId), safe(firstName), safe(lastName), safe(dateOfBirth),
                safe(nhsNumber), safe(gender), safe(phoneNumber), safe(email),
                safe(address), safe(postcode), safe(emergencyContactName),
                safe(emergencyContactPhone), safe(registrationDate), safe(gpSurgeryId)
        );
    }
    /**
     * Ensures CSV safety by:
     *  Replacing null values with empty strings
     *  Removing commas and line breaks to avoid corrupting the CSV format
     */
    private String safe(String s) { return s == null ? "" : s.replace(",", " ").replace("\n"," ").replace("\r"," "); }
    /**
     * Returns a readable representation of the patient.
     * Useful for debugging and displaying in the UI.
     */
    @Override
    public String toString() { return patientId + " - " + firstName + " " + lastName; }
}

