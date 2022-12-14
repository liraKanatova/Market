package market.service.Impl;

import market.enums.Product;
import market.person.Person;

import java.math.BigDecimal;
import java.util.List;

public interface Serviceable {

String creatPerson(List<Person>people);
String removPerson(List<Person>people,String name);
List<Person> getAll(List<Person>people);
Person findByName(List<Person>people,String name);
List<Person> sortName(List<Person>people);
Person findByMarket(List<Person>people,String name);
    List<Person>sortPersonDateOfBirth(List<Person>people);
List<Person> sortGender(List<Person>people);
    int getAge(List<Person>people,String name);


void buySomeProducts( List<Person>people);




}
