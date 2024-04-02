package baitap05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Baitap05 {
    public static void main(String[] args) throws IOException { // né ngoại lệ IOEx
        BufferedReader bfr = null;
        try{
            bfr = new BufferedReader(new FileReader("D:\\module02\\Session18-baitap\\src\\baitap05\\countries.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String c;
        while ((c = bfr.readLine())!=null){ // đọc theo dòng readLine
            System.out.println(c);
        }
        bfr.close();
    }
}
