

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TRLmetric {
    private static final String[] KEYWORDS = {"if", "for", "while", "switch", "try", "catch"};

    public static double calculateLRS(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The specified path is not a valid directory.");
        }

        Map<String, Integer> patternCounts = new HashMap<>();
        Map<String, Integer> filePatternCounts = new HashMap<>();

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                int filePatternCount = countPatterns(file, patternCounts);
                filePatternCounts.put(file.getName(), filePatternCount);
            }
        }

        int totalPatterns = patternCounts.values().stream().mapToInt(Integer::intValue).sum();
        int totalFiles = filePatternCounts.size();

        return totalFiles == 0 ? 0 : (double) totalPatterns / totalFiles;
    }

    private static int countPatterns(File file, Map<String, Integer> patternCounts) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String keyword : KEYWORDS) {
                    if (line.contains(keyword)) {
                        patternCounts.put(keyword, patternCounts.getOrDefault(keyword, 0) + 1);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    
}
