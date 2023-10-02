package br.com.dnavarro.lambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class TesteLambdas {

    public static void main(String[] args) {
        // Exemplo com IntBinaryOperator
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
        int resultado1 = intBinaryOperator.applyAsInt(1, 1);
        System.out.println("Resultado do IntBinaryOperator: " + resultado1);

        // Exemplo com BiFunction para somar inteiros
        BiFunction<Integer, Integer, Integer> biFunctionSoma = (a, b) -> a + b;
        Integer resultadoBiSoma = biFunctionSoma.apply(10, 10);
        System.out.println("Resultado do BiFunction (soma): " + resultadoBiSoma);

        // Exemplo com BiFunction para converter e somar doubles
        BiFunction<Double, Double, String> biFunctionStr = (a, b) -> {
            Double resultado = a + b;
            return String.valueOf(resultado);
        };
        String resultadoBiFunction = biFunctionStr.apply(10.0, 10.0);
        System.out.println("Resultado do BiFunction (conversão para String): " + resultadoBiFunction);

        // Exemplo com o método personalizado "calcular"
        Long resultadoLong = calcular(1L, 2L, (v1, v2) -> v1 + v2);
        System.out.println("Resultado do calcular: " + resultadoLong);

        // Exemplo com Runnable e Consumer
        Runnable helloWorld = () -> System.out.println("Olá, Mundo");
        helloWorld.run();

        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Valor");

        // Exemplo com Supplier
        Supplier<Integer> integerSupplier = () -> 42;
        System.out.println("Valor obtido do Supplier (inteiro): " + integerSupplier.get());

        Supplier<Double> doubleSupplier = () -> 3.1415;
        System.out.println("Valor obtido do Supplier (double): " + doubleSupplier.get());
    }

    private static Long calcular(Long t, Long u, BiFunction<Long, Long, Long> function) {
        return function.apply(t, u);
    }
}
