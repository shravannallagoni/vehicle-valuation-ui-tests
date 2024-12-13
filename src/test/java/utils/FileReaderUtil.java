package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderUtil {
    public static List<String> extractVehicleRegNumbers(String inputFile) {

        List<String> vehicleRegNumbers = new ArrayList<>();
        String regexPattern = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";
        Pattern pattern = Pattern.compile(regexPattern);

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    vehicleRegNumbers.add(matcher.group().replaceAll("\\s", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleRegNumbers;
    }

    public static List<String> readOutputFile(String outputFile) {
        List<String> output = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
