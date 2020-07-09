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
public class List<T> implements ListInterface<T>{

    private Object [] list ;
    private  final int DEFAULT_SIZE =3;
    private int currSize;
    private int backindex;

    public List() {
        this.list = new Object[DEFAULT_SIZE];
        this.currSize = 0;
        this.backindex = 0;
    }
    
    @Override
    public boolean add(T element) {
          if(currSize< list.length){
            list[currSize++]= element;
            
            }
           else
          {
          doubleArray();
          list[currSize++]= element;
          }
          return true;
      }

    @Override
    public boolean contain(T element) {
      for(int i =0 ; i < currSize ; i++){
      if( (element.equals((T)list[i])) )
      return true;
      }
      return false;
    }
    
    
    @Override
    public void doubleArray(){
    int length = list.length;
    Object[] newlist = new Object[length * 2];
    System.arraycopy(list,0,newlist,0,length);
    list=newlist;
    
    }

    @Override
    public void remove(T element) {
     if(!isEmpty()){
          for(int i =0 ; i < currSize ; i++){
              if( (element.equals((T)list[i])) )
                  {
                      for(;i<currSize;i++){
                          if(i <currSize-1)
                          list[i]=list[i+1];
                         else
                             list[i]=null;
                      }
                      currSize--;
                  }
          }
        }
    }
    
    
    @Override
    public T getValueOf(int i) {
        
      return (T)list[(i-1)];
    }
   
    
    @Override
    public boolean isEmpty() {
        return currSize==0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getAll() {
        return list;
    }

    @Override
    public int size() {
return currSize;
    }

    @Override
    public String toString() {
        String str="";
        for(int i = 0 ; i<size();i ++)
        {
            str+= ((T)list[i]).toString() + " \n";
        }
        return str;
    }
    
    
}
