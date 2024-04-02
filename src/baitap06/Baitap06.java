package baitap06;

import java.io.*;
import java.util.*;

public class Baitap06 {
    public static void main(String[] args) {
        File file = new File("D:\\module02\\Session18-baitap\\src\\baitap06\\baitap06.txt");
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file));
            int c;
            while ((c = bfr.read()) != -1) {
                stringBuilder.append((char) c);
            }
            List<String> arrStr = Arrays.asList(stringBuilder.toString().split(" "));
            Map<String, Integer> countValue = new HashMap<>();
            for (int i = 0; i < arrStr.size(); i++) {
                if (arrStr.get(i) == null){
                    break;
                }
                if (countValue.containsKey(arrStr.get(i))) {//kiểu tra, nếu key tồn tại value +1, nếu chua value =1
                    countValue.put(arrStr.get(i), countValue.get(arrStr.get(i) + 1));
                } else {
                    countValue.put(arrStr.get(i), 1);
                }
            }

            String maxKey = null;
            int maxValue = 0;
            for (Map.Entry<String, Integer> entry : countValue.entrySet()) {
                // duyệt để tìm key có value lớn nhất bằng entrySet
                if (entry.getValue() == null){
                    break;
                }
                if (entry.getValue() > maxValue) {
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            System.out.printf("Từ xuất hiện nhiều nhất là %s và số lần xuất hiện : %d", maxKey, maxValue);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bfr != null) {
                    bfr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }
}
