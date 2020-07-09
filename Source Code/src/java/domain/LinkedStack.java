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
public class LinkedStack<T> implements StackInterface<T>{
    private Node topNode;
    private int currsize;
    
    public LinkedStack(){
    topNode = null;
    currsize=0;
    }

    @Override
    public void push(T newEntry) {
          Node newNode = new Node(newEntry,topNode);
          topNode=newNode;
          currsize++;
    }

    @Override
    public T pop() {
        T data = peek();
        if(!isEmpty()){
        data = topNode.data;
        topNode = topNode.next;
      currsize--;
        }

       return data;
    }

    @Override
    public T peek() {
        if(topNode==null)
            return null;
        else
            return topNode.data;
    }

    @Override
    public boolean isEmpty() {
     return topNode == null;
    }

    @Override
    public void clear() {
        topNode =null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrsize() {
     return currsize; 
    }
    
  
   
    
    
    private class Node{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next=null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        
    }
}
