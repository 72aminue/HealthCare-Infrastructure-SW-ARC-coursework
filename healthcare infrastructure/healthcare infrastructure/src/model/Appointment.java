package model;
/**
 * Represents an appointment between a patient and a clinician
 * at a specific healthcare facility.
 */
public class Appointment {
    public final String appointmentId;
    public final String patientId;
    public final String clinicianId;
    public final String facilityId;

    public String appointmentDate;   // YYYY-MM-DD
    public String appointmentTime;   // HH:MM
    public String durationMinutes;
    public String appointmentType;
    public String status;            // Scheduled/Cancelled/Completed...
    public String reasonForVisit;
    public String notes;

    public final String createdDate;
    public String lastModified;
    /**
     * Constructs a new Appointment object with all required details.
     *
     * @param appointmentId     unique ID of the appointment
     * @param patientId         ID of the patient
     * @param clinicianId       ID of the clinician
     * @param facilityId        ID of the facility
     * @param appointmentDate   scheduled date of the appointment
     * @param appointmentTime   scheduled time of the appointment
     * @param durationMinutes   duration of the appointment in minutes
     * @param appointmentType   type of appointment
     * @param status            current appointment status
     * @param reasonForVisit    reason for the visit
     * @param notes             additional notes (optional)
     * @param createdDate       date the appointment was created
     * @param lastModified      date the appointment was last modified
     */
    public Appointment(String appointmentId, String patientId, String clinicianId, String facilityId,
                       String appointmentDate, String appointmentTime, String durationMinutes,
                       String appointmentType, String status, String reasonForVisit, String notes,
                       String createdDate, String lastModified) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.facilityId = facilityId;

        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.durationMinutes = durationMinutes;
        this.appointmentType = appointmentType;
        this.status = status;
        this.reasonForVisit = reasonForVisit;
        this.notes = notes;

        this.createdDate = createdDate;
        this.lastModified = lastModified;
    }
    /**
     * Converts this Appointment object into a single CSV-formatted line.
     * Used when saving appointment data to a CSV file.
     *
     * @return CSV representation of the appointment
     */
    public String toCsv() {
        return String.join(",",
                safe(appointmentId),
                safe(patientId),
                safe(clinicianId),
                safe(facilityId),
                safe(appointmentDate),
                safe(appointmentTime),
                safe(durationMinutes),
                safe(appointmentType),
                safe(status),
                safe(reasonForVisit),
                safe(notes),
                safe(createdDate),
                safe(lastModified)
        );
    }
    /**
     * Ensures strings are safe for CSV output by:
     * - Replacing null values with empty strings
     * - Removing commas and line breaks to prevent CSV corruption
     */
    private String safe(String s) {
        return s == null ? "" : s.replace(",", " ").replace("\n", " ").replace("\r", " ");
    }
}
