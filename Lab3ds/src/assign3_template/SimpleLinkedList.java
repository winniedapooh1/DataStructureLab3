//File: SimpleLinkedList.java. 
//Add a file header comment or a class header comment to your work.

package assign3_template;

/**
 * Assign 3 template. Implement more methods in List interface.
 */
public class SimpleLinkedList {

    //-------Start of Assign 3  --------/  
    
    //2.1.2 Coding Requirements
    //You can call other methods to complete a method.
    //You can also add private methods, and then call these methods 
    //  to complete a method required in this assignment. 
    //You are NOT allowed to add or remove data fields to/from SimpleLinkedList class. 
    //You are NOT allowed to change the definition of Node class.
    
    //2.1.1 What Code to Add
    //-----Required ---------------//    
    
    //Remove the first occurrence of the specified item from this linked list. 
    // If success, return true. Otherwise, return false.
    public boolean removeByValue(int item) {
        //add your own code
        //Hint:
        //  call your indexOf(...) to locate the item,
        //  convert the following in SingleLinkedList<E>
        //     private E removeFirst()        
        //     private Node<E> getNode(int index)         
        //     private E removeAfter(Node<E> node)
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        int index = indexOf(item);
        int i =0;
        Node current = head;
        Node delete = getNode(index);//stores deleted node
            while(current != null){
                if(current.data == item){
                    size--;
                    Node prev = getNode(index -1);
                    prev.next = delete.next;//Previoius node
                    return true;
                }
                current = current.next;
        }
        return false;
    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    // if index is size, append item to the end of this linked list.
    public void add(int index, int item) {//Question
        //Hint:
        //convert the following in SingleLinkedList<E>
        //    public void add(int index, E item)
        //    public void addFirst(E item)
        //    private Node<E> getNode(int index)
    	//    private void addAfter(Node<E> node, E item)

        if(head == null){//If the list is empty
            head = new Node(item);
            size++;
        }
        Node newNode = new Node(item);
        Node current = head;//Points to the first
        int i = 0;
        if(current != null) {
            while (i < index) {//Loops through till indexx
                current = current.next;//Index where you are adding
                i++;
            }
            current = newNode.next;//makes prev node point to new node
            newNode = newNode.next;// namkes new node point to node infornt of new node
            size++;
        }
    }

    //Get the integer item at the specified position and return the integer value. 
    //If the index is not valid, throw an exception or print an error message 
    //  and return Integer.MIN_VALUE.
    private Node getNode(int index){
        //add your own code
        //Hint:
	//convert the following in SingleLinkedList<E>
        //    public E get(int index)
        //    private Node<E> getNode(int index)

        Node current = head;//Points to first
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    //Search this linked list for the first occurrence of the specified integer: item. 
    //If the item is found, return its index. Otherwise return -1.
    public int indexOf(int item) {
        //add your own code
        //Hint:
        //use a looping like the one in toString()
        //in addition, add a counter, 
        //    increment the counter for each element checked 
        //can use size for loop control.

        Node current = head;
        Node items = new Node(item);
        int index = 0;
        while(current != null){
            if(current.data == item){
                return index;
            }
         index++;
         current = current.next;
        }
        return -1;
    }

    //Find out if the specified integer: item is in this linked list. 
    // Returns true if yes, false otherwise.
    public boolean contains(int item) {
        //add your own code
        //Hint:
        //can either call indexOf(...) 
        //    or directly search for the item using a loop like the one in toString()

        Node current = head;//start with first Node
        Node newNode = getNode(indexOf(item)); // new item Node
        while (current != null) {   //check if there is still nodes remaining
            if(current.data == newNode.data){
                return true;
            }
            current= current.next;
        }
        return false;
    }

    //return how many integers are in this linked list
    public int size() {
        //add your own code
        //Hint: this is actually a getter
        return this.size;
    }

    //-----Bonus ---------------//
    //Remove the item at the specified position from this linked list and 
    //  return the removed item.
    //If the index is not valid, throw an exception or print an error message 
    //   and return Integer.MIN_VALUE.
    public int removeByIndex(int index) {
        //Add your own code
        //Hint:        
        //verify that index is valid
        //convert the following in SingleLinkedList<E>
        //     private Node<E> getNode(int index) 
        //     private E removeAfter(Node<E> node)
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference

        int i =0;
        Node current = head;
        Node delete = getNode(index);//stores deleted node
        while(current != null){
            if(current.data == delete.data){
                size--;
                Node prev = getNode(index -1);
                prev.next = delete.next;//Previoius node
                return delete.data;
            }
            current = current.next;
        }
        return -1;

    }

    //-------End of Assign 3 --------/ 

    //Don't change the code below.
    //Nested class Node, enclosing class: SimpleLinkedList
    private static class Node {

        private int data;
        private Node next;

        //constructor used to create a standalone node without a successor
        private Node(int data) {
            this.data = data;
            next = null;
        }
        
        //constructor used to create a Node with a given successor
        private Node(int dataNew, Node nextNew) {
            data = dataNew;
            next = nextNew;
        }
       
    }

    //the reference to the first Node in this linked list.
    private Node head;
    //the size of this linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    //append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }

    //return a string that contains all integers (in the original sequence) in this linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
