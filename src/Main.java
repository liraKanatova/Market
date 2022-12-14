import market.enums.Discount;
import market.enums.Gender;
import market.enums.Market;
import market.enums.Product;
import market.person.MyException;
import market.person.Person;
import market.service.Impl.ServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        List<Product> products = new ArrayList<>();
        products.add(Product.BREAD);
        products.add(Product.FISH);
        products.add(Product.PASTA);

        List<Product> products1 = new ArrayList<>();
        products1.add(Product.APPLES);
        products1.add(Product.MEAT);
        products1.add(Product.POTATO);

        List<Product> products2 = new ArrayList<>();
        products2.add(Product.LEMON);
        products2.add(Product.FISH);
        products2.add(Product.POTATO);


        Person person1 = new Person("Asan", LocalDate.of(1995, 12, 6), Gender.MALE, 900, products, Market.GLOBUS, Discount.SUPERMARKET_DISCOUNT_CARD);
        Person person2 = new Person("Uson", LocalDate.of(1998, 7, 22), Gender.MALE, 1200, products2, Market.FRUNZE,Discount.SUPERMARKET_DISCOUNT_CARD);
        Person person3 = new Person("Asia", LocalDate.of(1999, 10, 19), Gender.FEMALE, 1300, products1, Market.NARODHYI,Discount.SUPERMARKET_DISCOUNT_CARD);
        ArrayList<Person> personArrayList = new ArrayList<>(Arrays.asList(person1, person2, person3));
        ServiceImpl service = new ServiceImpl();
        while (true) {
            System.out.println("""
                    ~~~~~~~~Commands~~~~~~~
                    1.CreatPerson!
                    2.RemovPerson!
                    3.GetAll!
                    4.FindByName!
                    5.SortName!
                    6.FindByMarket!
                    7.SortPersonDateOfBirth!
                    8.SortGender!
                    9.GetAge!
                    10.BuySomeProducts!
                    """);
            Scanner scanner = new Scanner(System.in);
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> System.out.println(service.creatPerson(personArrayList));

                case 2 -> {
                    System.out.print("Write the name: ");
                    System.out.println(service.removPerson(personArrayList, scanner.nextLine()));
                }
                case 3-> System.out.println(service.getAll(personArrayList));
                case 4->{ System.out.print("Write the name: ");
                    System.out.println(service.findByName(personArrayList, scanner.nextLine()));
                }
                case 5 -> System.out.println(service.sortName(personArrayList));
                case 6-> {
                    System.out.print("Write the name Market: ");
                    System.out.println(service.findByMarket(personArrayList, scanner.nextLine()));
                }
                case 7-> System.out.println(service.sortPersonDateOfBirth(personArrayList));
                case 8-> System.out.println(service.sortGender(personArrayList));
                case 9->{System.out.print("Write the name: ");
                    System.out.println(service.getAge(personArrayList, scanner.nextLine()));
                }
                case 10->service.buySomeProducts(personArrayList);
            }
        }
    }
}