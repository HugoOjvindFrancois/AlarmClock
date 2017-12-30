/*
 * Copyright (c) 2017 Hugo Ojvind Francois
 */

package com.steakware.alarmclock.engine;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    private static Thread musicThread;
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            LOGGER.severe("Expected 2 argument : <Hour> <Minute>");
            System.exit(1);
        }

        int hour = Integer.parseInt(args[0]);

        int minute = Integer.parseInt(args[1]);


        Calendar currentTime = Calendar.getInstance();

        int hours = currentTime.get(Calendar.HOUR_OF_DAY);

        int minutes = currentTime.get(Calendar.MINUTE);

        LOGGER.info(new StringBuilder().append("Current hour : ").append(hours).append(", and minute : ").append(minutes).toString());
        LOGGER.info(new StringBuilder().append("Alarm will ring at hour : ").append(hour).append(", minute : ").append(minute).toString());

        while (hours <= hour && minutes <= minute) {

            hours = currentTime.get(Calendar.HOUR_OF_DAY);

            minutes = currentTime.get(Calendar.MINUTE);

            Thread.sleep(1000);

            currentTime = Calendar.getInstance();

        }

        LOGGER.info("Wake up !!");

        playAlarmMusic(App.class.getResource("/musics/the-game-is-on-original.wav"));

        String input = "Not a good input";

        Scanner in = new Scanner(System.in);

        while (!input.equals("Stop")) {
            input = in.nextLine();
        }

        System.exit(0);

    }

    private static void playAlarmMusic(URL file) {
        try {
            musicThread = new Thread(() -> {
                try (AudioInputStream in = AudioSystem.getAudioInputStream(file)) {
                    Clip clip = AudioSystem.getClip();
                    clip.open(in);
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }, "Music Thread");
            musicThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
