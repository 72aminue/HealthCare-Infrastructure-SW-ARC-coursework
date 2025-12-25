package repository;
import model.Appointment;
import java.util.*;
public class AppointmentRepository {
    private final String path;
    private static final String HEADER =
            "appointment_id,patient_id,clinician_id,facility_id,appointment_date,appointment_time," +
                    "duration_minutes,appointment_type,status,reason_for_visit,notes,created_date,last_modified";

    public AppointmentRepository(String path) { this.path = path; }

    public List<Appointment> loadAll() {
        List<Appointment> list = new ArrayList<>();
        for (String[] r : CsvUtil.read(path)) {
            list.add(new Appointment(
                    r[0], r[1], r[2], r[3],
                    r[4], r[5], r[6], r[7],
                    r[8], r[9], r[10], r[11], r[12]
            ));
        }
        return list;
    }

    public void saveAll(List<Appointment> appointments) {
        List<String> lines = new ArrayList<>();
        for (Appointment a : appointments) lines.add(a.toCsv());
        CsvUtil.write(path, HEADER, lines);
    }
}
