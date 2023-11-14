package week2;
import java.util.*;
/**
 * @author dmaccoille820
 *
 */
public class WeatherForecast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//double averageTemp = 11.0;
// header for the report
System.out.println("Weather Analysis");
//String to hold the lines
String lines = "___________________________________________";
System.out.println(lines);

//Instantiate the daily values
DailyForecast d1 = new DailyForecast("Day 1",15.5,true);
DailyForecast d2 = new DailyForecast("Day 2",10.5,false);
DailyForecast d3 = new DailyForecast("Day 3",16.0,true);
DailyForecast d4 = new DailyForecast("Day 4",12.5,true);
DailyForecast d5 = new DailyForecast("Day 5",17.0,true);

//Print the values to console
d1.PrintForecastToConsole();
d2.PrintForecastToConsole();
d3.PrintForecastToConsole();
d4.PrintForecastToConsole();
d5.PrintForecastToConsole();

//Create a list Array to hold the DailyForecasts
ArrayList<DailyForecast> forecastArray = new ArrayList<DailyForecast>();
forecastArray.add(d1);
forecastArray.add(d2);
forecastArray.add(d3);
forecastArray.add(d4);
forecastArray.add(d5);

//Count the number of days of sun for the Stats
int numOfSunDays=0;
for (DailyForecast dailyForecast : forecastArray) {
	if (dailyForecast.sun==true) {
		numOfSunDays+=1;
	}
}

//Print the overall Stats
System.out.println("Overall Stats");
System.out.println("Temp\t\t\t:"+AverageTemp(d1.temp,d2.temp,d3.temp,d4.temp,d5.temp));
System.out.println("Number of days of sun\t: "+numOfSunDays);
	}
	//Method to work out the average
	static double AverageTemp(double a,double b,double c,double d,double e) {
		double average =(a+b+c+d+e)/5;
		return average;
	}
}
 class DailyForecast{
	String day="";
	double temp = 0.0;
	boolean sun = false;
	String tempMessage="";
	DailyForecast(String d, double t, boolean s){
		this.day=d;
		this.temp=t;
		this.sun=s;
		if (t>12.5) {
			tempMessage="Above average Temp";
			
		}
	}
	void PrintForecastToConsole(){
		System.out.println(day);
		System.out.println("Temp\t:"+temp);
		System.out.println("Sun \t:"+sun);
		System.out.println(tempMessage);
		System.out.println("___________________________________________");
	}
}
