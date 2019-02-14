package com.example;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
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
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if (this.name.equals(theObject.getName())) {
                return this.type == theObject.getType();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
       return this.name.hashCode() + 57 + this.type.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.type + ", " + this.orbitalPeriod;
    }
}
