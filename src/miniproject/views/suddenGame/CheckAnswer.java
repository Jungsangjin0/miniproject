package practice.suddenGame;

public class CheckAnswer {
	
	public static boolean checkAnswer(int arr1[], int arr2[]) {
		if ((arr1[0]==arr2[0])&&(arr1[1]==arr1[1])&&(arr1[2]==arr2[2])&&(arr1[3]==arr1[3])
				&&(arr1[4]==arr2[4])&&(arr1[5]==arr1[5])&&(arr1[6]==arr2[6])&&(arr1[7]==arr1[7])
				&&(arr1[8]==arr2[8])&&(arr1[9]==arr1[9])&&(arr1[10]==arr2[10])&&(arr1[11]==arr1[11])
				&&(arr1[12]==arr2[12])&&(arr1[13]==arr1[13])&&(arr1[14]==arr2[14])&&(arr1[15]==arr1[15])
				&&(arr1[16]==arr2[16])&&(arr1[17]==arr1[17])) {
			return true; 
		}  return false;
	}

}
