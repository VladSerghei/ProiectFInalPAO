package service;

import model.Doctor;
import model.FamilyDoctor;
import model.SpecialistDoctor;

import java.io.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class DoctorServiceInOut {
    private static final String PATH = "src/data/Doctor.csv";
    private static final String HEADER = "idNo,firstName,lastName,specialization";
    private  static DoctorServiceInOut instance;

    private DoctorServiceInOut(){}

    public static DoctorServiceInOut getInstance(){
        if(instance == null)
            instance = new DoctorServiceInOut();
        return instance;
    }

    public final Set<Doctor> loadDoctors() throws IOException {
        final Set<Doctor> doctors = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                if("null".equals(fields[3]))
                    doctors.add(new FamilyDoctor(fields[1],fields[2]));
                else
                    doctors.add(new SpecialistDoctor(fields[1],fields[2],fields[3]));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded doctors",new Timestamp(System.currentTimeMillis()));
        return doctors;
    }

    public void saveDoctors() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Doctor> doctors = DoctorService.getInstance().getDoctors();
        for(final Doctor doctor:doctors){

            writer.append(String.valueOf(doctor.getIdNo())).append(",");
            writer.append(String.valueOf(doctor.getFirstName())).append(",");
            writer.append(String.valueOf(doctor.getLastName())).append(",");
            if(doctor.getClass() == SpecialistDoctor.class)
                writer.append(String.valueOf(((SpecialistDoctor) doctor).getSpecialization())).append("\n");
            else
                writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved doctors",new Timestamp(System.currentTimeMillis()));
    }
}
