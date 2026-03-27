package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String a) {
        if(a.isEmpty() || a==null)

            return true;
        return false;
    }
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
