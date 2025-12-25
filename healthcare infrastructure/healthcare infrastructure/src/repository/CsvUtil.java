package repository;
import java.io.*;
import java.util.*;
public class CsvUtil {
    /** Reads CSV rows (skips header). Keeps empty cells using split(",", -1). */
    public static List<String[]> read(String path) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean header = true;
            while ((line = br.readLine()) != null) {
                if (header) { header = false; continue; }
                rows.add(line.split(",", -1)); // keep empty fields
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV: " + path, e);
        }
        return rows;
    }

    /** Writes header + lines to CSV (overwrites). */
    public static void write(String path, String header, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(header);
            bw.newLine();
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write CSV: " + path, e);
        }
    }
}

