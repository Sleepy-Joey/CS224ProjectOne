import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        String inputFilePath = "company_Poly.csv";
        try{
            File file = new File(inputFilePath);
            Scanner scnr = new Scanner(file);
            String header = scnr.nextLine();
            System.out.println(header);
            while(scnr.hasNext()){
                String employeeRecord = scnr.nextLine();
                String [] s = employeeRecord.split(",");
                Employee empObject = new Employee(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3]));
                empList.add(empObject);
            }
            scnr.close();
            for(int i = 0; i < 5; i++){
                System.out.println(empList.get(i));
            }
            System.out.println("After sorting");
            SortingAlgorithm algo = new SortingAlgorithm();
            algo.bubble_sort(empList);
            for(int i = 0; i < 5; i++){
                System.out.println(empList.get(i));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
