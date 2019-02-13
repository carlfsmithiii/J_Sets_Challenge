package com.example;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (!satellite.getType().equals(BodyType.MOON)) {
            System.out.println(satellite.getName() + " is not a moon");
            return false;
        }
        return super.addSatellite(satellite);
    }
}
