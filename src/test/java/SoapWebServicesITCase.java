import bo.soap.CalculatorSoap;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by taras on 2/18/2016.
 */
public class SoapWebServicesITCase {

    @Test(enabled = true, timeOut = 300000)
    public void add(){
        Assert.assertTrue(new CalculatorSoap().add(1,2)==3, "Wrong result. ");
    }

    @Test(enabled = true, timeOut = 300000)
    public void sub(){
        Assert.assertTrue(new CalculatorSoap().sub(10, 2)==8, "Wrong result.");
    }

    @Test(enabled = true, timeOut = 300000)
    public void div(){
        Assert.assertTrue(new CalculatorSoap().div(10, 2)==5, "Wrong result.");
    }

    @Test(enabled = true, timeOut = 300000)
    public void mul(){
        Assert.assertTrue(new CalculatorSoap().mul(10,2)==20, "Wrong result.");
    }

}
