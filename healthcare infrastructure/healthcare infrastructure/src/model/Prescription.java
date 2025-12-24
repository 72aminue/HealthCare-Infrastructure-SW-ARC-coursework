package model;
/**
 * Represents a prescription issued to a patient by a clinician.
 */
public class Prescription {
    public String prescriptionId;  // RX###
    public final String patientId;
    public final String clinicianId;
    public final String appointmentId;
    public final String prescriptionDate;
    public final String medicationName;
    public final String dosage;
    public final String frequency;
    public final String durationDays;
    public final String quantity;
    public final String instructions;
    public final String pharmacyName;
    public String status;
    public final String issueDate;
    public String collectionDate;  // may be ""
    /**
     * Constructs a new Prescription object with all required details.
     *
     * @param prescriptionId    unique ID of the prescription
     * @param patientId         ID of the patient receiving the prescription
     * @param clinicianId       ID of the clinician issuing the prescription
     * @param appointmentId     ID of the related appointment
     * @param prescriptionDate  date the prescription was created
     * @param medicationName    name of the prescribed medication
     * @param dosage             dosage instructions (e.g. "500mg")
     * @param frequency          frequency of intake (e.g. "Twice a day")
     * @param durationDays       duration of treatment in days
     * @param quantity           total quantity prescribed
     * @param instructions       additional instructions for the patient
     * @param pharmacyName       name of the pharmacy
     * @param status             current prescription status
     * @param issueDate          date the prescription was issued
     * @param collectionDate     date the prescription was collected (may be empty)
     */
    public Prescription(String prescriptionId, String patientId, String clinicianId, String appointmentId,
                        String prescriptionDate, String medicationName, String dosage, String frequency,
                        String durationDays, String quantity, String instructions, String pharmacyName,
                        String status, String issueDate, String collectionDate) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.appointmentId = appointmentId;
        this.prescriptionDate = prescriptionDate;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.durationDays = durationDays;
        this.quantity = quantity;
        this.instructions = instructions;
        this.pharmacyName = pharmacyName;
        this.status = status;
        this.issueDate = issueDate;
        this.collectionDate = collectionDate;
    }
    /**
     * Converts this Prescription object into a single CSV-formatted line.
     * Used when saving prescription data to a CSV file.
     *
     * @return CSV representation of the prescription
     */
    public String toCsv() {
        return String.join(",",
                safe(prescriptionId), safe(patientId), safe(clinicianId), safe(appointmentId),
                safe(prescriptionDate), safe(medicationName), safe(dosage), safe(frequency),
                safe(durationDays), safe(quantity), safe(instructions), safe(pharmacyName),
                safe(status), safe(issueDate), safe(collectionDate)
        );
    }
    /**
     * Ensures strings are safe for CSV output by:
     * - Converting null values to empty strings
     * - Removing commas and line breaks to prevent CSV corruption
     */
    private String safe(String s) {
        return s == null ? "" : s.replace(",", " ").replace("\n"," ").replace("\r"," ");
    }
}

