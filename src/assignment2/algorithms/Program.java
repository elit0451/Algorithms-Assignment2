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
            
            ArrayList<SymbolTable<String,Integer>> symbolTables = new ArrayList<>();
            
            symbolTables.add(new LinkedSymbolTable<>());
            symbolTables.add(new FlexibleArray<>(100));
            symbolTables.add(new HashSymbolTable<>(words.length));
            //symbolTables.add(new RedBlackBSTSymbolTable<>());
            
            doSymbolTablesInsertionAndReading(words, symbolTables);
        }
        catch(Exception e)
        {
            System.out.println("Whoops! Something went wrong :( \n" + Arrays.toString(e.getStackTrace()));
        }
    }

    private void doSymbolTablesInsertionAndReading(String[] words, ArrayList<SymbolTable<String,Integer>> symbolTables) {
        for(SymbolTable<String, Integer> symbolTable : symbolTables)
        {
            System.out.print("Calculating insertion time for - " + symbolTable.getClass() + ": ");
            StopWatch sw = new StopWatch();
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
            }
            System.out.print(sw.elapsedTime() + "ms\n");
            /*
            //Was used with debug purposes and to make sure all the interface implementation was done correctly.
            
            Iterable<String> keys = symbolTable.keys();

            System.out.println("Structure size: " + symbolTable.size());

            int c = 0;
            for(String key:keys)
            {
                c++;
                //System.out.println(key + " : " + symbolTable.get(key));
            }
            
            System.out.println("Keys count: " + c);
            System.out.println("\n-------------------------------------------------------\n");
            */
        }
    }
    
}
