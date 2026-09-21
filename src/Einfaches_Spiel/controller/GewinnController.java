package Einfaches_Spiel.controller;

import Einfaches_Spiel.model.GewinnModel;
import Einfaches_Spiel.view.GewinnFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnFrame view;

    public GewinnController(GewinnModel model, GewinnFrame view) {
        this.model = model;
        this.view = view;
    }
}