package service;


import model.Patient;
import repositories.PatientRepo;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;

public class PatientService {
    private static PatientService instance;
    private final PatientRepo patientRepo;

    private PatientService() throws IOException {
        patientRepo = new PatientRepo();
    }

    public static PatientService getInstance() throws IOException {
        if(instance == null)
            instance = new PatientService();
        return instance;
    }

    public Set<Patient> getPatients() throws IOException {
        AuditService.getInstance().log("Requested patients",new Timestamp(System.currentTimeMillis()));
        return patientRepo.getPatients();
    }

    public boolean add(final Patient patient) throws IOException {
        AuditService.getInstance().log("Added patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.add(patient);
    }

    public boolean remove(final int SSN) throws IOException {
        AuditService.getInstance().log("Removed a patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.remove(SSN);
    }

    public Patient getPatientBySSN(int SSN) throws IOException {
        AuditService.getInstance().log("Requested patient by SSN",new Timestamp(System.currentTimeMillis()));
        return patientRepo.getPatientBySSN(SSN);
    }

    public Set<Patient> getPatientsByFirstName(String firstName) throws IOException {
        AuditService.getInstance().log("Requested patients by first name",new Timestamp(System.currentTimeMillis()));
        return patientRepo.getPatientsByFirstName(firstName);
    }

    public Set<Patient> getPatientsByLastName(String lastName) throws IOException {
        AuditService.getInstance().log("Requested patients by last name",new Timestamp(System.currentTimeMillis()));
        return patientRepo.getPatientsByLastName(lastName);
    }

    public Set<Patient> getCivilPatients() throws IOException {
        AuditService.getInstance().log("Requested civil patients",new Timestamp(System.currentTimeMillis()));
        return patientRepo.getCivilPatients();
    }

    public Set<Patient> getMilitaryPatients() throws IOException {
        AuditService.getInstance().log("Requested military patients",new Timestamp(System.currentTimeMillis()));
        return patientRepo.getMilitaryPatients();
    }

    public boolean setPatientFirstName(int SSN, String firstName) throws IOException {
        AuditService.getInstance().log("Requested change first name of a patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.setPatientFirstName(SSN, firstName);
    }

    public boolean setPatientLastName(int SSN, String lastName) throws IOException {
        AuditService.getInstance().log("Requested change last name of a patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.setPatientLastName(SSN, lastName);
    }

    public boolean setPatientWeight(int SSN, int weight) throws IOException {
        AuditService.getInstance().log("Requested change weight of a patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.setPatientWeight(SSN,weight);
    }

    public boolean setPatientAge(int SSN, int age) throws IOException {
        AuditService.getInstance().log("Requested change age of a patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.setPatientAge(SSN, age);
    }

    public boolean setPatientHeight(int SSN, double height) throws IOException {
        AuditService.getInstance().log("Requested change height of a patient",new Timestamp(System.currentTimeMillis()));
        return patientRepo.setPatientHeight(SSN, height);
    }

}
