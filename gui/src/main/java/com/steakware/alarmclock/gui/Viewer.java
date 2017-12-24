/*
 * Copyright (c) 2017 Hugo Ojvind Francois
 */

package com.steakware.alarmclock.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Viewer extends Scene {

    private Controller controller;

    public Viewer(Controller controller) {
        super(controller, 500, 500);
        this.controller = controller;
        this.controller.setText("Hello");
    }
}
