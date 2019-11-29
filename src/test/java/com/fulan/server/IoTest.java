package com.fulan.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IoTest {

    @Test
    public void readByByteStream() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(new File("f:" + File.separator + "1.txt"));
            isr = new InputStreamReader(fis, "GBK");
            char[] chars = new char[1024];
            int length;
            while ((length = isr.read(chars)) != -1) {
                System.out.print(new String(chars, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readByCharStream() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br=null;
        try {
            fis=new FileInputStream(new File("f:" + File.separator + "1.txt"));
            isr=new InputStreamReader(fis, "GBK");
            br=new BufferedReader(isr);
            char[] chars=new char[1024];
            int length;
            while((length=br.read(chars))!=-1){
                System.out.print(new String(chars, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if(isr!=null){
                    isr.close();
                }
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
