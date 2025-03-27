import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithm {
    private void swap(List<Employee>emp, int i, int j){
        Employee temp = emp.get(i);
        emp.set(i, emp.get(j));
        emp.set(j, temp);
    } //Close swap

    public void bubble_sort(List<Employee> emp){
        int n = emp.size();
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j< n-1-i; j++){
                if(emp.get(j).getAge()>emp.get(j+1).getAge()){
                    swap(emp, j, j+1);
                }
            }//Close inside loop
        }//Close outside loop
    }//Close bubble sort method
    public void heap_sort (List<Employee> emp){
        int n = emp.size();
        for(int i = n/2-1; i>=0; i--){
            buildMaxHeap(emp, n, i);
        }
        for(int i = n-1; i>0; i--){
            swap(emp, i, 0);
            buildMaxHeap(emp,i,0);
        }
    }
    private void buildMaxHeap(List<Employee> emp, int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && emp.get(left).getAge() > emp.get(largest).getAge()){
            largest = left;
        }
        if(right < n && emp.get(right).getAge()>emp.get(largest).getAge()){
            largest = right;
        }
        if(largest != i){
            swap(emp, largest, i);
            buildMaxHeap(emp, n, largest);
        }
    }//Close
    public void merger_sort(List<Employee> emp){
        int lowIndex = 0; int highIndex = emp.size() - 1;
        mergeSort(emp, lowIndex, highIndex);
    }
    private void mergeSort(List<Employee> emp, int lowIndex, int highIndex){
        if(lowIndex < highIndex) {
            int mid = lowIndex + (highIndex - lowIndex) / 2;
            mergeSort(emp, lowIndex, mid);
            mergeSort(emp, mid+1, highIndex);
            merge(emp, lowIndex, mid, highIndex);
        }//Close if
    }//Close mergeSort
    private void merge(List<Employee> emp, int left, int mid, int right){
        List<Employee> leftList = new ArrayList<>(emp.subList(left, mid+1));
        List<Employee> rightList = new ArrayList<>(emp.subList(mid+1, right+1));
        int i = 0, j = 0, k = left;
        while(i < leftList.size() && j < rightList.size()){
            if(leftList.get(i).getAge() <= rightList.get(j).getAge()){
                emp.set(k, leftList.get(i));
                i++;
            }else{
                emp.set(k, rightList.get(j));
                j++;
            }
            k++;
        }//Close 1st loop
        while(i < leftList.size()){
            emp.set(k, leftList.get(i));
            i++;
            k++;
        }//Close 2nd loop
        while(j < rightList.size()){
            emp.set(k, rightList.get(j));
            j++;
            k++;
        }//Close 3rd loop
    }//Close merger
    public void insertion_sort(List<Employee> emp){
        for (int i = 1; i < emp.size(); i++) {
            Employee key = emp.get(i);
            int j = i - 1;
            while (j >= 0 && emp.get(j).getAge() > key.getAge()) {
                emp.set(j + 1, emp.get(j));
                j--;
            }
            emp.set(j + 1, key);
        }
    }
    public void quick_sort(List<Employee> emp){
        quickSort(emp, 0, emp.size() - 1);
    }
    private void quickSort(List<Employee> emp, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(emp, low, high);
            quickSort(emp, low, pivotIndex - 1);
            quickSort(emp, pivotIndex + 1, high);
        }
    }
    private int partition(List<Employee> emp, int low, int high) {
        Employee pivot = emp.get(high); // Pivot is the last element
        int i = low - 1; // Index of the smaller element
        for (int j = low; j < high; j++) {
            if (emp.get(j).getAge() <= pivot.getAge()) {
                i++;
                swap(emp, i, j);
            }
        }
        swap(emp, i + 1, high);
        return i + 1; // Returning the pivot index
    }

    public void selection_sort(List<Employee> emp){
        for(int i = 0; i < emp.size(); i++){
            int minIndex = i;
            for(int j = i + 1; j < emp.size(); j++){
                if(emp.get(j).getAge() < emp.get(minIndex).getAge()){
                    minIndex = j;
                }
            }
            swap(emp, i, minIndex);
        }

    }//Close selection method
}//Close class
