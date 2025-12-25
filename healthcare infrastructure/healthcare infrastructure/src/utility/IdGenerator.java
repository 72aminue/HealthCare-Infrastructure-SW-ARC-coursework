package utility;

import java.util.List;

public class IdGenerator {
    /**
     * Generates the next ID using a prefix and existing IDs.
     * Examples:
     *  prefix "A"  -> A001, A002, ...
     *  prefix "RX" -> RX001, RX002, ...
     *  prefix "R"  -> R001, R002, ...
     *
     * @param prefix       ID prefix (e.g. "A", "RX", "R")
     * @param existingIds  list of existing IDs
     * @return next generated ID
     */
    public static String nextId(String prefix, List<String> existingIds) {

        int max = 0;

        for (String id : existingIds) {
            if (id == null) continue;
            if (!id.startsWith(prefix)) continue;

            String numberPart = id.substring(prefix.length());

            try {
                int value = Integer.parseInt(numberPart);
                if (value > max) {
                    max = value;
                }
            } catch (NumberFormatException ignored) {
                // Ignore malformed IDs
            }
        }

        int next = max + 1;

        // Always 3-digit padding
        return prefix + String.format("%03d", next);
    }
}
