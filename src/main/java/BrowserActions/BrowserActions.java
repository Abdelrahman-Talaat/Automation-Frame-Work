package BrowserActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserActions {
    public static ThreadLocal<WebDriver> bActions=new ThreadLocal<>();

    public BrowserActions(WebDriver driver){
        bActions.set(driver);
    }

    public void getToUrl(String url){
        bActions.get().get(url);
    }


    public String getWindowHandle(){
    return     bActions.get().getWindowHandle();
    }

    public Set<String> getWindowHandles(){
        return  bActions.get().getWindowHandles();
    }

    public String getPageTitle(){
        return  bActions.get().getTitle();
    }

  public String getCurrentUrl(){
        return bActions.get().getCurrentUrl();
  }

    public void navigateToUrl(String url){
        bActions.get().navigate().to(url);
    }

    public void navigateForward(){
        bActions.get().navigate().forward();
    }

    public void navigateBack(){
        bActions.get().navigate().back();
    }

    public void refresh(){
        bActions.get().navigate().refresh();
    }

    public void maximizePage(){
        bActions.get().manage().window().maximize();
    }

    public void minimizePage(){
        bActions.get().manage().window().minimize();
    }

    public void pageFullScreen(){
        bActions.get().manage().window().fullscreen();
    }

    public Dimension getPageSize(){
        return bActions.get().manage().window().getSize();
    }

     public void closeWindows(){
        bActions.get().quit();
  }

      public void removeDriver(){
        bActions.remove();
  }

  public void deleteCookies(){
        bActions.get().manage().deleteAllCookies();
  }

  public void deleteCookie(Cookie cookie){
        bActions.get().manage().deleteCookie(cookie);
  }

}
