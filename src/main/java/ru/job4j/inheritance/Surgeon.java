package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String hospitalNumber;

    public Surgeon(String name, String surname, String education, String birthday,
                   int experience, String hospitalNumber) {
        super(name, surname, education, birthday, experience);
        this.hospitalNumber = hospitalNumber;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }
}
