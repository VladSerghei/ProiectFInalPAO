package repositories;

import model.Doctor;
import model.FamilyDoctor;
import model.SpecialistDoctor;
import service.DoctorServiceInOut;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DoctorRepo {

    private final Set<Doctor> doctors;
    public DoctorRepo() throws IOException {
        doctors = DoctorServiceInOut.getInstance().loadDoctors();
    }

    public Set<Doctor> getDoctors(){
        return Collections.unmodifiableSet(doctors);
    }

    public boolean add(final Doctor doctor){
        return doctors.add(doctor);
    }

    public boolean remove(final int idNo){
        final Doctor doctor = getDoctorByIdNo(idNo);
        if(doctor == null)
            return false;
        return doctors.remove(doctor);
    }

    public Doctor getDoctorByIdNo(int idNo) {
        for(final Doctor doctor:doctors){
            if(doctor.getIdNo() == idNo)
                return doctor;
        }
        return null;
    }

    public Set<Doctor> getDoctorsByFirstName(String firstName){
        Set<Doctor> srcResult = null;
        for(final Doctor doctor:doctors){
            if(doctor.getFirstName() == firstName) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(doctor);
            }
        }
        return srcResult;
    }

    public Set<Doctor> getDoctorsByLastName(String lastName){
        Set<Doctor> srcResult = null;
        for(final Doctor doctor:doctors){
            if(doctor.getLastName().equals(lastName)) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(doctor);
            }
        }
        return srcResult;
    }

    public Set<Doctor> getFamilyDoctors(){
        Set<Doctor> srcResult = null;
        for(final Doctor doctor:doctors){
            if(doctor.getClass() == FamilyDoctor.class) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(doctor);
            }
        }
        return srcResult;
    }

    public Set<Doctor> getSpecialistDoctors(){
        Set<Doctor> srcResult = null;
        for(final Doctor doctor:doctors){
            if(doctor.getClass() == SpecialistDoctor.class) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(doctor);
            }
        }
        return srcResult;
    }

    public boolean setDoctorFirstName(int idNo, String firstName){
        Doctor doctor = getDoctorByIdNo(idNo);
        if(doctor == null)
            return false;
        doctor.setFirstName(firstName);
        return true;
    }

    public boolean setDoctorLastName(int idNo, String lastName){
        Doctor doctor = getDoctorByIdNo(idNo);
        if(doctor == null)
            return false;
        doctor.setLastName(lastName);
        return true;
    }



}
