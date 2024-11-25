package entities;

public class ChronosEntity {

    private long startTime;

    private long elapsedTime;

    private boolean pausedChronos;

    private boolean runningChronos;

    private boolean stopChronos;

    public ChronosEntity () {

        this.startTime = 0;

        this.elapsedTime = 0;

        this.pausedChronos = false;

        this.runningChronos = false;

        this.stopChronos = false;

    }

    // Start, Pause, Reset, Run;

    public void startChronos () {

        if (!runningChronos) {

            this.startTime = System.currentTimeMillis() - elapsedTime;

            this.pausedChronos = false;

            this.runningChronos = true;

            this.stopChronos = false;

            runChronometer();

        }

    }

    public void pauseChronos () {

        if (runningChronos && !pausedChronos) {

            elapsedTime = System.currentTimeMillis() - startTime;

            runningChronos = false;

            pausedChronos = true;

            stopChronos = true;

        }

    }

    public void resetChronos () {

        elapsedTime = 0;

        startTime = 0;

        runningChronos = false;

        pausedChronos = false;

        stopChronos = true;

        System.out.println("00-00-00");

    }

    private void runChronometer () {

        new Thread(() -> {

            while (!stopChronos) {

                if (runningChronos) {

                    long currentTime = System.currentTimeMillis();

                    long timeTraveled = currentTime - startTime;

                    chronosEngine(timeTraveled);

                    try {

                        Thread.sleep(1000);

                    } catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                        System.out.println(e.getMessage());

                    }

                }

            }

        }).start();

    }

    private void chronosEngine (long timeTraveled) {

        long secondsTraveled = (timeTraveled / 1000) % 60;

        long minutesTraveled = (timeTraveled / (1000 * 60)) % 60;

        long hoursTraveled = (timeTraveled / (1000 * 60 * 60)) % 24;

        String timeFormatted = String.format("%02d:%02d:%02d", hoursTraveled, minutesTraveled, secondsTraveled);

        System.out.println("\r" + timeFormatted);

    }

}
