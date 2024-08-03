package action;

import java.nio.file.Paths;

import java.util.Random;

import com.microsoft.playwright.*;
import static org.junit.Assert.assertTrue;
 

import data.MainPage;
public class test {

Page page;

    MainPage mainPage;

        public test(Page page) {

        this.page = page;

        this.mainPage = new MainPage(page);

    }

    public void testScreen(){
        

        this.mainPage.chocChoice.click();
        this.mainPage.selectChoc.click();
        page.waitForTimeout(1000);
        this.mainPage.shop.click();
        this.mainPage.selectShop.click();
        this.mainPage.gift.click();
        this.mainPage.addtoCart.click();
        this.mainPage.continueShopping.click();
        this.mainPage.additem.click();
        page.waitForTimeout(1000);
        String item1 = this.mainPage.item1.innerText();
        float  floatItem1 = Float.parseFloat(item1.replaceAll("\\$",""));
        String item2 = this.mainPage.item2.innerText();
        float floatItem2 = Float.parseFloat(item2.replaceAll("\\$",""));
        String item3 = this.mainPage.item3.innerText();
        float floatItem3 = Float.parseFloat(item3.replaceAll("\\$",""));
        String total = this.mainPage.total.innerText();
        float floatTotal = Float.parseFloat(total.replaceAll("\\$",""));
       // assert item cost equals item total
        assert (floatItem1 + floatItem2 + floatItem3) == floatTotal;
        //remove one item
        this.mainPage.removeItem.click();
        this.mainPage.checkout.click();
        //assert user has reached checkout page
        String getText = this.mainPage.checkoutPage.innerText();
        assert getText.contains("Checkout");



        
       
      




    }
}
