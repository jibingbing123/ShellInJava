package com.bb.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ShellInJava
 *
 * @author jibingbing
 * @date 2018/06/10
 **/
public class ShellInJava {
    public static void main(String[] args) {
        try {
            execShell("/Users/jibingbing/Documents/shellLearning/funWithParam.sh", new String[]{"1", "2", "3", "4"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execShell(String shpath, String... params) throws Exception {
        StringBuilder bashCommand = new StringBuilder(shpath).append(" ");
        for (String param : params) {
            bashCommand.append(param).append(" ");
        }

        Process process = Runtime.getRuntime().exec(bashCommand.toString());
        process.waitFor();

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        br.close();
        String result = sb.toString();
        System.out.println(result);
    }
}
