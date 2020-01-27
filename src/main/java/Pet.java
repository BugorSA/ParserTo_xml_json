public class Pet {

    private String name;
    private String typePet;
    private int age;
    public boolean isEmpty;


    public Pet(String name, String typePet, int age) {
        this.name = name;
        this.typePet = typePet;
        this.age = age;
        isEmpty = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return name + " || " + typePet + " || " + age;
    }
}
