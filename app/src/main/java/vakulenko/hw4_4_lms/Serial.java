package vakulenko.hw4_4_lms;

import java.io.Serializable;

public class Serial implements Serializable {
    private String userId;
    private String departurePlace;
    private String departureTime;
    private String arrivalTime;
    private int seatNumber;
    private double price;

    public Serial(String userId, String departurePlace, String departureTime, String arrivalTime, int seatNumber, double price) {
        this.userId = userId;
        this.departurePlace = departurePlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }
}
