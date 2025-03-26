public class Employee {
    private int id;
    private String first_Name;
    private String last_Name;
    private int age;

    public Employee(int id, String first_Name, String last_Name, int age){
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.age = age;
    }

    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.first_Name;
    }
    public String getLastName(){
        return this.last_Name;
    }
    public int getAge(){
        return this.age;
    }
}
