package data;

import com.microsoft.playwright.*;

 

public class MainPage {

    public Page mainPage;

    public Locator chocChoice;
    public Locator selectChoc;
    public Locator dropdown;
    public Locator shop;
    public Locator selectShop;
    public Locator gift;
    public Locator addtoCart;
    public Locator additem;
    public Locator continueShopping;
    public Locator removeItem;
    public Locator checkout;
    public Locator checkoutPage;
    public Locator item1;
    public Locator item2;
    public Locator item3;
    public Locator total;
    public Locator finalTotal;

    public MainPage(Page page) {

        this.chocChoice = page.locator("//*[@id='content']/article/div/div/div/div/div[1]/div/div/div/div/div[1]/article");
        this.selectChoc = page.locator("//*[@id='uc-product-add-to-cart-form-15995']"); 
        this.shop = page.locator("//*[@id='main-menu']/li[1]/a");
        //this.shop = page.locator("//*[@id='submenu--0']/li[6]");
        this.selectShop = page.locator("//*[@id='content']/article/div/div/div/div/div/div/div/div/div/div[1]/article/div[2]/header/a");
        this.gift = page.locator("//*[@id='content']/article/div/div/div/div/div[2]/div/div/div/div/div[1]/article/div[2]/header/a");
        this.addtoCart = page.locator("//*[@id='edit-submit-16116']");
        this.continueShopping = page.locator("//*[@id='edit-actions']/a");
        this.additem = page.locator("//*[@id='edit-submit-16117']");
        this.removeItem = page.locator("//*[@id='edit-items-2-remove']");
        this.checkout = page.locator("//*[@id='edit-checkout--2']");
        this.checkoutPage = page.locator("//*[@id='page-title']");
        this.item1 = page.locator("//*[@id='uc-cart-view-form']/div/table[2]/tbody/tr[1]/td[3]");
        this.item2 = page.locator("//*[@id='uc-cart-view-form']/div/table[2]/tbody/tr[2]/td[3]");
        this.item3 = page.locator("//*[@id='uc-cart-view-form']/div/table[2]/tbody/tr[3]/td[3]");
        this.total = page.locator("//*[@id='uc-cart-view-form']/div/table[2]/tbody/tr[4]/td/span[2]");
        this.finalTotal = page.locator("//*[@id='uc-cart-view-form']/div/table[2]/tbody/tr[3]/td/span[2]");
        
    }
}