package service;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeSet;

public class PatientServiceInOut {
    private static final String PATH = "src/data/Patient.csv";
    private static final String HEADER = "SSN,doctorIdNo,firstName,lastName,age,weight,height,grade";
    private  static PatientServiceInOut instance;

    private PatientServiceInOut(){}

    public static PatientServiceInOut getInstance(){
        if(instance == null)
            instance = new PatientServiceInOut();
        return instance;
    }

    public final Set<Patient> loadPatients() throws IOException {
        final Set<Patient> patients = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                if("null".equals(fields[7]))
                    patients.add( new CivilPatient( Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Double.parseDouble(fields[6]) ) );
                else
                    patients.add(new MilitaryPatient( Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Double.parseDouble(fields[6]) ,fields[7]));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded patients",new Timestamp(System.currentTimeMillis()));
        return patients;
    }

    public void savePatients() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Patient> patients = PatientService.getInstance().getPatients();
        for(final Patient patient:patients){

            writer.append(String.valueOf(patient.getSSN())).append(",");
            writer.append(String.valueOf(patient.getDoctorIdNo())).append(",");
            writer.append(String.valueOf(patient.getFirstName())).append(",");
            writer.append(String.valueOf(patient.getLastName())).append(",");
            writer.append(String.valueOf(patient.getAge())).append(",");
            writer.append(String.valueOf(patient.getWeight())).append(",");
            writer.append(String.valueOf(patient.getHeight())).append(",");

            if(patient.getClass() == MilitaryPatient.class)
                writer.append(String.valueOf(((MilitaryPatient) patient).getGrade())).append("\n");
            else
                writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved patients",new Timestamp(System.currentTimeMillis()));
    }
}
