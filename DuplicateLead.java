public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SAI");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("RAm");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Hi Guys");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saikumarram@tcs.com");
		WebElement selState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select selSta=new Select(selState);
        selSta.selectByVisibleText("New York");
        driver.findElement(By.className("smallSubmit")).click();
        
        String title = driver.getTitle();
        System.out.println(title);
        
        driver.findElement(By.linkText("Duplicate Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).clear();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");
        driver.findElement(By.id("createLeadForm_firstName")).clear();
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SaiRam");
        driver.findElement(By.className("smallSubmit")).click();
        
        String title2 = driver.getTitle();
        System.out.println(title2);
	}

}
