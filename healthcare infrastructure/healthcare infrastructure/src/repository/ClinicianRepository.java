package repository;


import model.Clinician;
import java.util.*;
public class ClinicianRepository {
    private final String path;
    private static final String HEADER =
            "clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email," +
                    "workplace_id,workplace_type,employment_status,start_date";

    public ClinicianRepository(String path) { this.path = path; }

    public List<Clinician> loadAll() {
        List<Clinician> list = new ArrayList<>();
        for (String[] r : CsvUtil.read(path)) {
            list.add(new Clinician(
                    r[0], r[1], r[2], r[3],
                    r[4], r[5], r[6], r[7],
                    r[8], r[9], r[10], r[11]
            ));
        }
        return list;
    }

    public void saveAll(List<Clinician> clinicians) {
        List<String> lines = new ArrayList<>();
        for (Clinician c : clinicians) lines.add(c.toCsv());
        CsvUtil.write(path, HEADER, lines);
    }
}

