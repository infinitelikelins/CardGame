package com.bearya.robot.base.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

    public static String stringFromSDCard(String filePath) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        }
    }

}