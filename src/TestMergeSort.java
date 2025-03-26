import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMergeSort {
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
            long start = System.nanoTime();
            algo.heap_sort(empList);
            for(int i = 0; i < 5; i++){
                System.out.println(empList.get(i));
            }
            long end = System.nanoTime();
            System.out.println("\n Running time by using heap sort is: " + (end - start)/ 1000000000.00 + " seconds");
            String fileName = "company_Poly_HeapSort.csv";
            String outPutDir = "./outPuts/";
            File dir = new File(outPutDir);
            if(!dir.exists()){
                dir.mkdirs();
            }
            writeToFile(outPutDir, fileName, empList);
        }//Close try
        catch (FileNotFoundException e){
            System.out.println(e);
        }//Close catch
    }//Close main
    public static void writeToFile(String outPutDir, String fileName, List<Employee> empList){
        try{
            FileWriter writer = new FileWriter(outPutDir + "\n" + fileName);
            String header = "ID, First_Name, Last_Name, Age\n";
            writer.write(header);
            for(Employee e: empList){
                String line = Integer.toString(e.getID()) + ", " + e.getName() + ", " + Integer.toString(e.getAge()) + "\n";
                writer.write(line);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}//Close class
