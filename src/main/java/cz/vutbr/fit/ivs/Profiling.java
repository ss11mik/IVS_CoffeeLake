package cz.vutbr.fit.ivs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Independent class (not used in production) for profiling {@link MathLib} by computing variation
 * Expects text file with one number in line as 1st arg
 *
 * @author Ondřej Mikula, René Szotkowski
 */
public class Profiling {

    public static void main(String[] args) {

        List<Double> numbers = new ArrayList<Double>();

        try {
            System.setIn(new FileInputStream(args[0]));

            // obtaining data

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;

            while ((str=br.readLine()) != null && str.length()!=0) {
                numbers.add(Double.parseDouble(str));
            }

            // the calculation

            double avg = average(numbers);
            avg = MathLib.pow(avg, 2);
            avg = MathLib.multiply(avg, numbers.size());    // N * avg^2


            double part = 0;

            for (double num : numbers) {
                part = MathLib.add(part, MathLib.pow(num, 2));        // E x^2
            }

            part = MathLib.sub(part, avg);      // (E x^2 - N * avg^2)


            double result =
                    MathLib.sqrt(
                            MathLib.multiply(
                                    MathLib.divide(
                                            1,
                                            MathLib.sub(numbers.size(), 1)),
                                    part),
                            2);

            System.out.println(result);

        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }

    private static double average (List<Double> numbers) {
        double avg = 0;
        for (double num : numbers) {
            avg += num;
        }
        avg /= numbers.size();
        return avg;
    }
}
