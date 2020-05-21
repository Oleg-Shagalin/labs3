package oop.model;

import model.AbstractAccount;
import model.Account;
import model.Tariff;

public class IndividualAccount extends AbstractAccount implements Account {
    private Person person;

    public IndividualAccount(long number, Person person) {
        super(number, new IndividualsTariff(1));
        this.person = person;
    }

    public IndividualAccount(long number, Person person, IndividualsTariff tariff) {
        super(number, tariff);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
