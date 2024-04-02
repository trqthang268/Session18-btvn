package baitap02;

import java.io.*;
import java.util.Scanner;

public class Baitap02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tập tin nguồn");
        String source = scanner.nextLine();
        System.out.println("Nhập tập tin đích"); //D:\module02\Session18-baitap\src\baitap02\copybai2.txt
        String target = scanner.nextLine();
        readFileCopyByte(source,target);
    }
//  Chương trình sao chép tệp nguồn vào tệp tin đích và hiển thị số byte trong tệp
    public static void readFileCopyByte(String source,String target){
        File sourceFile = new File(source);
        File targetFile = new File(target);
//  cảnh báo người dùng nếu tệp nguồn không tồn tại hoặc nếu tập tin đích đã tồn tại.
        if (!sourceFile.exists()){
            System.out.println("File nguồn không tồn tại");
            return;
        }
        if (targetFile.exists()){
            System.out.println("File đích đã tồn tại");
            return;
        }
//        Để sao chép nội dung từ tệp tin nguồn đến tệp tin đích,
//        bạn nên sử dụng luồng đầu vào để đọc byte từ tệp nguồn và
//        luồng đầu ra để gửi byte đến tệp tin đích, bất kể nội dung của tệp.
        BufferedWriter bfw = null;
        BufferedReader bfr = null;
        try{
            bfr = new BufferedReader(new FileReader(sourceFile));
            bfw = new BufferedWriter(new FileWriter(targetFile));
            int c;
            while ((c = bfr.read()) != -1){
                bfw.write(c);  // ghi từng byte vào bufferwrite
            }
            bfw.flush(); //Ghi tất cả dữ liệu được lưu trữ trong bộ đệm vào luồng
            System.out.println("Số byte trong file là : "+ targetFile.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if (bfr != null){
                    bfr.close();
                }
                if (bfw != null){
                    bfw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
