import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StreamTests {
    public static void main(String[] args) {

//        readFile();

        try {
//            arrList();
            readerList();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile(){
        long t = System.currentTimeMillis();
        byte[] readedBytes = new byte[50];

        try (FileInputStream in = new FileInputStream("C:\\Users\\Mik\\Desktop\\PROGRAMMING\\Java3\\lesson3\\java3hw3\\src\\file-st.txt")){
            int count = in.read(readedBytes);
            System.out.println("Прочитано " + count + " байт. Содержимое файла: ");
            for (int i = 0; i < count; i++) {
                System.out.print((char) readedBytes[i]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - t);
    }

    public static void arrList() throws IOException{

        long t = System.currentTimeMillis();

        ArrayList<InputStream> al = new ArrayList<>();

        al.add(new FileInputStream("src\\fl1.txt"));
        al.add(new FileInputStream("src\\fl2.txt"));
        al.add(new FileInputStream("src\\fl3.txt"));
        al.add(new FileInputStream("src\\fl4.txt"));
        al.add(new FileInputStream("src\\fl5.txt"));
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src\\5files.txt"));
        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            System.out.print((char)x);
        }
        System.out.println(System.currentTimeMillis() - t);
    }

    public static void readerList() throws IOException {

        RandomAccessFile rnd = new RandomAccessFile("src\\read-list-file.txt", "r");

        System.out.println("Введите номер страницы: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int page = Integer.parseInt(br.readLine());
        rnd.seek(page * 1800);
        byte[] readedBytes = new byte[512];

        rnd.read(readedBytes);
        String strFromBytes = new String(readedBytes);
        System.out.println(strFromBytes);
    }
}
