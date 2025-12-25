package repository;
import model.Prescription;
import java.util.*;
public class PrescriptionRepository {
    private final String path;
    private static final String HEADER =
            "prescription_id,patient_id,clinician_id,appointment_id,prescription_date,medication_name," +
                    "dosage,frequency,duration_days,quantity,instructions,pharmacy_name,status,issue_date,collection_date";

    public PrescriptionRepository(String path) { this.path = path; }

    public List<Prescription> loadAll() {
        List<Prescription> list = new ArrayList<>();
        for (String[] r : CsvUtil.read(path)) {
            list.add(new Prescription(
                    r[0], r[1], r[2], r[3],
                    r[4], r[5], r[6], r[7],
                    r[8], r[9], r[10], r[11],
                    r[12], r[13], r[14]
            ));
        }
        return list;
    }

    public void saveAll(List<Prescription> prescriptions) {
        List<String> lines = new ArrayList<>();
        for (Prescription p : prescriptions) lines.add(p.toCsv());
        CsvUtil.write(path, HEADER, lines);
    }
}
