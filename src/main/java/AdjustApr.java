import java.text.DecimalFormat;
import java.util.Collections;

/**
 * Created by dakshay on 18/10/2021.
 */
class Account implements  Comparable<Account> {

    int a ;
    int b;
    @Override
    public int compareTo(Account o) {
       return this.compareTo(o);
    }
}
public class AdjustApr {
    private static double calculateRate(double nper, double pmt, double pv, double fv, double type, double guess) {
        //FROM MS http://office.microsoft.com/en-us/excel-help/rate-HP005209232.aspx
        int FINANCIAL_MAX_ITERATIONS = 20;//Bet accuracy with 128
        double FINANCIAL_PRECISION = 0.0000001;//1.0e-8

        double y, y0, y1, x0, x1 = 0, f = 0, i = 0;
        double rate = guess;
        if (Math.abs(rate) < FINANCIAL_PRECISION) {
            y = pv * (1 + nper * rate) + pmt * (1 + rate * type) * nper + fv;
        } else {
            f = Math.exp(nper * Math.log(1 + rate));
            y = pv * f + pmt * (1 / rate + type) * (f - 1) + fv;
        }
        y0 = pv + pmt * nper + fv;
        y1 = pv * f + pmt * (1 / rate + type) * (f - 1) + fv;

        // find root by Newton secant method
        i = x0 = 0.0;
        x1 = rate;
        while ((Math.abs(y0 - y1) > FINANCIAL_PRECISION) && (i < FINANCIAL_MAX_ITERATIONS)) {
            rate = (y1 * x0 - y0 * x1) / (y1 - y0);
            x0 = x1;
            x1 = rate;

            if (Math.abs(rate) < FINANCIAL_PRECISION) {
                y = pv * (1 + nper * rate) + pmt * (1 + rate * type) * nper + fv;
            } else {
                f = Math.exp(nper * Math.log(1 + rate));
                y = pv * f + pmt * (1 / rate + type) * (f - 1) + fv;
            }

            y0 = y1;
            y1 = y;
            ++i;
        }
        double result = rate * 1200;
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(result);
        return new Double(formatted);
    }


    /*used in jexl pls dont remove*/
    public static double simpleCalculateRate(double apr, double amtFinanced, int terms, double adjustedAmtFinanced) {

        double fv = 0;

        //0 or omitted - end of payment
        double type = 0;

        // If the expected interest rate is omitted, the value is assumed to be 10%.
        double guess = 0.1;

        double pmtVal = pmt(apr / 1200, terms, amtFinanced, 0, 0) * -1;

        return calculateRate(terms, pmtVal, -1 * adjustedAmtFinanced, fv, type, guess);
    }


    private static double pmt(double r, int nper, double pv, double fv, int type) {
        double pmt = -r * (pv * Math.pow(1 + r, nper) + fv) / ((1 + r * type) * (Math.pow(1 + r, nper) - 1));
        return pmt;
    }

    public static void main(String[] args) {
        System.out.println(simpleCalculateRate(3.39,4174.03,36,4174.03-10));
    }
}
