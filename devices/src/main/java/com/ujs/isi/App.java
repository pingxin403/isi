package com.ujs.isi;

import com.ujs.isi.device.UpData;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String dsidUptime;


    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(UpData.getInstance().uptime() * 1000);
                UpData.getInstance().up();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
