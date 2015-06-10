package org.sayem.webdriver.basics.webdriver.basic.part3;

//import org.apache.http.client.fluent.Request;

//public class SpecificLinkSecondway {
//    static WebDriver driver;
//    public static void main(String[] args) {
//
//        driver = new FirefoxDriver();
//        driver.get("http://bbc.com");
//
//        String part1="//*[@id='news_moreTopStories']/ul/li[";
//        String part2="]/a";
//
//        //for(int i=1;i<=5;i++){
//
//        int i=1;
//        while(isElementPresent(part1+i+part2)){
//            String text = driver.findElement(By.xpath(part1+i+part2)).getText();
//            System.out.println(text);
//            // check the response code of the URL
//            String url = driver.findElement(By.xpath(part1+i+part2)).getAttribute("href");
//            if(checkResponse(url)){
//                driver.findElement(By.xpath(part1+i+part2)).click();
//                // check the response code of the current URL
//                //checkResponse(driver.getCurrentUrl());
//
//                System.out.println(driver.getTitle());
//                driver.get("http://bbc.com");
//            }else{
//                System.out.println("Something wrong with URL response code");
//            }
//            i++;
//            System.out.println("********************");
//        }
//
//
//    }
//
//    // true- present
//    // false - not present
//    public static boolean isElementPresent(String element_xpath){
//        int count = driver.findElements(By.xpath(element_xpath)).size();
//
//        if(count == 0)
//            return false;
//        else
//            return true;
//    }
//
//    // Http resonp code - 200 OK
//    public static boolean checkResponse(String url){
//        try {
//            int resp_code= Request.Get(url).execute().returnResponse().getStatusLine()
//                    .getStatusCode();
//            System.out.println("Respose code for URL "+ url +" is -> "+ resp_code);
//            if(resp_code == 200)
//                return true;
//            else
//                return false;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}