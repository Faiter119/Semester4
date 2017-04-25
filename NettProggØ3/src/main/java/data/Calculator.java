package data;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class Calculator {

    private String validOperators = "+-";

    public double calculate(String expression){

        if (expression.matches(".*["+validOperators+"].*")){

            Optional<String> stringOptional = getOperator(expression);

            if (stringOptional.isPresent()) {

                String operator = stringOptional.get();
                double[] digits = getDigits(expression);

                System.out.println(Arrays.toString(digits) + " - " + stringOptional);

                // printWriter.println();

                switch (operator) {

                    case "+":
                        return digits[0] + digits[1];
                    case "-":
                        return digits[0] - digits[1];


                }
            }



        }

        return -1;


    }

    private double[] getDigits(String expression) {

        return Stream.of(expression.split("["+validOperators+"]")).mapToDouble(Double::parseDouble).toArray();

    }

    private Optional<String> getOperator(String expression){


        String[] split = expression.split("[^"+validOperators+"]");


        return Stream.of(split).filter(s -> !s.isEmpty()).findFirst(); // unsafe
    }
}
