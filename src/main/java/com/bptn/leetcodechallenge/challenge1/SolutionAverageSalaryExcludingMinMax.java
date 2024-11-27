package com.bptn.leetcodechallenge.challenge1;

class SolutionAverageSalaryExcludingMinMax {

	public double average(int[] salary) {
		// Setting the min and the max to the first element in the input array.
		int max = salary[0];
		int min = salary[0];

		// Initializing a total to calculate the total of the sum of all the members of
		// the array.
		int total = 0;
		if (!(salary.length >= 3) || !(salary.length <= 100)) {
			return 0.0; // If the array is less than 2 return 0.0 because one will be the max and the
						// other the min therefore we cannot find the average without the max and the
						// min.
						// and if salary length is greater than 100 it defeats the constraints put
		}

		// if (salary.length <= 2) {
		// return 0.0; //If the array is less than 2 return 0.0 because one will be the
		// max and the other the min therefore we cannot find the average without the
		// max and the min.
		// }
		// int count = 0; not needed divisor will always be length - 2

		// for loop to iterate over all the elements of the array. On each iteration the
		// elements are added to the total.
		for (int i = 0; i < salary.length; i++) {
			if (salary[i] < min) {
				min = salary[i]; // Here if a number smaller than our current local max is at our current index
									// then make that our new min. At the end of the loop we would have global min
									// of the array.
			} else if (salary[i] > max) {
				max = salary[i]; // Here if a number greater than our current local max is at our current index
									// then make that our new max. At the end of the loop we would have global max
									// of the array.
			}
			total += salary[i];
		}

		return (double) ((total - min) - max) / ((salary.length) - 2); // At the end we subtract the min and the max
																		// values from our total which is the sum of all
																		// the elements and then we divide by array
																		// length -1 because we remove min and max
	}

	public static void main(String[] args) {

		// creating a new object
		SolutionAverageSalaryExcludingMinMax solution = new SolutionAverageSalaryExcludingMinMax();

		int[] salary = { 4000, 3000, 1000, 2000 };

		// Call the average method and print the result
		// double result = solution.average(salary);
		System.out.println(solution.average(salary));
	}

}
