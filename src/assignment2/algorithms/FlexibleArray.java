/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.algorithms;

import java.security.KeyException;
import java.util.ArrayList;
import javax.management.openmbean.InvalidKeyException;

/**
 *
 * @author Kast
 * @param <K>
 * @param <V>
 */
public class FlexibleArray<K, V> implements SymbolTable<K, V>{
    private Object[] arrayNodes;
    //Starting at -1 so the first time we put() we add at the position 0
    private int count = -1;
    
    public FlexibleArray(int size)
    {
        arrayNodes = new Object[size];
    }
    
    private Object[] ConstantPayloadExpand()
    {
            Object[] temp = new Object[count*2];
            
            for(int i = 0; i<arrayNodes.length; i++)
            {
                temp[i] = arrayNodes[i];
            }
            
            return temp;
    }
    
    @Override
    public int size()
    {
        return arrayNodes.length;
    }

    @Override
    public void put(K key, V value) {
        
        try 
        {
           int nodeIndex = getIndex(key);
           ((Node < K, V >)arrayNodes[nodeIndex]).setData(value);
        } 
        catch (Exception e)
        {
            if(count<arrayNodes.length)
                count++;
            if(count>= arrayNodes.length)
                arrayNodes = ConstantPayloadExpand();
            
            Node<K,V> node = new Node<>();
            node.setKey(key);
            node.setData(value);
            arrayNodes[count] = node;
        }
    }

    private int getIndex(K key){ 
        boolean keyFound = false;
        int index = 0;
        
        while(index < arrayNodes.length && !keyFound)
        {
            if(((Node < K, V >)arrayNodes[index]).getKey().equals(key))
                keyFound = true;
            else
                index++;
        }
        
        if(!keyFound)
            throw new InvalidKeyException();
        
        return index;
    }
            
    @Override
    public V get(K key) {
        boolean keyFound = false;
        int index = 0;
        
        while(index < arrayNodes.length && !keyFound)
        {
            if(((Node < K, V >)arrayNodes[index]).getKey().equals(key))
                keyFound = true;
            else
                index++;
        }
        
        if(!keyFound)
            throw new InvalidKeyException();
        
        return ((Node < K, V >)arrayNodes[index]).getData();
    }

    @Override
    public Iterable<K> keys() {
        ArrayList<K> arrayListOfKeys = new ArrayList<>();
        
        for(Object node : arrayNodes)
        {
            if(node != null)
            {
                arrayListOfKeys.add(((Node < K, V >)node).getKey());
            }
        }
        
        return arrayListOfKeys;
    }
}
