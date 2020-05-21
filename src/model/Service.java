package oop.model;

import model.ServiceTypes;

public final class Service {

    private final String name;
    private final double cost;
    private ServiceTypes type;

    public Service() {
        name = "интернет 100мб\\сек";
        cost = 300;
        type = ServiceTypes.INTERNET;
    }

    public Service(String name, int cost, ServiceTypes type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public ServiceTypes getType() {
        return type;
    }
}
