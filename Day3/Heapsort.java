import java.util.ArrayList;
import java.util.Scanner;

public class Heapsort{
    // declare an arrayList to store salary of each employee
    private ArrayList<Integer>salary;

    Heapsort(){
        // initializing the arrayList when the object is created
        salary = new ArrayList<>();
    }

    // method is used to swap two elements in arrayList
    private void swap(int a, int b){
        int temp = salary.get(a);
        salary.set(a,salary.get(b)) ;
        salary.set(b,temp);
    }

    // method used to return index of parent node of any node
    private int parent(int i){
        return (i-1) / 2;
    }

    // method used to return index of left child of any node
    private int left(int i){
        return 2 * i + 1;
    }

    // method used to return index of right child of any node
    private int right(int i){
        return 2 * i + 2;
    }

    // method to insert salary in heap
    public void insert(int input){
        salary.add(input);
        // upHeap method is used to put the element in the correct position after insertion
        upHeap(salary.size() -1);
    }

    private void upHeap(int index){
        if(index == 0){
            return;
        }

        // finding index of parent node
        int p = parent(index);

        // comparing weather parent node is smaller or child node is smaller
        if(salary.get(index).compareTo(salary.get(p)) < 0){
            swap(index, p);
            upHeap(p);
        }
    }

    // this method will remove the first element of the arraylist which is the max element
    public int remove() throws Exception{
        if(salary.isEmpty()){
            throw new Exception("Salary is empty.");
        }

        // max element
        int temp = salary.get(0);

        int last = salary.remove(salary.size()-1);
        if(!salary.isEmpty()){
            // replacing last index value to first index
            salary.set(0,last);
            // downHeap method traverse downward and find the suitable positions for nodes
            downHeap(0);
        }

        // returning max value
        return temp;
    }

    private void downHeap(int index){
        int min = index;
        // finding left child pf index
        int leftIndex = left(index);
        // finding right child of node
        int rightIndex = right(index);

        // if left child is smaller than update value to left child
        if(leftIndex < salary.size() && salary.get(min).compareTo(salary.get(leftIndex)) > 0){
            min = leftIndex;
        }

        // if right cild is smaller than update value to right child
        if(rightIndex < salary.size() && salary.get(min).compareTo(salary.get(rightIndex)) > 0){
            min = rightIndex;
        }

        if(min != index){
            swap(min, index);
            downHeap(min);
        }
    }

    // heapSort empty the arraylist and output the arraylist in ascending order
    public void heapSort()throws Exception{
        while(!salary.isEmpty()){
            System.out.println(this.remove());
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // creating Heapsort object to perform heap sort
        Heapsort heap = new Heapsort();
        for(int i=0; i<n; i++){
            heap.insert(sc.nextInt());
        }

        heap.heapSort();
    }
}
