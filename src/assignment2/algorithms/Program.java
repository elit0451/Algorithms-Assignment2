/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Kast
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Program().run();
    }
    
    private void run()
    {
        try{
            String[] words = FileUtility.toStringArray("C:\\Users\\Kast\\Documents\\School\\CBS\\ALGORITHMS\\Shakespeare_Complete_Smaller.txt","[^A-Za-z]");
            
            //String[] words2 = new String[100];

            //System.arraycopy(words, 0, words2, 0, words2.length);
            ArrayList<SymbolTable<String,Integer>> symbolTables = new ArrayList<>();
            
            //symbolTables.add(new LinkedSymbolTable<>());
            //symbolTables.add(new FlexibleArray<>(100));
            //symbolTables.add(new HashSymbolTable<>(words.length));
            symbolTables.add(new RedBlackBSTSymbolTable<>());
            
            doSymbolTablesInsertionAndReading(words, symbolTables);
        }
        catch(Exception e)
        {
            System.out.println("Whoops! Something went wrong :( " + Arrays.toString(e.getStackTrace()));
        }
    }

    private void doSymbolTablesInsertionAndReading(String[] words, ArrayList<SymbolTable<String,Integer>> symbolTables) {
        boolean printree  = false;
        for(SymbolTable<String, Integer> symbolTable : symbolTables)
        {
            for(String s : words)
            {
                int value = 1;
                try
                {
                    value = symbolTable.get(s) + 1;
                }
                catch(Exception e)
                {}
                
                symbolTable.put(s, value);
                if(s.equals("in"))
                    printree = true;
                if(printree)
                ((RedBlackBSTSymbolTable<String,Integer>) symbolTable).printTree();
            }
            
            Iterable<String> keys = symbolTable.keys();

            System.out.println("Size: " + symbolTable.size());

            int c = 0;
            for(String key:keys)
            {
                c++;
                //System.out.println(key + " : " + symbolTable.get(key));
            }
            
            System.out.println("Count: " + c);
            System.out.println("\n-------------------------------------------------------\n");
        }
    }
    
}
