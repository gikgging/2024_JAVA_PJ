package main;

public class Weather; {
	
	//The name of Weather
	private String weatherName;
	
	//The Score of sun light
	private double sunScore;
	
	//The Score of water from rain
	private double rainScore;
	
	//The Constructor of weather this constructor is for initialization
	public Weather(String name, double initSun, double initRain) {
		weatherName = name;
		sunScore = initSun;
		rainScore = initRain;
	}
	
	//When the weather score is applied >> Crop에 넣어야하나?, sunScore_prev 등의 변수 정의 필요
	public void weather_score(double sunScore, double rainScore) {
		sunScore_prev += sunScore;
		rainScore_prev += rainScore;
	}
	
}