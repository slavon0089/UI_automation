package org.example.lesson4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    Triangle triangle;

    @BeforeEach
    void createTriangle()
    {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("Позитивная проверка рассчета площади")
    void calculateArea() throws Exception {
        logger.trace("проверка рассчета площади");
        assertThat(triangle.area(5,4,4)).isGreaterThan(0.0);
    }

    @Test
    @DisplayName("Проверка площади на 0")
    void exceptionWhenTryToCalculateNegativeArea() throws Exception {
        logger.trace("Проверка площади на 0");
        assertThatExceptionOfType(Exception.class).isThrownBy(()->triangle.checkArea());
    }

    @Test
    @DisplayName("Проверка сторон на 0")
    void exceptionWhenOneSideIsZero () throws Exception {
        logger.trace("Проверка сторон на 0");
        assertThatExceptionOfType(Exception.class).isThrownBy(()->triangle.area(0,1,1));
    }

}
