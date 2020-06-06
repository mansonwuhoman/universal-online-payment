package io.mwlab.provider.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.OrderCaptureRequest;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import io.mwlab.provider.api.exception.UOPException;

import java.io.IOException;

import static io.mwlab.provider.api.exception.UOPExceptionType.PROVIDER_PAYPAL;

public class Payment {

    private PayPalHttpClient payPalHttpClient;

    public Payment(PayPalHttpClient payPalHttpClient){
        this.payPalHttpClient = payPalHttpClient;
    }


    public void checkout(ApplicationContext paypalApplicationContext){

        var ordersCreateRequest = new OrdersCreateRequest();
        var orderRequest = new OrderRequest();
        orderRequest.applicationContext(paypalApplicationContext);
        ordersCreateRequest.requestBody(orderRequest);
        try {
            payPalHttpClient.execute(ordersCreateRequest);
        }
        catch (IOException e){
            throw new UOPException(PROVIDER_PAYPAL, e);
        }

    }
}
