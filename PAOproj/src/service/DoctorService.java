package service;


import model.Doctor;

import repositories.DoctorRepo;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;

public final class DoctorService {

    private static DoctorService instance;
    private final DoctorRepo doctorRepo;

    private DoctorService() throws IOException {
        doctorRepo = new DoctorRepo();
    }

    public static DoctorService getInstance() throws IOException {
        if(instance == null)
            instance = new DoctorService();
        return instance;
    }

    public Set<Doctor> getDoctors() throws IOException {
        AuditService.getInstance().log("Requested doctors",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.getDoctors();
    }

    public boolean addDoctor(Doctor doctor) throws IOException {
        AuditService.getInstance().log("Added doctor",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.add(doctor);
    }

    public boolean removeDoctor(int idNo) throws IOException {
        AuditService.getInstance().log("Removed doctor",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.remove(idNo);
    }

    public Doctor getDoctorById(int idNo) throws IOException {
        AuditService.getInstance().log("Requested doctors by idNo",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.getDoctorByIdNo(idNo);
    }

    public Set<Doctor> getDoctorsByFirstName(String firstName) throws IOException {
        AuditService.getInstance().log("Requested doctors by first name",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.getDoctorsByFirstName(firstName);
    }

    public Set<Doctor> getDoctorsByLastName(String lastName) throws IOException {
        AuditService.getInstance().log("Requested doctors by last name",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.getDoctorsByLastName(lastName);
    }

    public Set<Doctor> getFamilyDoctors() throws IOException {
        AuditService.getInstance().log("Requested family doctors",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.getFamilyDoctors();
    }

    public Set<Doctor> getSpecialistDoctors() throws IOException {
        AuditService.getInstance().log("Requested specialist doctors",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.getSpecialistDoctors();
    }

    public boolean setDoctorFirstName(int idNo, String firstName) throws IOException {
        AuditService.getInstance().log("Requested change first name of a doctor",new Timestamp(System.currentTimeMillis()));
        return doctorRepo.setDoctorFirstName(idNo, firstName);
    }

    public boolean setDoctorLastName(int idNo, String lastName) throws IOException {
        AuditService.getInstance().log("Requested change last name of a doctor", new Timestamp(System.currentTimeMillis()));
        return doctorRepo.setDoctorLastName(idNo, lastName);
    }

}
