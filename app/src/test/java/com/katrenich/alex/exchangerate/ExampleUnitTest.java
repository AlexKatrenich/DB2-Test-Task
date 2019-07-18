package com.katrenich.alex.exchangerate;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.ExchangeRatePOJO;
import com.katrenich.alex.exchangerate.net.NetworkService;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLoad(){
        NetworkService.getInstance()
                .getPbApiService()
                .getPbExchangeRateByDate(" ", "01.07.2019")
                .map(pbExchangeRate -> pbExchangeRate.getExchangeRatePOJO())
                .subscribe(exchangeRatePOJOS -> {
                    for (ExchangeRatePOJO pojo : exchangeRatePOJOS) {
                        System.out.println(pojo.getBaseCurrency() + " " + pojo.getCurrency());
                    }
                });
    }

    @Test
    public void mathRound(){
        int a = (int) Math.round(6.14);
        System.out.println(a);
        int b = (int) Math.round(6.99);
        System.out.println(b);
        int c = (int) Math.round(6.5);
        System.out.println(c);
    }
}