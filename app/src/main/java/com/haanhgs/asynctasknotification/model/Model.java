package com.haanhgs.asynctasknotification.model;

public class Model {

    private boolean runningThread1 = false;
    private boolean runningThread2 = false;
    private boolean runningThread3 = false;

    private Integer prime1;
    private Integer prime2;
    private Integer prime3;

    private String message1;
    private String message2;
    private String message3;

    public boolean isRunningThread1() {
        return runningThread1;
    }

    public void setRunningThread1(boolean runningThread1) {
        this.runningThread1 = runningThread1;
    }

    public boolean isRunningThread2() {
        return runningThread2;
    }

    public void setRunningThread2(boolean runningThread2) {
        this.runningThread2 = runningThread2;
    }

    public boolean isRunningThread3() {
        return runningThread3;
    }

    public void setRunningThread3(boolean runningThread3) {
        this.runningThread3 = runningThread3;
    }

    public Integer getPrime1() {
        return prime1;
    }

    public void setPrime1(Integer prime1) {
        this.prime1 = prime1;
    }

    public Integer getPrime2() {
        return prime2;
    }

    public void setPrime2(Integer prime2) {
        this.prime2 = prime2;
    }

    public Integer getPrime3() {
        return prime3;
    }

    public void setPrime3(Integer prime3) {
        this.prime3 = prime3;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }
}
