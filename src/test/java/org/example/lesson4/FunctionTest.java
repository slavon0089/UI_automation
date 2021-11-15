package org.example.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class FunctionTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionTest.class);

    @BeforeAll
    static void beforeMethod(){
        System.out.println("Метод выполниться 1 раз перед тестами");
    }

    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Метод выполниться перед каждым тестом");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,7,11})
    @DisplayName("Позитивная проверка простого числа")
    void givenPrimeNumberCheckIsPrimeThenTrue(int number) {
        logger.trace("trace log");
        logger.info("info log");
        logger.debug("debug log");

        boolean result = Functions.isNumberPrime(number);
        Assertions.assertTrue(result);
    }


    @ParameterizedTest
    @CsvSource({"1,true", "6,false", "12,false"})
    @DisplayName("Позитивная проверка непростого числа")
    void givenNotPrimeNumberCheckIsNotPrimeThenFalse(int number, boolean result) {
        Assertions.assertEquals(Functions.isNumberPrime(number), result);
    }

    @ParameterizedTest
    @MethodSource ("catsDataProvider")
    void testCat(Cat cat, boolean result) {
        System.out.println(cat);
        System.out.println(result);
    }

    private static Stream<Arguments> catsDataProvider() {
        return Stream.of(
                Arguments.arguments(new Cat("Black",10), true),
                Arguments.arguments(new Cat("White",15 ),false));

    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("метод выполнится после всех етстов");
    }

}
