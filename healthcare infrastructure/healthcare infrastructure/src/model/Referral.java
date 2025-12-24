package model;
/**
 * Represents a referral made for a patient from one clinician or facility
 * to another clinician or facility.

 */


public class Referral {
    public String referralId; // R###
    public final String patientId;
    public final String referringClinicianId;
    public final String referredToClinicianId;
    public final String referringFacilityId;
    public final String referredToFacilityId;
    public final String referralDate;
    public final String urgencyLevel;
    public final String referralReason;
    public final String clinicalSummary;
    public final String requestedInvestigations; // e.g. ECG|Echo
    public String status;
    public final String appointmentId; // can be ""
    public final String notes;         // can be ""
    public final String createdDate;
    public String lastUpdated;
    /**
     * Constructs a new Referral object with all required details.
     *
     * @param referralId               unique ID of the referral
     * @param patientId                ID of the referred patient
     * @param referringClinicianId     clinician who created the referral
     * @param referredToClinicianId    clinician being referred to
     * @param referringFacilityId      facility where referral originated
     * @param referredToFacilityId     facility being referred to
     * @param referralDate             date the referral was made
     * @param urgencyLevel             urgency level of the referral
     * @param referralReason            reason for the referral
     * @param clinicalSummary           brief clinical summary
     * @param requestedInvestigations   investigations requested (raw format)
     * @param status                    current referral status
     * @param appointmentId             linked appointment ID (optional)
     * @param notes                     additional notes (optional)
     * @param createdDate               date the referral record was created
     * @param lastUpdated               date the referral was last updated
     */
    public Referral(String referralId, String patientId, String referringClinicianId, String referredToClinicianId,
                    String referringFacilityId, String referredToFacilityId, String referralDate, String urgencyLevel,
                    String referralReason, String clinicalSummary, String requestedInvestigations, String status,
                    String appointmentId, String notes, String createdDate, String lastUpdated) {
        this.referralId = referralId;
        this.patientId = patientId;
        this.referringClinicianId = referringClinicianId;
        this.referredToClinicianId = referredToClinicianId;
        this.referringFacilityId = referringFacilityId;
        this.referredToFacilityId = referredToFacilityId;
        this.referralDate = referralDate;
        this.urgencyLevel = urgencyLevel;
        this.referralReason = referralReason;
        this.clinicalSummary = clinicalSummary;
        this.requestedInvestigations = requestedInvestigations;
        this.status = status;
        this.appointmentId = appointmentId;
        this.notes = notes;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }
    /**
     * Converts this Referral object into a single CSV-formatted line.
     * Used when saving referral data back to a CSV file.
     *
     * @return CSV representation of the referral
     */
    public String toCsv() {
        return String.join(",",
                safe(referralId), safe(patientId), safe(referringClinicianId), safe(referredToClinicianId),
                safe(referringFacilityId), safe(referredToFacilityId), safe(referralDate), safe(urgencyLevel),
                safe(referralReason), safe(clinicalSummary), safe(requestedInvestigations), safe(status),
                safe(appointmentId), safe(notes), safe(createdDate), safe(lastUpdated)
        );
    }
    /**
     * Makes a string safe for CSV output by:
     * - Converting null values to empty strings
     * - Removing commas and line breaks to prevent CSV corruption
     */
    private String safe(String s) {
        return s == null ? "" : s.replace(",", " ").replace("\n"," ").replace("\r"," ");
    }
}
