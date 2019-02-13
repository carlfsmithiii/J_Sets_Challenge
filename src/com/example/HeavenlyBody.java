package com.example;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType type;

    public enum BodyType {
            STAR, PLANET, MOON, ASTEROID, ALIEN_MOTHERSHIP
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType type) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.type = type;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public static String getStringIdentifier(BodyType type, String name) {
        return type + "_" + name;
    }

    public String getStringIdentifier() {
        return getStringIdentifier(this.type, this.name);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public BodyType getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
       return this.name.hashCode() + 57 + this.type.ordinal();
    }
}
