package model;

import oop.model.Service;

public class EntityAccount extends AbstractAccount implements Account {

    private String name;

    public EntityAccount(long number, String name) {
        super(number, new EntityTariff(new Service[1]));
        this.name = name;
    }

    public EntityAccount(long number, String name, Tariff tariff) {
        super(number, tariff);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
