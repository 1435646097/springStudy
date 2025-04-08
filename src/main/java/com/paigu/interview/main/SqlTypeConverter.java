package com.paigu.interview.main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SqlTypeConverter {

    public static void main(String[] args) {
        String directoryPath = "C:\\company\\code\\siteweb6-server\\core\\src\\main\\resources\\db\\changelog\\siteweb\\opengauss\\tables";
        convertSqlFiles(directoryPath);
    }

    public static void convertSqlFiles(String directoryPath) {
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".sql"))
                    .forEach(SqlTypeConverter::convertSqlFile);
        } catch (IOException e) {
            System.err.println("Error walking the directory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void convertSqlFile(Path filePath) {
        File inputFile = filePath.toFile();
        File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

        // Use a single regex pattern for both replacements
        Pattern pattern = Pattern.compile("(?i)(character varying|VARCHAR)");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Use Matcher.replaceAll() for correct replacement
                Matcher matcher = pattern.matcher(line);
                line = matcher.replaceAll("NVARCHAR2");
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error processing file " + inputFile.getName() + ": " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Replace the original file with the modified temp file.
        if (!inputFile.delete()) {
            System.err.println("Could not delete original file: " + inputFile.getAbsolutePath());
            tempFile.delete();
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.err.println("Could not rename temp file to: " + inputFile.getAbsolutePath());
            System.err.println("  You may need to manually rename the .tmp file and delete the corrupted original.");
        }
    }
}
