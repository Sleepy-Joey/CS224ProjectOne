import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestQuickSort {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        String inputFilePath = "company_Poly.csv";
        try {
            File file = new File(inputFilePath);
            Scanner scnr = new Scanner(file);
            String header = scnr.nextLine();
            //System.out.println(header);
            while (scnr.hasNext()) {
                String employeeRecord = scnr.nextLine();
                String[] s = employeeRecord.split(",");
                Employee empObject = new Employee(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3]));
                empList.add(empObject);
            }
            scnr.close();
            for (int i = 0; i < 5; i++) {
                //System.out.println(empList.get(i).toString());
            }
            System.out.println("After sorting");
            SortingAlgorithm algo = new SortingAlgorithm();
            long start = System.nanoTime();
            algo.quick_sort(empList);

            long end = System.nanoTime();
            System.out.println("\n\nRunning time by using " + " Quick sort is:" + (double) (end - start) / 1000000000 + " seconds");
            String fileName = "company_Poly_QuickSort.csv";
            String outPutDir = "./outputs/";
            File dir = new File(outPutDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            writeToFile(outPutDir, fileName, empList);
        } catch (FileNotFoundException e) {
            System.out.println("File can not read");
        }
    }//Close main

    public static void writeToFile(String outPutDir,
                                   String fileName, List<Employee> empList) {
        try (FileWriter writer = new FileWriter(outPutDir + "/" + fileName))
        {
          // FileWriter writer = new FileWriter(outPutDir + "/" + fileName);
            String header = "Id, First_Name, Last_Name, Age\n";
            writer.write(header);
            for (Employee e : empList) {
                String line = Integer.toString(e.getID()) + ","
                        + e.getFirstName() + "," + e.getLastName() + "," +
                        Integer.toString(e.getAge()) + "\n";
                writer.write(line);
            }
        }//close try
        catch (IOException e) {
            System.out.println(e);
        }//close catch
    }
}//Close class