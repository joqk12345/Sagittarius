/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkit.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RUN Luck Man
 *
 * @author qiaokai
 * @date 2013-11-12 9:26:47
 */
public class HelloWorld {

    public static void main(String args[]) {
        System.out.println("Hello World~~");
//        runShell0();
//        runShell1();
//        runShell2();
        runShell3();
    }
        public static void runShell3(){
         try {
            System.out.println("shell3 Start");
            String s = null;
            Process process1 = Runtime.getRuntime().exec("cd /home/thinkit/huawei_test;sh hwrun.sh /home/thinkit/huawei_voice/v7 /home/thinkit/huawei_voice/r7 /home/thinkit/huawei_voice/v7.list");
            int ShellStatus = process1.waitFor();
            byte[] b = new byte[32];
            InputStream in = process1.getInputStream();

            byte[] content = new byte[0];     
            byte[] buffer = new byte[10240];    

            int eachTime = in.read(buffer); 
            while (eachTime != -1) {
                content = concatByteArrays(content, buffer, eachTime);
                eachTime = in.read(buffer); 
            }

            String contentStr = new String(content);
            System.out.println(contentStr);
            System.out.println("shell3 finish  ");

        } catch (InterruptedException ex) {
        } catch (IOException ex) {
        }
    }
    
    public static void runShell2(){
         try {
            System.out.println("shell2 Start");
            String s = null;
            Process process1 = Runtime.getRuntime().exec("sh hwrun.sh /home/thinkit/huawei_voice/v7 /home/thinkit/huawei_voice/r7 /home/thinkit/huawei_voice/v7.list");
            int ShellStatus = process1.waitFor();
            byte[] b = new byte[32];
            InputStream in = process1.getInputStream();


            byte[] content = new byte[0];     
            byte[] buffer = new byte[10240];    

            int eachTime = in.read(buffer); 
            while (eachTime != -1) {
                content = concatByteArrays(content, buffer, eachTime);
                eachTime = in.read(buffer); 
            }

            String contentStr = new String(content);
            System.out.println(contentStr);
            System.out.println("shell2 finish  ");

        } catch (InterruptedException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void runShell1() {
        try {
            System.out.println("shell Start");
            String s = null;
            Process process1 = Runtime.getRuntime().exec("cd /home/thinkit/huawei_test");
            int ShellStatus = process1.waitFor();
            byte[] b = new byte[32];
            InputStream in = process1.getInputStream();


            byte[] content = new byte[0];     
            byte[] buffer = new byte[10240];    

            int eachTime = in.read(buffer); 
            while (eachTime != -1) {
                content = concatByteArrays(content, buffer, eachTime);
                eachTime = in.read(buffer); 
            }

            String contentStr = new String(content);
            System.out.println(contentStr);
            System.out.println("shell finish  ");

        } catch (InterruptedException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void runShell0() {
        try {
            System.out.println("shell0 Start");
            String s = null;
            Process process1 = Runtime.getRuntime().exec("bash -c");
            int ShellStatus = process1.waitFor();
            byte[] b = new byte[32];
            InputStream in = process1.getInputStream();


            byte[] content = new byte[0];     
            byte[] buffer = new byte[10240];    

            int eachTime = in.read(buffer); 
            while (eachTime != -1) {
                content = concatByteArrays(content, buffer, eachTime);
                eachTime = in.read(buffer); 
            }

            String contentStr = new String(content);
            System.out.println(contentStr);
            System.out.println("shell0 finish  ");

        } catch (InterruptedException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    private static byte[] concatByteArrays(byte[] bytes1, byte[] bytes2, int sizeOfBytes2) {
        byte[] result = Arrays.copyOf(bytes1, (bytes1.length + sizeOfBytes2));
        System.arraycopy(bytes2, 0, result, bytes1.length, sizeOfBytes2);
        return result;
    }
}
