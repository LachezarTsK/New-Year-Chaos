import java.util.*;;

public class Solution {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int numberOfTestCases = reader.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfPeopleInQueue = reader.nextInt();
			int[] finalStateOfQueue = new int[numberOfPeopleInQueue];
			for (int j = 0; j < numberOfPeopleInQueue; j++) {
				finalStateOfQueue[j] = reader.nextInt();
			}
			minimumBribes(finalStateOfQueue);
		}
	}

	static void minimumBribes(int[] finalStateOfQueue) {

		int minimumBribes = 0;
		boolean moreThanTwoBribesPerPerson = false;

		for (int i = finalStateOfQueue.length - 1; i >= 0; i--) {
			int bribesPerPerson = finalStateOfQueue[i] - (i + 1);

			if (bribesPerPerson > 2) {
				moreThanTwoBribesPerPerson = true;
				break;
			} else if (bribesPerPerson == 1) {
				minimumBribes += bribesPerPerson;
				int tempStore = finalStateOfQueue[i + 1];
				finalStateOfQueue[i + 1] = finalStateOfQueue[i];
				finalStateOfQueue[i] = tempStore;
			} else if (bribesPerPerson == 2) {
				minimumBribes += bribesPerPerson;
				int tempStore_01 = finalStateOfQueue[i + 1];
				int tempStore_02 = finalStateOfQueue[i + 2];
				finalStateOfQueue[i + 2] = finalStateOfQueue[i];
				finalStateOfQueue[i + 1] = tempStore_02;
				finalStateOfQueue[i] = tempStore_01;
				i++;
			}
		}

		if (moreThanTwoBribesPerPerson) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(minimumBribes);
		}
	}
}
