package baitap03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Baitap03 {
    public static void main(String[] args) {
//      B2: convert thành mảng string với mỗi từ là 1 phần tử.
        String[] bai3 = readLongWords().split(" ");
//      B3: tạo 1 list string để lưu các từ tìm được.
        List<String> longestWords = new ArrayList<>();
        int longest = 0;
//      duyệt mảng tìm length lớn nhất, nếu leng của phần tử = leng lớn nhất thì add vào list
        for (String word : bai3)
        {
            if (word.length() == longest)
            {
                longestWords.add(word);
//      nếu lớn hơn length lớn nhất thì đổi list list mới và gán lại.
            } else if (word.length() > longest)
            {
                longest = word.length();
                longestWords.clear();
                longestWords.add(word);
            }
        }
//      tạo vòng lặp in ra các từ có độ dài lớn nhất, và độ dài của chúng.
        System.out.println("Các từ có độ dài lớn nhất: ");
        System.out.println(longestWords);
        System.out.println("Độ dài của chúng là"+longestWords.get(0).length());
    }
//    -	B1: đọc file thành String
    public static String readLongWords(){
        File file = new File("D:\\module02\\Session18-baitap\\src\\baitap03\\baitap03.txt");
        FileReader fileReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            fileReader = new FileReader(file);
            int c;
            while ((c = fileReader.read())!=-1){ //đọc từng kí tự từ file txt
                stringBuilder.append((char) c);   //ép kiểu c về char, gán c vào stringbuilder
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
