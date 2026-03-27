package za.ac.cput.util;

/*
User Factory Helper Class
Author: Aneeqah Talaaboedien (219099405)
Date March 2026
 */


import za.ac.cput.util.Helper;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String a) {
        if (a.isEmpty() || a == null)

            return true;
        return false;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

}