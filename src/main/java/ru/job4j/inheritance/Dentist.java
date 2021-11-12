package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String qualification;

    public Dentist(String name, String surname, String education, String birthday,
                   int experience, String qualification) {
        super(name, surname, education, birthday, experience);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}
