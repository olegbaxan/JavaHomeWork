package md.step;

public class Employee {
    private Integer id;
    private String name;
    private String address;
    private String phoneno;

    public Employee(int id,String name,String address,String phoneno) {
        this.id=id;
        this.name = name;
        this.address=address;
        this.phoneno=phoneno;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneno() {
        return phoneno;
    }
    public Employee(String name, String address, String phoneno) {
        this.name = name;
        this.address=address;
        this.phoneno=phoneno;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
