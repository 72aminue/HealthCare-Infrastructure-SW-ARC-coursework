package repository;
import model.Facility;
import java.util.*;
public class FacilityRepository {
    private final String path;
    private static final String HEADER =
            "facility_id,facility_name,facility_type,address,postcode,phone_number,email,opening_hours," +
                    "manager_name,capacity,specialities_offered";

    public FacilityRepository(String path) { this.path = path; }

    public List<Facility> loadAll() {
        List<Facility> list = new ArrayList<>();
        for (String[] r : CsvUtil.read(path)) {
            list.add(new Facility(
                    r[0], r[1], r[2],
                    r[3], r[4], r[5],
                    r[6], r[7], r[8],
                    r[9], r[10]
            ));
        }
        return list;
    }

    public void saveAll(List<Facility> facilities) {
        List<String> lines = new ArrayList<>();
        for (Facility f : facilities) lines.add(f.toCsv());
        CsvUtil.write(path, HEADER, lines);
    }
}
