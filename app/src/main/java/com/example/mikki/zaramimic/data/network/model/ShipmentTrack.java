package com.example.mikki.zaramimic.data.network.model;

public class ShipmentTrack {
    String shipmentid, shipmentstatus;

    public ShipmentTrack(String shipmentid, String shipmentstatus) {
        this.shipmentid = shipmentid;
        this.shipmentstatus = shipmentstatus;
    }

    public String getShipmentid() {
        return shipmentid;
    }

    public String getShipmentstatus() {
        return shipmentstatus;
    }
}
