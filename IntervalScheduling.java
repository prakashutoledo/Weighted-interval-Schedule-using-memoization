package intervalscheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IntervalScheduling {

    static LinkedList<Element> input = new LinkedList<>();
    static int[] p;
    static int[] memory;

    public static void main(String[] args) throws FileNotFoundException {
        //Read data from user defined textfile.
        int number = fileReader("data.txt");
        //Computing number of compatible jobs in an array
        p = new int[input.size()];
        //Initializing all array element with -1.
        Arrays.fill(p, -1);
        //Base case 1;
        if (number == 0) {
            System.out.println("Profit is " + 0);
            System.exit(0);
            //Base case 2:
        } else if (number == 1) {
            System.out.println("Profit is " + input.get(0).profit);
            System.exit(0);
        }
        System.out.println("The jobs are ");
        for (int i = 0; i < number; i++) {
            System.out.println("Job " + input.get(i).num + ": " + input.get(i).start + " " + input.get(i).end + " " + input.get(i).profit);
        }
        // Sorting all elements with increasing order of finishing time
        input.sort(getElement());
        // Initializing memory array for memoization cache with -2.
        memory = new int[number];
        for (int i = 0; i < number; i++) {
            memory[i] = -2;
        }
        System.out.println("The optimum profit is : " + M_Compute_Opt(number - 1));
    }
    // Returns total number of jobs from file and initializing all jobs elements
    public static int fileReader(String name) throws FileNotFoundException {
        File newFile = new File(name);
        Scanner stdin = new Scanner(newFile);
        int count = 0;
        while (stdin.hasNextLine()) {
            String line = stdin.nextLine();
            count++;
            addElement(count, line);
        }
        return count;
    }
    // Add all jobs in linkedlist 
    private static void addElement(int count, String line) {
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(line);
        int start, finish, profit;
        while (tokenizer.hasMoreTokens()) {
            start = Integer.parseInt(tokenizer.nextToken());
            finish = Integer.parseInt(tokenizer.nextToken());
            profit = Integer.parseInt(tokenizer.nextToken());
            Element e = new Element(count, start, finish, profit);
            input.add(e);
        }
    }
    
    // Returns comparison element for sorting all jobs 
    public static Comparison getElement() {
        Element e1 = input.get(0);
        Comparison c = null;
        for (Element e2 : input) {
            c = new Comparison(e1, e2);
        }
        return c;
    }
    
    // Returns total number of compatible jobs for that job which are not overlap
    public static int compute(int k) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (input.get(i).start >= input.get(j).end) {
                    p[i] = j;
                }
            }
        }
        return p[k];
    }
    // Recurssive memoizing function for computing optimum profit
    private static int M_Compute_Opt(int j) {
        if (j == -1) {
            return 0;
        } else if (memory[j] == -2) {
            memory[j] = Math.max(input.get(j).profit + M_Compute_Opt(compute(j)), M_Compute_Opt(j - 1));
        }
        return memory[j];
    }
}
