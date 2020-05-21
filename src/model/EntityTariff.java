package model;

import oop.model.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EntityTariff implements Tariff {

    private LinkedList<Service> list;

    public EntityTariff() {
        list = new LinkedList<>();
    }

    public EntityTariff(Service[] services) {
        list = new LinkedList<>(Arrays.asList(services));
    }

    private boolean addService(Service service) {
        list.addLast(service);
        return true;
    }

    private boolean addService(int index, Service service) {
        list.add(index, service);
        return true;
    }

    private Service getService(int index) {
        return list.get(index);
    }

    @Override
    public boolean add(Service service) {
        return addService(service);
    }

    @Override
    public boolean add(int index, Service service) {
        return addService(index, service);
    }

    @Override
    public Service get(int index) {
        return getService(index);
    }

    @Override
    public Service get(String serviceName) {
        for (Service service : list) {
            if (service.getName().equals(serviceName))
                return service;
        }
        return null;
    }

    @Override
    public boolean hasService(String serviceName) {
        for (Service service : list) {
            if (service.getName().equals(serviceName))
                return true;
        }
        return false;
    }

    @Override
    public Service set(int index, Service service) {
        return setService(index, service);
    }

    @Override
    public Service remove(int index) {
        return removeService(index);
    }

    private Service setService(int index, Service service) {
        return list.set(index, service);
    }

    private Service removeService(int index) {
        return list.remove(index);
    }

    @Override
    public Service remove(String name) {
        for (Service service : list) {
            if (service.getName().equals(name)) {
                list.remove(service);
                return service;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Service[] getServices() {
        Service[] services = new Service[list.size()];
        return list.toArray(services);
    }

    @Override
    public Service[] getServices(ServiceTypes type) {
        for (Service service : list) {
            if (service.getType() != type)
                list.remove(service);
        }

        return list.toArray(new Service[list.size()]);
    }

    @Override
    public Service[] sortedServicesByCost() {
        Service[] services = new Service[list.size()];
        list.sort(new Comparator<Service>() {
            @Override
            public int compare(Service o1, Service o2) {
                return Double.compare(o1.getCost(), o2.getCost());
            }
        });
        return list.toArray(services);
    }

    @Override
    public double cost() {
        double cost = 0;
        for (Service service : list) {
            cost += service.getCost();
        }
        return cost;
    }
}
