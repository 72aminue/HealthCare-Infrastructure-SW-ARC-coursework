package app;
import repository.*;
import model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Patients
        PatientRepository patientRepo = new PatientRepository("patients.csv");
        List<Patient> patients = patientRepo.loadAll();
        System.out.println("Loaded patients: " + patients.size());

        // 2. Clinicians
        ClinicianRepository clinicianRepo = new ClinicianRepository("clinicians.csv");
        List<Clinician> clinicians = clinicianRepo.loadAll();
        System.out.println("Loaded clinicians: " + clinicians.size());

        // 3. Facilities
        FacilityRepository facilityRepo = new FacilityRepository("facilities.csv");
        List<Facility> facilities = facilityRepo.loadAll();
        System.out.println("Loaded facilities: " + facilities.size());

        // 4. Appointments
        AppointmentRepository appointmentRepo = new AppointmentRepository("appointments.csv");
        List<Appointment> appointments = appointmentRepo.loadAll();
        System.out.println("Loaded appointments: " + appointments.size());

        // 5. Prescriptions
        PrescriptionRepository prescriptionRepo = new PrescriptionRepository("prescriptions.csv");
        List<Prescription> prescriptions = prescriptionRepo.loadAll();
        System.out.println("Loaded prescriptions: " + prescriptions.size());

        // 6. Referrals
        ReferralRepository referralRepo = new ReferralRepository("referrals.csv");
        List<Referral> referrals = referralRepo.loadAll();
        System.out.println("Loaded referrals: " + referrals.size());

        // 7. Staff
        StaffRepository staffRepo = new StaffRepository("staff.csv");
        List<Staff> staff = staffRepo.loadAll();
        System.out.println("Loaded staff: " + staff.size());
    }
}


