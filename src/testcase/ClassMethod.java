package testcase;

public class ClassMethod {
	
	private String name;
	private int color;
	private double weight;
	
	public ClassMethod(String name, int color, double weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	
	public ClassMethod() {
		name = null;
		color = 0;
		weight = 0.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
