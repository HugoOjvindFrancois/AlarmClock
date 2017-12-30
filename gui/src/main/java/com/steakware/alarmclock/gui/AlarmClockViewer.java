/*
 * Copyright (c) 2017 Hugo Ojvind Francois
 */

package com.steakware.alarmclock.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class AlarmClockViewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Alarm Clock - Steakware");
        stage.setScene(new Viewer(new Controller()));
        stage.show();
    }
}
