//File: SimpleLinkedListTest.java. 
//Add a file header comment or a class header comment to your work.

package assign3_template;

/**
 * Assign 3 Template.
 * Testing different methods (successful and failed calls)
 * 
 */
public class SimpleLinkedListTest {

    public static void main(String[] args) {
        
        //2.2 Revise SimpleLinkedListTest
        
        //create an empty singly linked list of int values        
        //append some integers
    
        //For method size, use one test case.
        //test all other methods using at least 2 calls:
        //  successful call, e.g. call indexOf(..) and pass an existing integer
        //  failed call, e.g. call indexOf(..) and pass a non-existing integer
   
        //You can reuse some of the code below given to you in the lectures.        
        
        //create an empty list
        SimpleLinkedList numbers = new SimpleLinkedList();
        
        //append 3 integers
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers);
        System.out.println(numbers.indexOf(30));
        System.out.println(numbers.indexOf(50));
        System.out.println(numbers.contains(10));
        System.out.println(numbers.removeByIndex(1));

        
        //dump the contents in the list in the original order
        System.out.println(numbers);
        System.out.println(numbers.size());
        //or use:
        //System.out.println(numbers.toString());        
    }   
    
}
