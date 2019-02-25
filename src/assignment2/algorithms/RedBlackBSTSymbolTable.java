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
public class RedBlackBSTSymbolTable<K, V> implements SymbolTable<K, V> {
    private Node<K, V> head = null;

    @Override
    public void put(K key, V value) {
        if(head == null)
        {
            head = new Node<>();
            head.setRed(false);
            head.setKey(key);
            head.setData(value);
        }
        else
        {
            Node<K,V> newNode = new Node<>();
            newNode.setRed(true);
            newNode.setKey(key);
            newNode.setData(value);
            
            newNode = insertIntoTree(newNode);
            fixTreeIntegrity(newNode);
        }
    }
    
    private void fixTreeIntegrity(Node<K,V> node)
    {
        if(node.getParent() == null)
        {
            if(node.isRed())
                node.setRed(false);
        }
        else
        {
            try{
                Node<K,V> child = node;
                Node<K,V> parent = node.getParent();
                Node<K,V> grandParent = parent.getParent();
                
                boolean parentIsRed = parent.isRed();

                if(parentIsRed)
                {
                    if(getSibling(parent) != null && getSibling(parent).isRed())
                    {
                        //Recoloring
                        System.out.println("Recoloring!");
                        parent.setRed(false);
                        getSibling(parent).setRed(false);
                        grandParent.setRed(true);
                    }
                    else
                    {
                        //RotationStuff
                        boolean parentIsLeft = nodeIsLeft(parent, grandParent);
                        boolean childIsLeft = nodeIsLeft(child, parent);

                        //LeftLeft
                        if(parentIsLeft && childIsLeft)
                        {
                            System.out.println("Rotating left left");
                            rotateLeftLeft(parent,grandParent);
                        }

                        //RightRight
                        else if(!parentIsLeft && !childIsLeft)
                        {
                            System.out.println("Rotating right right");
                            rotateRightRight(parent,grandParent);
                        }

                        //LeftRight
                        else if(parentIsLeft && !childIsLeft)
                        {
                            System.out.println("Rotating left right");
                            rotateLeftRight(child,parent,grandParent);
                        }

                        //RightLeft
                        else if(!parentIsLeft && childIsLeft)
                        {
                            System.out.println("Rotating right left");
                            rotateRightLeft(child,parent,grandParent);
                        }
                    }
                }
                fixTreeIntegrity(grandParent);
            }
            catch(Exception e){}
        }
    }
    
    private void rotateLeftLeft(Node<K,V> parent,Node<K,V> grandParent)
    {
        Node<K,V> tempNode = grandParent.getParent();
        
        if(tempNode != null)
        {
            if(nodeIsLeft(grandParent, tempNode))
                tempNode.setLeft(parent);
            else
                tempNode.setRight(parent);
        }

        grandParent.setLeft(parent.getRight());
        grandParent.setParent(parent);

        parent.setParent(tempNode);
        parent.setRight(grandParent);
        
        if(parent.getParent() == null)
            head = parent;
        
        parent.setRed(false);
        grandParent.setRed(true);
    }
    
    private void rotateRightRight(Node<K,V> parent,Node<K,V> grandParent)
    {
        
        Node<K,V> tempNode = grandParent.getParent();

        if(tempNode != null)
        {
            if(nodeIsLeft(grandParent, tempNode))
                tempNode.setLeft(parent);
            else
                tempNode.setRight(parent);
        }

        grandParent.setRight(parent.getLeft());
        grandParent.setParent(parent);

        parent.setParent(tempNode);
        parent.setLeft(grandParent);
        
        if(parent.getParent() == null)
            head = parent;

        parent.setRed(false);
        grandParent.setRed(true);
    }
    
    private void rotateLeftRight(Node<K,V> child, Node<K,V> parent,Node<K,V> grandParent)
    {        
        parent.setParent(child);
        parent.setRight(child.getLeft());
        
        child.setParent(grandParent);
        child.setLeft(parent);
        
        grandParent.setLeft(child);
        
        rotateLeftLeft(child,grandParent);
    }
    
    private void rotateRightLeft(Node<K,V> child, Node<K,V> parent,Node<K,V> grandParent)
    {
        parent.setParent(child);
        parent.setLeft(child.getRight());
        
        child.setParent(grandParent);
        child.setRight(parent);
        
        grandParent.setRight(child);
        
        rotateRightRight(child,grandParent);
    }
    
    private Node<K,V> getSibling(Node<K,V> node){
        Node<K,V> siblingNode = null;
        
        try {
            if(!(node.getKey().equals(head.getKey()))) 
            {
              if(node.getParent().getLeft().getKey().equals(node.getKey()))
                  siblingNode = node.getParent().getRight();
              else
                  siblingNode = node.getParent().getLeft();
            }
        } catch (Exception e) {
        }
        
        
        return siblingNode;
    }
    
    private boolean nodeIsLeft(Node<K,V> a, Node<K,V> b)
    {
        String aKey = (String)a.getKey();
        String bKey = (String)b.getKey();
        
        if(aKey.compareTo(bKey) < 0)
            return true;
        else
            return false;
    }

    private Node<K,V> insertIntoTree(Node<K,V> node){
        Node<K,V> pointer = head;
        boolean foundNode = false;
        
        String currentKey;
        String searchingKey = (String)node.getKey();
        
        while (pointer != null && !foundNode)
        {
            currentKey = (String)pointer.getKey();
            
            if(currentKey.equals(searchingKey))
            {
                
                pointer.setData(node.getData());
                foundNode = true;
            }
            else
            {
                if(searchingKey.compareTo(currentKey) < 0)
                {
                    if(pointer.getLeft() == null)
                    {
                        pointer.setLeft(node);
                        node.setParent(pointer);
                        foundNode = true;
                    }
                    else
                    {
                        pointer = pointer.getLeft();
                    }
                }
                else
                {
                    if(pointer.getRight()== null)
                    {
                        pointer.setRight(node);
                        node.setParent(pointer);
                        foundNode = true;
                    }
                    else
                    {
                        pointer = pointer.getRight();
                    }
                }
            }
        }
        
        return node;
    }
    
    @Override
    public V get(K key) {
        Node<K,V> pointer = head;
        boolean foundData = false;
        String currentKey;
        String searchingKey = (String)key;
        while (pointer != null && !foundData)
        {
            currentKey = (String)pointer.getKey();
            if(currentKey.equals(searchingKey))
            {
                foundData = true;
            }
            else
            {
                if(searchingKey.compareTo(currentKey) < 0)
                    pointer = pointer.getLeft();
                else
                    pointer = pointer.getRight();
            }
        }

        if(!foundData)
            throw new InvalidKeyException();
        
        return pointer.getData();
    }

    @Override
    public int size() {
        return traverseTreeSum(head);
    }
    
    private int traverseTreeSum(Node<K, V> node)
    {
        int size = 1;
        
        if(node.getLeft() != null)
            size += traverseTreeSum(node.getLeft());
        
        if(node.getRight() != null)
            size += traverseTreeSum(node.getRight());
        
        return size;
    }
    
    private ArrayList<K> traverseTreeKey(Node<K, V> node)
    {
        ArrayList<K> listOfKeys = new ArrayList<>();
        listOfKeys.add(node.getKey());
        
        if(node.getLeft() != null)
            listOfKeys.addAll(traverseTreeKey(node.getLeft()));
        
        if(node.getRight() != null)
            listOfKeys.addAll(traverseTreeKey(node.getRight()));
        
        return listOfKeys;
    }
    
    public void printTree()
    {
        TreePrinter.print(head);
        System.out.println("\n------------------------------\n");
    }
    @Override
    public Iterable<K> keys() {
        return traverseTreeKey(head);
    }
}
