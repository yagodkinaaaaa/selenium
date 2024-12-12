package com.selenium; 
 
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
 
public class LiqPayTest { 
 
    @Test 
    public void testLiqPayInteraction() { 
        // Установити шлях до ChromeDriver 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\chromedriver-win64\\chromedriver.exe"); 
 
        // Ініціалізація WebDriver 
        WebDriver driver = new ChromeDriver(); 
 
        try { 
            // Крок 2: Відкриваємо зазначену URL 
            driver.get("https://cdn.liqpay.ua/full-screen.html?data-company-id=i14778026796"); 
            System.out.println("Сторінка відкрита."); 
 
            // Крок 3: Почекати 5 секунд після завантаження сторінки 
            Thread.sleep(5000); // Затримка в 5 секунд 
 
            // Ініціалізуємо WebDriverWait 
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
 
            // Крок 4: Перемикаємось в iframe (якщо є) 
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe"))); 
            driver.switchTo().frame(iframeElement); 
            System.out.println("Перемикнуто на iframe."); 
 
            // Крок 5: Знайти поле вводу тексту в iframe та ввести "Курс валют" 
            WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("textarea"))); 
            textField.clear(); // Очищаємо поле перед введенням нового тексту 
            textField.sendKeys("Курс валют"); 
            // Відправка тексту за допомогою натискання Enter 
            textField.sendKeys(Keys.RETURN); // натискає Enter 
            System.out.println("Текст відправлено за допомогою натискання Enter."); 
                        
            System.out.println("Введено текст: 'Курс валют'."); 
 
            // Крок 6: Почекати 3 секунди після вводу першого тексту 
            Thread.sleep(3000); // Затримка в 3 секунди 
 
            // Крок 7: Ввести додатковий текст "нет" 
            textField.sendKeys(" нет"); 
            System.out.println("Введено текст: 'нет'."); 
            // Відправка тексту за допомогою натискання Enter 
            textField.sendKeys(Keys.RETURN); // натискає Enter 
            System.out.println("Текст відправлено за допомогою натискання Enter."); 
 
            // Крок 8: Не закривати браузер 
            System.out.println("Тест завершено, браузер залишено відкритим."); 
 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            // Закрити WebDriver 
            // Не закриваємо браузер на кінець тесту (для збереження сесії відкритим) 
            // driver.quit(); // Не викликаємо, щоб браузер залишався відкритим 
            System.out.println("Браузер залишено відкритим."); 
        } 
    } 
}