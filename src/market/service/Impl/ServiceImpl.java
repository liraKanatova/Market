package market.service.Impl;

import market.enums.Gender;
import market.enums.Product;
import market.person.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class ServiceImpl implements Serviceable {

    List<Person> people = new ArrayList<>();


    @Override
    public String creatPerson(List<Person> people) {
        this.people.addAll(people);
        return "Person CREATED successfully!";
    }

    @Override
    public String removPerson(List<Person> people, String name) {
        boolean isRemoved = this.people.removeIf(person -> person.getName().equals(name));
        return isRemoved ? "Person(" + name + ") is Removed successfully!" : "Removed failed : Invaled name!";
    }

    @Override
    public List<Person> getAll(List<Person> people) {
        return this.people;
    }

    @Override
    public Person findByName(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }

        }
        return null;
    }

    public static Comparator<Person> sortName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    @Override
    public List<Person> sortName(List<Person> people) {
        people.sort(sortName);
        return people;
    }

    @Override
    public Person findByMarket(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getMarket().name().equals(name)) {
                return person;
            }

        }
        return null;
    }

    public static Comparator<Person> sortPersonDateOfBirth = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };

    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> people) {
        people.sort(sortPersonDateOfBirth);
        return people;
    }

    @Override
    public List<Person> sortGender(List<Person> people) {
        List<Person> males = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.MALE)) {
                males.add(person);
            }

        }


        return males;
    }

    @Override
    public int getAge(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            }

        }
        return 0;
    }

    @Override
    public void buySomeProducts(List<Person> people) {
        int sum = 0;
        System.out.print("Kim satyp alat attyn jaz: ");
        String name = new Scanner(System.in).next();
        for (Person person : people) {
            if (person.getName().equals(name)) {
                for (Product product : person.getProducts()) {
                    sum += product.getPrice();
                    System.out.println("Your bought products are: " + product);
                }
            }
            person.setMoney(person.getMoney() - sum);
            System.out.println("Your current money is: " + person.getMoney());
            System.out.printf("""
                    ~~~~~~~~~~~check~~~~~~~~~~
                    name of person : %s
                    name of market : %s
                    name of product : %s
                    total coast of goods: %d
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    """, person.getName(), person.getMarket(), person.getProducts(), sum);

        }
    }
}










