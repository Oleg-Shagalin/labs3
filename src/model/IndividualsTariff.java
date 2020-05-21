package oop.model;

import model.ServiceTypes;
import model.Tariff;

import java.util.ArrayList;

public class IndividualsTariff implements Tariff {

    private Service[] services;
    private int size;
    private double serviceCharge = 50;

    public IndividualsTariff() {
        size = 8;
        services = new Service[8];
    }

    public IndividualsTariff(int size) {
        this.size = size;
        services = new Service[size];
    }

    public IndividualsTariff(Service[] services) {
        size = services.length;
        this.services = services;
    }

    public boolean add(Service service) {
        for (int i = 0; i < size; i++) {
            if (services[i] == null) {
                services[i] = service;
                return true;
            }
        }

        increaseArray();
        return add(service);
    }

    public void increaseArray() {
        Service[] temp = new Service[size * 2];

        for (int i = 0; i < size; i++){
            temp[i] = services[i];
        }

        services = temp;
        size = services.length;
    }

    public boolean add(int index, Service service) {
        if (index < size && services[index] == null) {
            services[index] = service;
            return true;
        }

        return false;
    }

    public Service get(int index) {
        if (index < size) {
            return services[index];
        }

        return null;
    }

    public Service get(String serviceName) {
        for (Service service : services) {
            if (service != null && service.getName().equals(serviceName))
                return service;
        }

        return null;
    }

    public boolean hasService(String serviceName) {
        for (Service service : services) {
            if (service != null && service.getName().equals(serviceName))
                return true;
        }

        return false;
    }

    public Service set(int index, Service service) {
        if (index < size) {
            services[index] = service;
            return services[index];
        }

        return null;
    }

    public Service remove(int index) {
        if (index < size) {
            Service service = services[index];

            for (int i = index; i < size - 1; i++) {
                services[i] = services[i + 1];
            }

            if (services[size - 1] != null)
                services[size - 1] = null;

            return service;
        }

        return null;
    }

    public Service remove(String serviceName) {
        for (int i = 0; i < size; i++) {
            if (services[i].getName().equals(serviceName)) {

                Service service = services[i];

                for (int j = i; j < size - 1; j++) {
                    services[j] = services[j + 1];
                }

                if (services[size - 1] != null)
                    services[size - 1] = null;

                return service;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public Service[] getServices() {
        int count = 0;

        for (Service service : services) {
            if (service != null)
                count ++;
        }

        Service[] temp = new Service[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (services[i] != null) {
                temp[j] = services[i];
                j++;
            }
        }

        return temp;
    }

    @Override
    public Service[] getServices(ServiceTypes type) {
        ArrayList<Service> list = new ArrayList<>();
        for (Service service : services) {
            if (service != null && service.getType() == type)
               list.add(service);
        }

        return list.toArray(new Service[list.size()]);
    }

    public Service[] sortedServicesByCost() {
        Service[] temp = getServices();

        for (int i = temp.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (temp[j].getCost() > temp[j+1].getCost()) {
                    Service service = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = service;
                }
            }
        }

        return temp;
    }

    public double cost() {
        double cost = 0;
        for (Service service : services) {
            if (service != null)
                cost += service.getCost();
        }

        return cost + serviceCharge;
    }

}
