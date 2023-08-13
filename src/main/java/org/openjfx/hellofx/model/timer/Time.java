package org.openjfx.hellofx.model.timer;

public class Time {
    private int hour;
    private int minute;
    private int second;

    // public Time(int hour, int minute, int second) {
    // this.hour = hour;
    // this.minute = minute;
    // this.second = second;
    // }

    public Time(String currentTime) {
        String[] time = currentTime.split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        second = Integer.parseInt(time[2]);

    }

    public String getCurrentTime() {
        String a = (hour < 10) ? "0" : "";
        String b = (minute < 10) ? "0" : "";
        String c = (second < 10) ? "0" : "";
        return a + hour + ":" + b + minute + ":" + c + second;
    }

    public int getTotalMinute() {
        return hour * 60 + minute;
    }

    public void oneSecondPassed() {
        second++;
        if (second == 60) {
            minute++;
            second = 0;
            if (minute == 60) {
                hour++;
                minute = 0;
            }
        }
    }

}
