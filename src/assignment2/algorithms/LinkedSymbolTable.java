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
 * @param <K>
 * @param <V>
 */
public class LinkedSymbolTable<K,V> implements SymbolTable<K,V>{

    private Node head;
    
    @Override
    public void put(K key, V value) {
        
        try 
        {
            Node<K,V> newNode = getNode(key);
            newNode.setData(value);
        } 
        catch (Exception e) 
        {
            Node<K,V> newNode = new Node<>();
            newNode.setNext(head);
            head = newNode;
            newNode.setKey(key);
            newNode.setData(value);
        }
        
    }

    private Node<K,V> getNode(K key){
        Node<K, V> pointer = head;
        boolean keyFound = false;
        
        while (pointer != null && !keyFound)
        {
            if(pointer.getKey().equals(key))
                keyFound = true;
            else
                pointer = pointer.getNext();
        }

        if (pointer == null)
        {
            throw new InvalidKeyException();
        }

        return pointer;
    }
    
    @Override
    public V get(K key) {
        Node<K, V> pointer = head;
        boolean keyFound = false;
        
        while (pointer != null && !keyFound)
        {
            if(pointer.getKey().equals(key))
                keyFound = true;
            else
                pointer = pointer.getNext();
        }

        if (pointer == null)
        {
            throw new InvalidKeyException();
        }

        return pointer.getData();
    }

    @Override
    public int size() {
        Node<K, V> pointer = head;
        int counter = 0;
        
        while (pointer != null)
        {
            counter++;
            pointer = pointer.getNext();
        }
        
        return counter;
    }

    @Override
    public Iterable<K> keys() {
        Node<K, V> pointer = head;
        ArrayList<K> keyArrayList = new ArrayList<>();
        
        while (pointer != null)
        {
            keyArrayList.add(pointer.getKey());
            pointer = pointer.getNext();
        }
        
        return keyArrayList;
    }
    
}
