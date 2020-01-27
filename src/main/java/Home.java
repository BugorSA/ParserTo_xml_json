public class Home {
    private String type;
    private String address;
    private int age;
    public boolean isEmpty;

    public Home(String type, String address, int age) {
        this.type = type;
        this.address = address;
        this.age = age;
        isEmpty = true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return type + "  ||  " + address + "  ||  " + age;
    }
}
