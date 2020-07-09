/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import DA.adjencyDA;
import DA.LocationDA;
import DA.categoriesDA;
import java.util.ArrayList;

/**
 *
 * @author tanyj
 */
public class BStar {
    
  
    // No. of vertices in graph 
    private int v;
    
    private List<List<Location>> listOfPath;
    // adjacency list  
    private ArrayList<Integer>[] adjList;  
     private List<Location> newAddressofPathList;
 
    public BStar(int vertices){ 
          
        //initialise vertex count 
        v = vertices; 
        listOfPath = new List<List<Location>>();  
        newAddressofPathList = new List<Location>();
        // initialise adjacency list 
        
        initAdjList();  
    } 
      public BStar(){
          
      }
    
    // initialise adjacency list 
    @SuppressWarnings("unchecked") 
    private void initAdjList() 
    { 
        adjList = new ArrayList[v]; 
        
        //ask mf 
        for(int i = 0; i < v; i++) 
        { 
            adjList[i] = new ArrayList<Integer>(); 
        } 
    } 
      
    // add edge 
    public void addEdge(int u, int v) 
    { 
         
        adjList[u].add(v);  
    } 
      
    // Prints all paths from source to destination
    public List<List<Location>> printAllPaths(int s, int d)  
    { 
        adjencyDA adDA = new adjencyDA();
        LocationDA locaDA = new LocationDA();
        categoriesDA cda = new categoriesDA();
         for(int i = 0; i < adDA.getNumofRecords();i++)
         { 
           addEdge((adDA.getAllRelatedAdjency().getValueOf(i+1).getCode_num()-5000), (adDA.getAllRelatedAdjency().getValueOf(i+1).getAdjency()-5000));
         }
         if (!(cda.checkSameCountry(locaDA.getSpecificRecord(s+5000).getName(), locaDA.getSpecificRecord(d+5000).getName()))){
            addEdge(locaDA.get_nearest_airport(locaDA.getSpecificRecord(s+5000).getName()).getCode_num()-5000, locaDA.get_nearest_airport(locaDA.getSpecificRecord(d+5000).getName()).getCode_num()-5000);
         }
        boolean[] isVisited = new boolean[v]; 
        List<Location> pathList = new List<>(); 
      
        //add source to path[] 
        pathList.add(locaDA.getSpecificRecord(s+5000)); 
          
        //Call recursive 
        
         return printAllPathsUtil(s, d, isVisited, pathList); 
    } 
  
    // A recursive    function to print 
    // all paths from 'u' to 'd'. 
    // isVisited[] keeps track of 
    // vertices in current path. 
    // localPathList<> stores actual 
    // vertices in the current path 
    private List<List<Location>> printAllPathsUtil(Integer u, Integer d, 
                                    boolean[] isVisited, 
                                    List<Location> localPathList) { 
          
        // Mark the current position 
        
        isVisited[u] = true; 
         LocationDA locaDA=new LocationDA();  
        if (u==d)  
        { 
           
            // if match found then no need to traverse more till depth 
            isVisited[u]= false; 
            List<Location> tempList = new List<Location>();
            for(int i=0;i<localPathList.size();i++){
                
                tempList.add(new Location(localPathList.getValueOf(i+1)));
               
            }
            listOfPath.add(tempList);
            
            return listOfPath; 
        } 
          
        // Recur all the vertices 
        // adjacent to current vertex 
         for (Integer i : adjList[u])    
        { 
            
            if (!isVisited[i]) 
            { 
                // store current position  
                // in path[] 
                localPathList.add(locaDA.getSpecificRecord(i+5000)); 
                printAllPathsUtil(i, d, isVisited, localPathList); 
                  
                // remove current position 
                // in path[] 
                
                for(int z =0;z<localPathList.size();z++){
                    if(localPathList.getValueOf(z+1).getName().equals(locaDA.getSpecificRecord(i+5000).getName()))
                    {
                      localPathList.remove(localPathList.getValueOf(z+1));
                      break;
                    }
                    
                }
         
                
                    
                
            } 
        } 
          
        // Mark the current position 
        isVisited[u] = false;
        return listOfPath; 

    }

    public int getV() {
        return v;
    }

    public List<List<Location>> getListOfPath() {
        return listOfPath;
    }

    public ArrayList<Integer>[] getAdjList() {
        return adjList;
    }

    public List<Location> getNewAddressofPathList() {
        return newAddressofPathList;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setListOfPath(List<List<Location>> listOfPath) {
        this.listOfPath = listOfPath;
    }

    public void setAdjList(ArrayList<Integer>[] adjList) {
        this.adjList = adjList;
    }

    public void setNewAddressofPathList(List<Location> newAddressofPathList) {
        this.newAddressofPathList = newAddressofPathList;
    }
    
}
    

