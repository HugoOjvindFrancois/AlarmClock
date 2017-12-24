/*
 * Copyright (c) 2017 Hugo Ojvind Francois
 */

package com.steakware.alarmclock.engine;

import java.awt.*;
import java.util.Calendar;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {




        }

        int hour = Integer.parseInt(args[0]);

        int minute = Integer.parseInt(args[1]);


        Calendar currentTime = Calendar.getInstance();

        int hours = currentTime.get(Calendar.HOUR_OF_DAY);

        int minutes = currentTime.get(Calendar.MINUTE);

        System.out.println("Current hour : " + hours + ", and minute : " + minutes);
        System.out.println("Alarm will ring at hour : " + hour + ", minute : " + minute);

        while (hours <= hour && minutes <= minute) {

            hours = currentTime.get(Calendar.HOUR_OF_DAY);

            minutes = currentTime.get(Calendar.MINUTE);

            Thread.sleep(1000);

            currentTime = Calendar.getInstance();

//            System.out.println("Hours : " + hours + ", minutes : " + minutes);

        }

        System.out.println("Over !!");

        while (true) {
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(100);
        }

    }
}
