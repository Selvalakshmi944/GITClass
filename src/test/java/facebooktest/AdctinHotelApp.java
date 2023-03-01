package facebooktest;

public class AdctinHotelApp {
	public static void main(String args[]) throws InterruptedException {
		BaseClass b = new BaseClass();
		b.loadURL("http://www.adactin.com/HotelApp/");
		b.sendKeys("username", "selvaselenium20231");
		b.sendKeys("password", "Test@123");
		// b.clickIdElement("login");
		b.clickElement("login", "id");

		b.select("location", "New York");
		b.select("hotels", "Hotel Sunshine");
		b.select("room_type", "Deluxe");
		b.select("room_nos", "1 - One");
		b.sendKeys("datepick_in", "16/02/2023");
		b.sendKeys("datepick_out", "19/02/2023");
		b.select("adult_room", "2 - Two");
		b.select("child_room", "2 - Two");
		b.clickIdElement("Submit");
		b.clickIdElement("radiobutton_0");
		b.clickElement("continue");
		b.sendKeys("first_name", "selvalakshmi");
		b.sendKeys("last_name", "rajagopal");
		b.sendKeys("address", "Radiance mercury");
		b.sendKeys("cc_num", "123123123123123123");
		b.select("cc_type", "Master Card");
		b.select("cc_exp_month", "February");
		b.select("cc_exp_year", "2016");
		b.sendKeys("cc_cvv", "123");
		b.clickElement("book_now");
		b.implicitWait(10);
		String orderNo = b.getAttribute("order_no", "value");
		System.out.println(orderNo);

		/*
		 * WebElement userName=driver.findElement(By.xpath(
		 * "//*[@id=\"login_form\"]/table/tbody/tr[7]/td/a"));
		 * userName.sendKeys("selvaselenium20231",//*[@id=\"login_form\"]/table/tbody/tr
		 * [7]/td/a)); WebElement password=driver.findElement(By.id("password"));
		 * password.sendKeys("Test@123"); WebElement
		 * reg=driver.findElement(By.xpath("//a[text()='New User Register Here']"));
		 * reg.click(); WebElement
		 * username2=driver.findElement(By.xpath("//input[@name='username']"));
		 * username2.sendKeys("selvaselenium20231");
		 */

	}

}
