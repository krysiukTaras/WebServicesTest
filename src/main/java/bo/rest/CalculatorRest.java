package bo.rest;

import bo.Serializer;
import org.apache.commons.io.IOUtils;
import org.testng.SkipException;

import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taras_Krysiuk
 */
public class CalculatorRest {
    
    private String url = "http://localhost:8083/WebServiceServer/restAPI/calc/";

    public double add(double a, double b){
        String s=null;
        Map<String,String> param = new HashMap<String, String>();
        param.put("a", Double.toString(a));
        param.put("b", Double.toString(b));
        try {
            s = sendAndGetResponse(url+"add", param, "GET");
        } catch (Exception ex) {
            Logger.getLogger(CalculatorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Serializer().deserialize(s, Result.class).get(0).getValue();
    }

    public double sub(double a, double b){
        String s=null;
        Map<String,String> param = new HashMap<String, String>();
        param.put("a", Double.toString(a));
        param.put("b", Double.toString(b));
        try {
            s = sendAndGetResponse(url+"sub", param, "GET");
        } catch (Exception ex) {
            Logger.getLogger(CalculatorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Serializer().deserialize(s, Result.class).get(0).getValue();
    }

    public double div(double a, double b){
        String s=null;
        Map<String,String> param = new HashMap<String, String>();
        param.put("a", Double.toString(a));
        param.put("b", Double.toString(b));
        try {
            s = sendAndGetResponse(url+"div", param, "GET");
        } catch (Exception ex) {
            Logger.getLogger(CalculatorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Serializer().deserialize(s, Result.class).get(0).getValue();
    }

    public double mul(double a, double b){
        String s=null;
        Map<String,String> param = new HashMap<String, String>();
        param.put("a", Double.toString(a));
        param.put("b", Double.toString(b));
        try {
            s = sendAndGetResponse(url+"mult", param, "GET");
        } catch (Exception ex) {
            Logger.getLogger(CalculatorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Serializer().deserialize(s, Result.class).get(0).getValue();
    }

    public double cos(double a){
        String s=null;
        Map<String,String> param = new HashMap<String, String>();
        param.put("a", Double.toString(a));
        try {
            s = sendAndGetResponse(url+"cos", param, "GET");
        } catch (Exception ex) {
            Logger.getLogger(CalculatorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Serializer().deserialize(s, Result.class).get(0).getValue();
    }

    public double sin(double a){
        String s=null;
        Map<String,String> param = new HashMap<String, String>();
        param.put("a", Double.toString(a));
        try {
            s = sendAndGetResponse(url+"sin", param, "GET");
        } catch (Exception ex) {
            Logger.getLogger(CalculatorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Serializer().deserialize(s, Result.class).get(0).getValue();
    }
    
    public String sendAndGetResponse(String serviceUrl, Map<String, String> requestProperties, String requestMethod) throws Exception {
        if (requestProperties != null && !requestProperties.isEmpty()) {
            serviceUrl=serviceUrl+"?";
            for (String property : requestProperties.keySet()) {
                serviceUrl=serviceUrl+property;
                serviceUrl=serviceUrl + "=" + requestProperties.get(property);
                serviceUrl=serviceUrl+"&";
            }
        }
        URL url = new URL(serviceUrl);
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);

        connection.connect(); 
        if(connection.getResponseCode()!=200){
            throw  new SkipException("Response code != 200");
        }
        StringWriter writer = new StringWriter();
        IOUtils.copy(connection.getInputStream(), writer, "UTF-8");
        String json = writer.toString();              
        return connection.getResponseCode() == 200 ? json : null;
    }
}
