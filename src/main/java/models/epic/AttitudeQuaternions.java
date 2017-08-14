package models.epic;

public class AttitudeQuaternions {

	private double q0;
	private double q1;
	private double q2;
	private double q3;
	
	public void data(double q0, double q1, double q2, double q3) {
		this.q0 = q0;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}
	
	public double getQ0() {
		return q0;
	}
	
	public double getQ1() {
		return q1;
	}
	
	public double getQ2() {
		return q2;
	}
	
	public double getQ3() {
		return q3;
	}
}
