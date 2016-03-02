package bo.soap;

import com.epam.webserviceserver.soap.Calculator_Service;

/**
 * Created by Taras on 05.02.2016.
 */
public class CalculatorSoap {

    public double add(double a, double b){
        return new Calculator_Service().getCalculatorPort().addition(a,b);
    }

    public double sub(double a, double b){
        return new Calculator_Service().getCalculatorPort().subtraction(a,b);
    }

    public double sin(double a){
        return new Calculator_Service().getCalculatorPort().sin(a);
    }

    public double cos(double a){
        return new Calculator_Service().getCalculatorPort().cos(a);
    }

    public double div(double a, double b){
        return new Calculator_Service().getCalculatorPort().division(a,b);
    }

    public double mul(double a, double b){
        return new Calculator_Service().getCalculatorPort().multiply(a,b);
    }

}
