package com.paigu.interview.main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLFieldModifier {
    public static void main(String[] args) {
        // Directory containing SQL files
        String directoryPath = "C:\\company\\code\\siteweb6-server\\core\\src\\main\\resources\\db\\changelog\\siteweb\\opengauss\\tables";

        try {
            processDirectory(directoryPath);
            System.out.println("Processing completed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("Directory does not exist or is not a directory: " + directoryPath);
        }

        // Create a backup directory with timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String backupDirPath = directoryPath + File.separator + "backup_" + timestamp;
        File backupDir = new File(backupDirPath);
        if (!backupDir.exists() && !backupDir.mkdir()) {
            throw new IOException("Failed to create backup directory: " + backupDirPath);
        }

        // Get all SQL files in the directory
        File[] sqlFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".sql"));

        if (sqlFiles == null || sqlFiles.length == 0) {
            System.out.println("No SQL files found in directory: " + directoryPath);
            return;
        }

        int totalFilesModified = 0;
        int totalChangesCount = 0;

        // Process each SQL file
        for (File sqlFile : sqlFiles) {
            // Create backup of the file
            Path originalPath = sqlFile.toPath();
            Path backupPath = Paths.get(backupDirPath, sqlFile.getName());
            Files.copy(originalPath, backupPath, StandardCopyOption.REPLACE_EXISTING);

            // Process the file
            ModificationResult result = processFile(sqlFile);

            if (result.changesCount > 0) {
                totalFilesModified++;
                totalChangesCount += result.changesCount;
                System.out.println("Modified file: " + sqlFile.getName() + " - " + result.changesCount + " changes made");
            } else {
                System.out.println("No changes needed in file: " + sqlFile.getName());
            }
        }

        System.out.println("\nSummary:");
        System.out.println("Total files processed: " + sqlFiles.length);
        System.out.println("Total files modified: " + totalFilesModified);
        System.out.println("Total changes made: " + totalChangesCount);
        System.out.println("Backup created at: " + backupDirPath);
    }

    private static class ModificationResult {
        final String content;
        final int changesCount;

        ModificationResult(String content, int changesCount) {
            this.content = content;
            this.changesCount = changesCount;
        }
    }

    private static ModificationResult processFile(File file) throws IOException {
        Path path = file.toPath();
        String content = Files.readString(path, StandardCharsets.UTF_8);

        // Apply the modifications
        ModificationResult result = doubleVarcharLength(content);

        // Only write if changes were made
        if (result.changesCount > 0) {
            Files.writeString(path, result.content, StandardCharsets.UTF_8);
        }

        return result;
    }

    private static ModificationResult doubleVarcharLength(String content) {
        // Regex patterns to match VARCHAR(xxx) and character varying(xxx)
        // Case insensitive for "varchar" and "character varying"
        // The number can be any sequence of digits
        Pattern varcharPattern = Pattern.compile("(?i)(VARCHAR)\\((\\d+)\\)");
        Pattern charVaryingPattern = Pattern.compile("(?i)(character\\s+varying)\\((\\d+)\\)");

        int totalChanges = 0;

        // Process VARCHAR(xxx)
        StringBuffer sb = new StringBuffer();
        Matcher matcher = varcharPattern.matcher(content);
        while (matcher.find()) {
            String typeKeyword = matcher.group(1); // Preserve original case
            int currentLength = Integer.parseInt(matcher.group(2));
            int newLength = currentLength * 2;
            matcher.appendReplacement(sb, typeKeyword + "(" + newLength + ")");
            totalChanges++;
        }
        matcher.appendTail(sb);

        // Process character varying(xxx)
        StringBuffer sb2 = new StringBuffer();
        matcher = charVaryingPattern.matcher(sb.toString());
        while (matcher.find()) {
            String typeKeyword = matcher.group(1); // Preserve original case
            int currentLength = Integer.parseInt(matcher.group(2));
            int newLength = currentLength * 2;
            matcher.appendReplacement(sb2, typeKeyword + "(" + newLength + ")");
            totalChanges++;
        }
        matcher.appendTail(sb2);

        return new ModificationResult(sb2.toString(), totalChanges);
    }
}


