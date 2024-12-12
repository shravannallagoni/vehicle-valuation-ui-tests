package utils;

import io.cucumber.java.hu.Ha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderUtil {
    public static List<String> extractVehicleRegNumbers(String fileName) {

        List<String> vehicleRegNumbers = new ArrayList<>();
        String regexPattern = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";
        Pattern pattern = Pattern.compile(regexPattern);


        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    vehicleRegNumbers.add(matcher.group().replaceAll("\\s", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        vehicleRegNumbers.forEach(item -> System.out.println(item));
        return vehicleRegNumbers;
    }

    public static StringBuilder readOutputFile(String fileName) throws IOException {

        StringBuilder outputVehicleRegistrationResult = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) !=null) {
                outputVehicleRegistrationResult.append(line).append("\n");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(outputVehicleRegistrationResult);
        return outputVehicleRegistrationResult;
    }
}
