/*
 * Copyright (c) 2017 Hugo Ojvind Francois
 */

package com.steakware.alarmclock.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlarmClockViewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Controller customControl = new Controller();
        customControl.setText("Hello!");

        stage.setTitle("Alarm Clock - Steakware");
        stage.setScene(new Scene(customControl));
        stage.show();
    }
}
