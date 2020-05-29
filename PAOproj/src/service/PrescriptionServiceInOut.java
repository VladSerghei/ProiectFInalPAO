package service;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeSet;

public class PrescriptionServiceInOut {
    private static final String PATH = "src/data/Prescription.csv";
    private static final String HEADER = "index,medication,prescribingDoctorIdNo,appointedDoctorIdNo";
    private  static PrescriptionServiceInOut instance;

    private PrescriptionServiceInOut(){}

    public static PrescriptionServiceInOut getInstance(){
        if(instance == null)
            instance = new PrescriptionServiceInOut();
        return instance;
    }

    public final Set<Prescription> loadPrescriptions() throws IOException {
        final Set<Prescription> prescriptions = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                if("null".equals(fields[3]))
                    prescriptions.add( new Prescription( fields[1], Integer.parseInt(fields[2]) ) );
                else
                    prescriptions.add(new AppointmentPrescription( fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]) ));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded prescriptions",new Timestamp(System.currentTimeMillis()));
        return prescriptions;
    }

    public void savePrescriptions() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Prescription> prescriptions = PrescriptionService.getInstance().getPrescriptions();
        for(final Prescription prescription:prescriptions){

            writer.append(String.valueOf(prescription.getIndex())).append(",");
            writer.append(String.valueOf(prescription.getMedication())).append(",");
            writer.append(String.valueOf(prescription.getPrescribingDoctorIdNo())).append(",");

            if(prescription.getClass() == AppointmentPrescription.class)
                writer.append(String.valueOf(((AppointmentPrescription) prescription).getAppointedDoctorIdNo())).append("\n");
            else
                writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved prescriptions",new Timestamp(System.currentTimeMillis()));
    }
}
