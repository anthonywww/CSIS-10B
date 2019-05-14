package lab12;

import java.util.Random;

//--------------------------------------------------------------------
//
//  Laboratory 13                                      Job.java
//
// Definition for the Job heap element class
//
//--------------------------------------------------------------------

class Job implements Comparable<Job> {

	private int priority, arrived;

	public Job() {
		priority = 0;
		arrived = 0;
	}

	public Job(int pty) {
		priority = pty;
		arrived = 0;
	}

	public Job(int pty, int aTime) {
		priority = pty;
		arrived = aTime;
	}

	public int pty() {
		return priority;
	}

	public void setPty(int newPty) {
		priority = newPty;
	}

	public int getArrived() {
		return arrived;
	}

	public void setArrived(int time) {
		arrived = time;
	}
	
	@Override
	public int compareTo(Job other) {
		return other.priority - priority;
	}
	
	public static void main(String[] args) {
		Job[] jobs = new Job[20];
		Random rand = new Random();
		int time = 0;
		
		for (Job job : jobs) {
			final int priority = rand.nextInt(2);
			time += rand.nextInt(10);
			job = new Job(priority, time);
		}
		
		for (int i=0; i<jobs.length; i++) {
			System.out.printf("[%d] %s\n", i, jobs[i]);
		}
	}
	
}