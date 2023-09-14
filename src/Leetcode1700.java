import java.util.Deque;
import java.util.LinkedList;


public class Leetcode1700 {
    /*
     * Problem: 1700. Number of Students Unable to Eat Lunch
     */
    public int countStudents(int[] students, int[] sandwiches) {
       Deque<Integer> student = new LinkedList<>();
       Deque<Integer> sandwich = new LinkedList<>();

       for(int i = 0; i < students.length; i++) {
           student.add(students[i]);
           sandwich.add(sandwiches[i]);
       }

       while(!sandwich.isEmpty()) {
            if(student.peek() == sandwich.peek()) {
                student.removeFirst();
                sandwich.removeFirst();
            }
            else {
                // Jika tidak ada sandwich yang cocok dengan student yang ada maka di break
                if (!student.contains(sandwich.peek())) {
                    break;
                }
                student.addLast(student.removeFirst());
            }
       }
       return student.size();
    }

    public static void main(String[] args) {
        Leetcode1700 lc = new Leetcode1700();
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(lc.countStudents(students, sandwiches));
    }
}
