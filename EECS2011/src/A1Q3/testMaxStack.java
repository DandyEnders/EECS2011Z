package A1Q3;

/**
 * Tests class MaxStack
 * @author jameselder
 */
public class testMaxStack {

    public static void main(String[] args) {
        MaxStack<Integer> myMaxStack = new MaxStack<>();

        myMaxStack.push(5); // 5
        myMaxStack.push(3); // 3 5
        myMaxStack.push(17);// 17 3 5
        myMaxStack.push(13);// 13 17 3 5
        myMaxStack.push(2);//  2 13 17 3 5
        myMaxStack.push(11);// 11 2 13 17 3 5
        System.out.println("The maximum value currently on the stack is " + myMaxStack.max()); // should be 17
        myMaxStack.pop(); //  2 13 17 3 5
        myMaxStack.pop(); // 13 17 3 5
        myMaxStack.pop(); // 17 3 5
        myMaxStack.pop(); // 3 5
        System.out.println("The maximum value currently on the stack is " + myMaxStack.max()); // should be 5
    }
}
