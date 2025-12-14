package com.pearl.novdev.oop.hospital;

import com.pearl.novdev.oop.hospital.model.Doctor;
import com.pearl.novdev.oop.hospital.model.Patient;
import com.pearl.novdev.oop.hospital.service.Hospital;

import java.time.LocalDateTime;

public class HospitalMain {

    public static void main(String[] args){
        Hospital hospital = new Hospital();

        // === Step 1: Add Doctors ===
        Doctor d1 = new Doctor("Dr. Aung", 45, "Cardiology");
        Doctor d2 = new Doctor("Dr. Su", 38, "Dermatology");
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        // === Step 2: Add Patients ===
        Patient p1 = new Patient("Mg Mg", 25, "Fever");
        Patient p2 = new Patient("Aye Aye", 33, "Skin Allergy");
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // === Step 3: Show records ===
        hospital.listDoctors();
        System.out.println();
        hospital.listPatients();
        System.out.println();

        // === Step 4: Book appointment ===
        hospital.bookAppointment(d1, p1, LocalDateTime.of(2025, 1, 10, 14, 30));
        hospital.bookAppointment(d2, p2, LocalDateTime.of(2025, 1, 11, 16, 00));

        // === Step 5: List appointments ===
        System.out.println();
        hospital.listAllAppointments();

        // === Step 6: Filter appointments by doctor ===
        System.out.println();
        hospital.listAppointmentsByDoctor(d1);
    }
}
