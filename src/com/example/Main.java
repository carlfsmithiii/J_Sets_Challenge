package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
//    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<HeavenlyBody> moonsAndPlanets = new HashSet<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);
        moonsAndPlanets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getStringIdentifier(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getStringIdentifier(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(Planet planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.getStringIdentifier(HeavenlyBody.BodyType.PLANET, "Mars"));
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        Planet pluto = new Planet("Pluto", 842);
        planets.add(pluto);
        solarSystem.put(pluto.getStringIdentifier(), pluto);

        Moon venusTheMoon = new Moon("Venus", 222);
        moonsAndPlanets.add(venusTheMoon);
        solarSystem.put(venusTheMoon.getStringIdentifier(), venusTheMoon);


        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName() +   " : " + planet.getOrbitalPeriod());
        }

        System.out.println();
        System.out.println("Pluto in solar system");
        for (String identifier : solarSystem.keySet()) {
            if (identifier.equals(HeavenlyBody.getStringIdentifier(HeavenlyBody.BodyType.PLANET, "Pluto"))) {
                System.out.println(solarSystem.get(identifier).getName() + " : " + solarSystem.get(identifier).getOrbitalPeriod());
            }
        }

        System.out.println("Venuses in solar system");
        for (HeavenlyBody someKindOfVenus : solarSystem.values()) {
            if ("Venus".equals(someKindOfVenus.getName())) {
                System.out.println(someKindOfVenus.getName() + " : " + someKindOfVenus.getOrbitalPeriod());
            }
        }

        System.out.println("moonsAndPlanets");
        for (HeavenlyBody heavenlyBody : moonsAndPlanets) {
            System.out.println(heavenlyBody.getName() + " : " + heavenlyBody.getOrbitalPeriod());
        }
    }
}
