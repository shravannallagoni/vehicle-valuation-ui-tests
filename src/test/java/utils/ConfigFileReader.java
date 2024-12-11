package utils;

import java.io.BufferedReader;
import java.io.File;
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

public class ConfigFileReader {

    public static List<String> extractVehicleRegNumbers(String filePath) {
        List<String> vehicleRegNumbers = new ArrayList<>();

        String regexPattern = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";
        Pattern pattern = Pattern.compile(regexPattern);
        try {
            List<String> rows = Files.readAllLines(Paths.get(filePath));
            for (String line : rows) {
                System.out.println(line);
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

    public static Map<String, String> readOutputFile(String filePath) throws IOException {
        Map<String, String> vehicleResult = new HashMap<>();
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        System.out.println("Reading text file using file reader");

        while ((line = br.readLine()) != null) {
            String[] vehicleDetails = line.split(",", 2);
            if (vehicleDetails.length == 2) {
                vehicleResult.put(vehicleDetails[0].trim(), vehicleDetails[1].trim());
            }
        }
        br.close();
        fr.close();
        return vehicleResult;
    }
}
