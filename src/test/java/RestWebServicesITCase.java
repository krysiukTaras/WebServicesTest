import bo.rest.CalculatorRest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Taras_Krysiuk on 12/30/2015.
 */

public class RestWebServicesITCase {

    @Test(enabled = true, timeOut = 300000)
    public void add(){
        Assert.assertTrue(new CalculatorRest().add(1,2)==3, "Wrong result. ");
    }

    @Test(enabled = true, timeOut = 300000)
    public void sub(){
        Assert.assertTrue(new CalculatorRest().sub(10, 2)==8, "Wrong result.");
    }

    @Test(enabled = true, timeOut = 300000)
    public void div(){
        Assert.assertTrue(new CalculatorRest().div(10, 2)==5, "Wrong result.");
    }

    @Test(enabled = true, timeOut = 300000)
    public void mul(){
        Assert.assertTrue(new CalculatorRest().mul(10,2)==20, "Wrong result.");
    }
}
