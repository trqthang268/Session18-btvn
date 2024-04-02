package baitap01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Baitap01 {
    public static void main(String[] args) {
//-	B3: convert String ở bước 2 thành mảng string, mỗi từ là 1 phần tử
        String[] arrStr = readFile().split(" ");
//        System.out.println(Arrays.toString(arrStr));
//-	B4: length của mảng trên chính là số lượng từ trong file.
        System.out.println("Số lượng từ của mảng : "+ arrStr.length);

    }

    //-	B2: Tạo hàm đọc file trên và trả ra String.
    public static String readFile() {
        //-	B1: tạo file text có sẵn dữ liệu văn bản (data có thể là đề bài này)
        File file = new File("D:\\module02\\Session18-baitap\\src\\baitap01\\vanban.txt");
//        tạo file reader
        FileReader fileReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(file);
            int c;
            while ((c = fileReader.read()) != -1) { //đọc từng kí tự từ file txt
                stringBuilder.append((char) c);     // ép kiểu c về char, gán c vào stringbuilder
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
