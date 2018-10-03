//complete
public class Contact {
    private String name, number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // make a "factory method" that can be called and passed strings too.

    public static Contact creatContact(String name, String number){
        return new Contact(name, number);
    }
}
