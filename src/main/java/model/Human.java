package model;

public class Human {

    private String firstName;
    private String secondName;
    private int age;
    private boolean hasJob;

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public int getAge() {
        return this.age;
    }

    public boolean getHasJob() {
        return this.hasJob;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHasJob(boolean hasJob) {
        this.hasJob = hasJob;
    }
}
