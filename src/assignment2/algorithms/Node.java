/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.algorithms;

import assignment2.algorithms.TreePrinter.PrintableNode;

/**
 *
 * @author Kast
 */
public class Node<K, V> implements PrintableNode{
    private Node<K, V> parent;
    private Node<K, V> left;
    private Node<K, V> right;
    private Node<K, V> next;
    private V data;
    private K key;
    private boolean red = true;

    public V getData() {
        return data;
    }

    public K getKey() {
        return key;
    }

    public Node<K, V> getParent() {
        return parent;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public boolean isRed() {
        return red;
    }

    public void setData(V data) {
        this.data = data;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setParent(Node<K, V> parent) {
        this.parent = parent;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    @Override
    public String getText() {
        String text = "";
        
        if(isRed())
            text += "R.";
        else
            text += "B.";
        
        text += getKey();
        
        return text;
    }
    
    
}
