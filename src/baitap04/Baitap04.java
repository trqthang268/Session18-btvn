package baitap04;

import java.io.*;
import java.util.Scanner;

//Đề bài: Viết chương trình đọc nội dung từ file text và tạo một bản sao
// của file đó với tên mới và các từ được đảo ngược thứ tự.
public class Baitap04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//-	B1: tạo file gốc và nhập văn bản
        System.out.println("Nhập tập tin nguồn");
        String source = scanner.nextLine();  //D:\module02\Session18-baitap\src\baitap04\baitap04
        System.out.println("Nhập tập tin đích");
        String target = scanner.nextLine(); //D:\module02\Session18-baitap\src\baitap04\baitap04dao

        reverseFile(source,target);
//-	B2: đọc văn bản thành string
//-	B3: convert string thành mảng string với mỗi string là 1 từ.
//-	B4: đảo ngược mảng string và đổi lại thành 1 string  = 1 vòng lặp
//-	B5: ghi ra file mới.
    }

    public static void reverseFile(String source, String target){
        File sourceFile = new File(source);
        if (!sourceFile.exists()){
            System.out.println("Tập tin nguồn không tồn tại");
            return;
        }
        File targetFile = new File(target);
        if (targetFile.exists()){
            System.out.println("Tập tin nguồn đã tồn tại");
            return;
        }
        BufferedReader bfr = null;
        BufferedWriter bfw = null;
        StringBuilder copyString = new StringBuilder();
        try{
            bfr = new BufferedReader(new FileReader(sourceFile));
            bfw = new BufferedWriter(new FileWriter(targetFile));
            int c;
            while ((c = bfr.read())!=-1){
                copyString.append((char) c);
            }
            String[] strArr = copyString.toString().split(" ");
            copyString.setLength(0);
            for (int i = strArr.length-1; i >= 0 ; i--) {
                copyString.append(strArr[i]).append(" ");
            }
            bfw.write(copyString.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if (bfr != null) {
                    bfr.close();
                }
                if (bfw != null) {
                    bfw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
