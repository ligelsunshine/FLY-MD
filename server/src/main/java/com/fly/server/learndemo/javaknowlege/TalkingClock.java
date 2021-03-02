package com.fly.server.learndemo.javaknowlege;

import lombok.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * description: TalkingClock
 * date: 2021/3/1 21:02
 * version: 1.0
 *
 * @author: LIGEL
 */
@Data
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){
        this.beep = true;
    }
    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("内部类开始了！");
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
