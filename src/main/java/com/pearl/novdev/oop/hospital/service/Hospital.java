package com.pearl.novdev.oop.hospital.service;


import com.pearl.novdev.oop.hospital.model.Appointment;
import com.pearl.novdev.oop.hospital.model.AppointmentStatus;
import com.pearl.novdev.oop.hospital.model.Doctor;
import com.pearl.novdev.oop.hospital.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    // === Doctor functions ===
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void listDoctors() {
        System.out.println("=== Doctors ===");
        for (Doctor d : doctors) {
            d.printInfo();
        }
    }

    // === Patient functions ===
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void listPatients() {
        System.out.println("=== Patients ===");
        for (Patient p : patients) {
            p.printInfo();
        }
    }

    // === Appointment functions ===
    public void bookAppointment(Doctor doctor, Patient patient, java.time.LocalDateTime dateTime) {
        Appointment appointment = new Appointment(doctor, patient, dateTime);
        appointments.add(appointment);
        System.out.println("Appointment booked successfully.");
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CANCELLED);
        System.out.println("Appointment cancelled.");
    }

    public void listAllAppointments() {
        System.out.println("=== Appointments ===");
        for (Appointment a : appointments) {
            a.printDetails();
            System.out.println("-------");
        }
    }

    public void listAppointmentsByDoctor(Doctor doctor) {
        System.out.println("Appointments for Dr. " + doctor.getName());
        for (Appointment a : appointments) {
            if (a.getDoctor().equals(doctor)) {
                a.printDetails();
                System.out.println("-------");
            }
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

}