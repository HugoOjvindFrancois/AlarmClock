/*
 * Copyright (c) 2017 Hugo Ojvind Francois
 */

package com.steakware.alarmclock.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {

    private Viewer viewer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.viewer = new Viewer();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Steakware - Alarm Clock");
        primaryStage.setScene(this.viewer);
        primaryStage.show();
    }
}
