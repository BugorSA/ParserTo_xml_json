

public class Human {
    private String name;
    private int age;
    private String secondName;

    private String surname;

    public boolean isEmpty;



    public Human(String name, String secondName, String surname, int age) {
        this.name = name;
        this.age = age;
        this.secondName = secondName;
        this.surname = surname;
        isEmpty = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFullName(){
        return name + " " + secondName + " " + surname;
    }

    public String toString(){
        return getFullName() + " || " +  age;
    }
}
