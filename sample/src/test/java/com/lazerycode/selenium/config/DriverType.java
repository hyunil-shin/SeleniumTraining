package com.lazerycode.selenium.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.lazerycode.selenium.TestProperties;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public enum DriverType implements DriverSetup {

    FIREFOX {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
        	File fpath = new File(TestProperties.firefox_binary_path);
        	FirefoxBinary b = new FirefoxBinary(fpath);
            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            options.setHeadless(TestProperties.headless);
            options.setBinary(b);

            return new FirefoxDriver(options);
        }
    },
    CHROME {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//" + TestProperties.chrome_driver_path);
            System.out.println(System.getProperty("user.dir") + "\\" + TestProperties.chrome_driver_path);

            // 크롬 브라우져 속성
            // - http://chromedriver.chromium.org/capabilities
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", false);
            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);
            options.setHeadless(TestProperties.headless);
            options.addArguments("--no-default-browser-check");
            // https://github.com/Codeception/CodeceptJS/issues/561
            // chrome headless 속드 개선
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            options.setExperimentalOption("prefs", chromePreferences);

            return new ChromeDriver(options);
        }
    },
    IE {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.merge(capabilities);
            options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

            return new InternetExplorerDriver(options);
        }

        @Override
        public String toString() {
            return "internet explorer";
        }
    },
    EDGE {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            EdgeOptions options = new EdgeOptions();
            options.merge(capabilities);

            return new EdgeDriver(options);
        }
    },
    SAFARI {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            SafariOptions options = new SafariOptions();
            options.merge(capabilities);

            return new SafariDriver(options);
        }
    },
    OPERA {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            OperaOptions options = new OperaOptions();
            options.merge(capabilities);

            return new OperaDriver(options);
        }
    };


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}