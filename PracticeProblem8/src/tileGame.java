import java.util.*;

public class tileGame {
    // The method, tileGame takes the stack and the queue as an argument.
    public static int tileGame(ArrayDeque<Integer> stack, Queue<Integer> q){
        // Starting variable for turns.
        int turn = 0;
        // Continue the game until the stack is not empty.
        while (!stack.isEmpty()) {
            turn +=1;
            int top = stack.peek();
            stack.pop();
            // Check the top element.
            if (top == 1){
                for(int i=0; i<1; i++){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                    else {
                        break;
                    }
                }
            }
            // If top element is 2, then pop two elements from the stack.
            else {
                for (int i = 0; i<3; i++){
                    if (!q.isEmpty()) {
                        int number = q.peek();
                        // Push it to the stack.
                        stack.push(number);
                        q.remove();
                    }
                    // Break from the for loop.
                    else {
                        break;
                    }
                }
            }
        }
        return turn;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in stack: ");
        int number_of_elements_stack = sc.nextInt();
        //Initialize the stack.
        ArrayDeque<Integer>stack = new ArrayDeque<Integer>();
        // Take inputs from the user in the stack.
        System.out.println("Enter the elements in the stack (from bottom to top): ");
        for (int i = 0; i<number_of_elements_stack; i++) {
            int num = sc.nextInt();
            stack.push(num);
        }
        System.out.println("Enter the number of elements in queue: ");
        int number_of_elements_queue = sc.nextInt();
        Queue<Integer>q = new LinkedList<Integer>();

        System.out.println("Enter the elements in the queue: ");
        for (int i = 0; i<number_of_elements_queue; i++){
            int num = sc.nextInt();
            q.add(num);
        }
        System.out.println("");
        // Call the method.
        int answer = tileGame(stack, q);
        // Display the answer.
        System.out.println("Number of turns for stack to become empty = "+answer);

    }
}