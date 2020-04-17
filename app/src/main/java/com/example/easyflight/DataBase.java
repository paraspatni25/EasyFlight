package com.example.easyflight;

import java.util.ArrayList;

public class DataBase {

    private static DataBase dataBase;
    public ArrayList<FlightData> flightData;

    private DataBase() {
        flightData = new ArrayList<>();
        createFlightData();
    }

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public ArrayList<FlightData> getFlightData() {
        return flightData;
    }

    private void createFlightData() {

        FlightData data = new FlightData();
        data.setArrivalStation("BOM");
        data.setDepartureStation("YUL");
        data.setArrivalTime("01:00");
        data.setDepartureTime("14:30");
        data.setFlightHaltTime("2hrs 15min");
        data.setFlightCode("AC787");
        data.setFlightPrice("1111");
        data.setFlightStopNumber("1 stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("DEL");
        data.setDepartureStation("JFK");
        data.setArrivalTime("02:00");
        data.setDepartureTime("12:30");
        data.setFlightHaltTime("5hrs");
        data.setFlightCode("UA887");
        data.setFlightPrice("1331");
        data.setFlightStopNumber("2 stop");
        flightData.add(data);


        data = new FlightData();
        data.setArrivalStation("HYB");
        data.setDepartureStation("NYC");
        data.setArrivalTime("02:25");
        data.setDepartureTime("14:30");
        data.setFlightHaltTime("4hrs 15min");
        data.setFlightCode("AF589");
        data.setFlightPrice("1666");
        data.setFlightStopNumber("1 stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("BOM");
        data.setDepartureStation("VNC");
        data.setArrivalTime("15:00");
        data.setDepartureTime("02:30");
        data.setFlightHaltTime("6hrs 30min");
        data.setFlightCode("JT828");
        data.setFlightPrice("960");
        data.setFlightStopNumber("2 stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("DEL");
        data.setDepartureStation("TRT");
        data.setArrivalTime("01:30");
        data.setDepartureTime("13:30");
        data.setFlightCode("ET486");
        data.setFlightPrice("1650");
        data.setFlightStopNumber("Non-stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("CHN");
        data.setDepartureStation("JFK");
        data.setArrivalTime("00:50");
        data.setDepartureTime("16:30");
        data.setFlightHaltTime("8hrs 45min");
        data.setFlightCode("AC987");
        data.setFlightPrice("900");
        data.setFlightStopNumber("1 stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("BOM");
        data.setDepartureStation("YUL");
        data.setArrivalTime("06:00");
        data.setDepartureTime("16:30");
        data.setFlightHaltTime("5hrs 55min");
        data.setFlightCode("BA887");
        data.setFlightPrice("1564");
        data.setFlightStopNumber("1 stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("DEL");
        data.setDepartureStation("YUL");
        data.setArrivalTime("02:45");
        data.setDepartureTime("19:30");
        data.setFlightHaltTime("3hrs 35min");
        data.setFlightCode("UK911");
        data.setFlightPrice("1222");
        data.setFlightStopNumber("3 stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("JFK");
        data.setDepartureStation("YUL");
        data.setArrivalTime("17:00");
        data.setDepartureTime("14:30");
        data.setFlightCode("UA287");
        data.setFlightPrice("265");
        data.setFlightStopNumber("Non-stop");
        flightData.add(data);

        data = new FlightData();
        data.setArrivalStation("BOM");
        data.setDepartureStation("JFK");
        data.setArrivalTime("02:40");
        data.setDepartureTime("16:30");
        data.setFlightHaltTime("4hrs 35min");
        data.setFlightCode("SW753");
        data.setFlightPrice("1265");
        data.setFlightStopNumber("2 stop");
        flightData.add(data);


    }


}
