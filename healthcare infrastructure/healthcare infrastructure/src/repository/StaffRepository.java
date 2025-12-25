package repository;
import model.Staff;
import java.util.*;
public class StaffRepository {
    private final String path;
    private static final String HEADER =
            "staff_id,first_name,last_name,role,department,facility_id,phone_number,email," +
                    "employment_status,start_date,line_manager,access_level";

    public StaffRepository(String path) { this.path = path; }

    public List<Staff> loadAll() {
        List<Staff> list = new ArrayList<>();
        for (String[] r : CsvUtil.read(path)) {
            list.add(new Staff(
                    r[0], r[1], r[2], r[3],
                    r[4], r[5], r[6], r[7],
                    r[8], r[9], r[10], r[11]
            ));
        }
        return list;
    }

    public void saveAll(List<Staff> staff) {
        List<String> lines = new ArrayList<>();
        for (Staff s : staff) lines.add(s.toCsv());
        CsvUtil.write(path, HEADER, lines);
    }
}
