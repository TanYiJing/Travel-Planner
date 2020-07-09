/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author User
 */
public class linkedlist<T> implements linkedlistInterface<T> {
  
  private Node firstNode; // reference to first node
  private int numberOfEntries;  	// number of entries in list
  private Node lastNode;

  
  
  public linkedlist() {
    clear();
  }

  @Override
  public final void clear() {
    firstNode = null;
    lastNode = null;
    numberOfEntries = 0;
  }
 
  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);	// create the new node

    if (isEmpty()) // if empty list
    {
      firstNode = newNode;
    } else {                       
      lastNode.next= newNode;
      newNode.previous = lastNode;
          }
    lastNode=newNode;
    numberOfEntries++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) { // OutOfMemoryError possible
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

//      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
//        newNode.next = firstNode;
//        firstNode = newNode;
//      } else {								                      // case 2: list is not empty and newPosition > 1
//        Node nodeBefore = firstNode;
//        for (int i = 1; i < newPosition - 1; ++i) {
//          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
//        }
//
//        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
//        nodeBefore.next = newNode;		// make the node before point to the new node
//      }


        if(isEmpty()){
         firstNode = newNode;
         lastNode=newNode;
        }else if ( newPosition == 1 ){
         firstNode.previous = newNode;
         newNode.next = firstNode;
         firstNode = newNode;
        }else if (newPosition == numberOfEntries){
          lastNode.next= newNode;
          newNode.previous= lastNode;
          lastNode = newNode;
        }
        else
        {
         Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next.previous= newNode;
        newNode.previous= nodeBefore;
        nodeBefore.next = newNode;
        }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

    

  @Override
  public T remove(int givenPosition) {
    T result = null;                 // return value

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = firstNode.data;     // save entry to be removed
        firstNode = firstNode.next;
      }else if (givenPosition == numberOfEntries){
         result = lastNode.data;
         lastNode = lastNode.previous;
         lastNode.next=null;
      } 
      else {                         // case 2: givenPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        result = nodeBefore.next.data;         // save entry to be removed
        nodeBefore.next = nodeBefore.next.next;
        nodeBefore.next.next.previous = nodeBefore;
// make node before point to node after the
      } 																// one to be deleted (to disconnect node from chain)

      numberOfEntries--;
    }

    return result;                   // return removed entry, or
    // null if operation fails
  }

  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        // System.out.println("Trace| currentNode.data = " + currentNode.data + "\t, i = " + i);
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }

    return found;
  }

  @Override
  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  @Override
  public boolean isEmpty() {
    boolean result;

    result = numberOfEntries == 0;

    return result;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }
  
  public String toReverse(){
    String outputStr = "";
    Node currentNode = lastNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.previous;
    }
    return outputStr;
  }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }
  
  public class Node {

    private T data;
    private Node previous;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
      this.previous=null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }

    public T getData() {
        return data;
    }
    
    
  } // end Node

} // end LList
