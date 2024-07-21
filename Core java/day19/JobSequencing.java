package day19;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Job {
    int Id;
    int Deadline;
    int Profit;

    public Job(int id, int deadline, int profit) {
        this.Id = id;
        this.Deadline = deadline;
        this.Profit = profit;
    }
    public String toString() {
        return "Job ID: " + this.Id + ", Deadline: " + this.Deadline + ", Profit: " + this.Profit;
    }
}

public class JobSequencing {
	 public static List<Job> jobSequencing(List<Job> jobs) {
	        // Sort the jobs in descending order of profit
	        Collections.sort(jobs, (a, b) -> b.Profit - a.Profit);
	        int n = jobs.size();
	        boolean[] slots = new boolean[n]; // To keep track of free time slots
	        Job[] result = new Job[n]; // To store the result (sequence of jobs)
	        for (int i = 0; i < n; i++) {
	            slots[i] = false;
	        }
	        for (int i = 0; i < n; i++) {
	            // Find a free slot for this job (Note that we start from the last possible slot)
	            for (int j = Math.min(n, jobs.get(i).Deadline) - 1; j >= 0; j--) {
	                // Free slot found
	                if (!slots[j]) {
	                    slots[j] = true;
	                    result[j] = jobs.get(i);
	                    break;
	                }
	            }
	        }
	        List<Job> jobSequence = new ArrayList<>();
	        for (Job job : result) {
	            if (job != null) {
	                jobSequence.add(job);
	            }
	        }

	        return jobSequence;
	    }
	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 2, 100));
        jobs.add(new Job(2, 1, 19));
        jobs.add(new Job(3, 2, 27));
        jobs.add(new Job(4, 1, 25));
        jobs.add(new Job(5, 3, 15));

        List<Job> jobSequence = jobSequencing(jobs);

        System.out.println("Job sequence for maximum profit:");
        for (Job job : jobSequence) {
            System.out.println(job);
		// TODO Auto-generated method stub
        }
	}

}
