/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.algorithms;

import java.util.ArrayList;
import javax.management.openmbean.InvalidKeyException;

/**
 *
 * @author Kast
 */
public class HashSymbolTable<K, V> implements SymbolTable<K, V>{

    private Object[] hashedNodesTable;
    
    public HashSymbolTable(int size)
    {
        hashedNodesTable = new Object[size];
    }
    
    @Override
    public void put(K key, V value) {
        int hashedKey = hashKey(key);
        
        try 
        {
            get(key);
            Node<K,V> castedNode = (Node<K,V>)hashedNodesTable[hashedKey];
            boolean keyfound = false;

            while(!keyfound) 
            {                    
                if(castedNode.getKey().equals(key))
                {
                    castedNode.setData(value);
                    keyfound = true;
                }
                else
                {
                    castedNode = castedNode.getNext();
                }
            }
        } 
        catch (Exception e) 
        {
            Node<K,V> newNode = new Node<>();
            newNode.setData(value);
            newNode.setKey(key);
            
            if(hashedNodesTable[hashedKey] != null)
                newNode.setNext((Node<K,V>)hashedNodesTable[hashedKey]);
                
            hashedNodesTable[hashedKey] = newNode;
        }
        
    }

    @Override
    public V get(K key) {
        int hashedKey = hashKey(key);
        
        Node<K,V> castedNode = (Node<K,V>)hashedNodesTable[hashedKey];
        boolean keyfound = false;
        
        while(castedNode != null && !keyfound) 
        {                    
            if(castedNode.getKey().equals(key))
                keyfound = true;
            else
                castedNode = castedNode.getNext();
        }
        
        if(hashedNodesTable[hashedKey] == null || !keyfound)
            throw new InvalidKeyException();
                
        return castedNode.getData();
    }

    @Override
    public int size() {
        return hashedNodesTable.length;
    }

    @Override
    public Iterable<K> keys() {
        ArrayList<K> arrayOfKeys = new ArrayList<>();
        for(Object node : hashedNodesTable)
        {
            if(node != null)
            {
                Node<K,V> castedNode = (Node<K,V>)node;
                while(castedNode != null) 
                {                    
                    arrayOfKeys.add(castedNode.getKey());
                    castedNode = castedNode.getNext();
                }
            }
        }
        
        return arrayOfKeys;
    }
    
    private int hashKey(K key){
        return Math.abs(key.hashCode()) % hashedNodesTable.length;
    }
}
