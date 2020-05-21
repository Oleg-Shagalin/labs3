package model;

import oop.model.*;

public class TestLab3 {

    public static void lab3tests() {
        Service[] services = new Service[3];
        services[0] = new Service();
        System.out.println(services[0].getType());

        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service());
        for (Service s : tariff.getServices(ServiceTypes.INTERNET)) {
            System.out.println(s.getName());
        }

        Tariff entityTariff = new EntityTariff();
        entityTariff.add(new Service());
        for (Service s : entityTariff.getServices(ServiceTypes.INTERNET)) {
            System.out.println(s.getName());
        }

        Account account = new IndividualAccount(3, new Person("Ivan", "Ivanov"));
        Account account1 = new IndividualAccount(4, new Person("Petr", "Petrov"),
                new IndividualsTariff());
        System.out.println(account.getNumber());
        System.out.println(account.getTariff().cost());


        Account entityAccount = new EntityAccount(4,"Petr");
        Account entityAccount1 = new EntityAccount(4,"Petr", entityTariff);
        System.out.println(entityAccount.getNumber());
        entityAccount.setTariff(entityTariff);
        System.out.println(entityAccount.getTariff().cost());

        Account[] accounts = new Account[2];
        accounts[0] = account;
        accounts[1] = entityAccount;
        AccountsManager manager = new AccountsManager(accounts);

        accounts = manager.getAccounts(ServiceTypes.INTERNET);
        for (Account a : accounts) {
            if (a != null)
                System.out.println(a.getNumber());
        }

        accounts = manager.getEntityAccount();
        for (Account a : accounts) {
            if (a != null)
                System.out.println(a.getNumber());
        }

        accounts = manager.getIndividualAccount();
        for (Account a : accounts) {
            if (a != null)
                System.out.println(a.getNumber());
        }

    }


    @org.junit.Test
    public void startTests() {
        lab3tests();
    }
}
