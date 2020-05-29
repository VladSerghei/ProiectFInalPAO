package repositories;

import model.*;
import service.PatientServiceInOut;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class PatientRepo {
    private final Set<Patient> patients;
    public PatientRepo() throws IOException {
        patients = PatientServiceInOut.getInstance().loadPatients();
    }

    public Set<Patient> getPatients(){
        return Collections.unmodifiableSet(patients);
    }

    public boolean add(final Patient patient){
        return patients.add(patient);
    }

    public boolean remove(final int SSN){
        final Patient patient = getPatientBySSN(SSN);
        if(patient == null)
            return false;
        return patients.remove(patient);
    }

    public Patient getPatientBySSN(int SSN) {
        for(final Patient patient:patients){
            if(patient.getSSN() == SSN)
                return patient;
        }
        return null;
    }

    public Set<Patient> getPatientsByFirstName(String firstName){
        Set<Patient> srcResult = null;
        for(final Patient patient:patients){
            if(patient.getFirstName().equals(firstName)) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(patient);
            }
        }
        return srcResult;
    }

    public Set<Patient> getPatientsByLastName(String lastName){
        Set<Patient> srcResult = null;
        for(final Patient patient:patients){
            if(patient.getLastName().equals(lastName)) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(patient);
            }
        }
        return srcResult;
    }

    public Set<Patient> getCivilPatients(){
        Set<Patient> srcResult = null;
        for(final Patient patient:patients){
            if(patient.getClass() == CivilPatient.class) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(patient);
            }
        }
        return srcResult;
    }

    public Set<Patient> getMilitaryPatients(){
        Set<Patient> srcResult = null;
        for(final Patient patient:patients){
            if(patient.getClass() == MilitaryPatient.class) {
                if (srcResult == null)
                    srcResult = new TreeSet<>();
                srcResult.add(patient);
            }
        }
        return srcResult;
    }

    public boolean setPatientFirstName(int SSN, String firstName){
        Patient patient = getPatientBySSN(SSN);
        if(patient == null)
            return false;
        patient.setFirstName(firstName);
        return true;
    }

    public boolean setPatientLastName(int SSN, String lastName){
        Patient patient = getPatientBySSN(SSN);
        if(patient == null)
            return false;
        patient.setLastName(lastName);
        return true;
    }

    public boolean setPatientWeight(int SSN, int weight){
        Patient patient = getPatientBySSN(SSN);
        if(patient == null)
            return false;
        patient.setWeight(weight);
        return true;
    }

    public boolean setPatientAge(int SSN, int age){
        Patient patient = getPatientBySSN(SSN);
        if(patient == null)
            return false;
        patient.setAge(age);
        return true;
    }

    public boolean setPatientHeight(int SSN, double height){
        Patient patient = getPatientBySSN(SSN);
        if(patient == null)
            return false;
        patient.setHeight(height);
        return true;
    }



}
