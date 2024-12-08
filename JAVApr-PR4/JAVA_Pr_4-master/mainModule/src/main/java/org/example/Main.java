package org.example;

import com.github.javafaker.Faker;

import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var faker = new Faker();

        OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(new Electronics("Mobile phone", 210, "Phone"));
        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(new Clothing("Trousers", 343, "Jeans"));
        electronicsOrder.process();
        clothingOrder.process();

        electronicsOrder.startProcessing();
        clothingOrder.startProcessing();

     /*   var clothing = Clothing.builder()
                .name(faker.commerce().productName())
                .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                .description(faker.lebowski().quote())
                .build();
        System.out.println(clothing.getName());
        System.out.println(clothing.getPrice());
        System.out.println(clothing.getDescription());
    }*/

        var clothingList = IntStream.range(0, 10).mapToObj(i -> Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                        .description(faker.lebowski().quote())
                        .build())
                .toList();
        clothingList.forEach(clothing -> {
            System.out.println("Name: " + clothing.getName());
            System.out.println("Price: " + clothing.getPrice());
            System.out.println("Description: " + clothing.getDescription());
            System.out.println("-------------------------------");

            clothingList.parallelStream()
                    .map(OrderProcessor::new)
                    .forEach(OrderProcessor::startProcessing);
        });

    }
}