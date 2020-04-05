package com.company;

/*

2019 Fix the bug. Serialization
After deserializing an object of the Solution class, we found that there is no data in the dictionary [m] :(
Fix 1 error.

Requirements:
1. There should be no void Solution method without parameters in the Solution class.
2. The Solution class must have a parameterless constructor.
3. In the Solution class, there must be a size method without parameters.
4. In the Solution class, the size method must return an int value.



 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("e:\\5.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("e:\\5.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() { //Было: public void Solution() т.е. был объявлен метод, а не коструктор, и который никто и не вызывал..
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}

