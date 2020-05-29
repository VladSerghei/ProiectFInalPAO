package service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AuditService {
    private static final String PATH = "src/data/Audit.csv";
    private static final String HEADER = "command,executionTime";
    private static final SimpleDateFormat DATE = new SimpleDateFormat("d:MM:yyyy HH:mm:ss");
    private static AuditService instance;

    private AuditService() throws IOException {
        Path path = Path.of(PATH);
        if (!Files.exists(path))
            Files.createFile(path);
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER);
        writer.append("\n");
        writer.flush();
        writer.close();


    }

    public static AuditService getInstance() throws IOException {
        if(instance == null)
            instance = new AuditService();
        return instance;
    }

    public void log(String event, Timestamp timestamp) throws IOException {
        FileWriter writer = new FileWriter(PATH, true);
        writer.append(event).append(",");
        writer.append(DATE.format(timestamp)).append("\n");
        writer.flush();
        writer.close();
    }

}




