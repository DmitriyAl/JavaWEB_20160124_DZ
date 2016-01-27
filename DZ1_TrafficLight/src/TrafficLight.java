import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    private State state;

    private enum State {
        GREEN, YELLOW, RED
    }

    public void showLightAtInputMinute() {
        int minute = userInputInMinute();
        setStateAtMinute(minute);
        calculateCurrentLight();
    }

    private int userInputInMinute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the minute you'd like to see a traffic light colour.\nTo exit enter -1");
        int minute = Integer.MIN_VALUE;
        while (minute == Integer.MIN_VALUE) {
            String answer = null;
            while (answer == null) {
                try {
                    answer = reader.readLine();
                } catch (IOException e) {
                    answer = null;
                    System.out.println("Something wrong, try again");
                }
            }
            try {
                minute = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                System.out.println("You have to enter a number in minute, try again");
                continue;
            }
            if (minute == -1) {
                System.exit(0);
            }
            if (minute < -1) {
                System.out.println("You have to enter nonnegative numbers, or -1 to exit");
                minute = Integer.MIN_VALUE;
            }
        }
        return minute;
    }

    private void setStateAtMinute(int minute) {
        int currentMinute = minute % 6;
        if (currentMinute <= 2) {
            state = State.RED;
        } else if (currentMinute <= 3) {
            state = State.YELLOW;
        } else {
            state = State.GREEN;
        }
    }

    private void calculateCurrentLight() {
        switch (state) {
            case RED:
                System.out.println("Red");
                break;
            case YELLOW:
                System.out.println("Yellow");
                break;
            case GREEN:
                System.out.println("Green");
                break;
            default:
                System.out.println("Something wrong, try again");
                break;
        }
    }
}
