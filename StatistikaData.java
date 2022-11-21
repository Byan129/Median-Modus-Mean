import java.util.Scanner;
import java.util.ArrayList;

class StatistikaData {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.print("Banyak Data : ");
		int arrLength = input.nextInt(); //Input panjang array/banyak data
		//Input isi data
		int[] arr = new int[arrLength];
		for(int i = 0; i < arrLength; i++) {
			System.out.print("Data ke-" + (i+1) + " : ");
			arr[i] = input.nextInt();
		}
		System.out.println("---------------");
		
		cetakArr(sortingArr(arr)); //Memanggul fungsi pencetak array yang sudah diurutkan
		System.out.println("\nMedian : " + median(arr)); //Mencetak sekaligus memanggil median, mean, dan modus
		System.out.println("Mean : " + mean(arr));
		System.out.print("Modus : "); cetakArrList(modus(arr));
	}
	
	public static int[] sortingArr(int[] arr) { //fungsi untuk mengurutkan data suatu array
		int data;
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = arr.length-1; j > i; j--) {
				if(arr[j-1] > arr[j]) {
					data = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = data;
				}
			}
		}
		return arr;
	}
	
	public static void cetakArr(int[] arr) { //fungsi sebagai pencetak array yang telah diurutkan
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
		
	public static double median(int[] arr) { //fungsi untuk mencari median(nilai tengah) suatu data
		//Mencari Median
		int dataMedian = arr.length/2;
		double median;
		arr = sortingArr(arr);
		if(arr.length % 2 == 0) median = (double)(arr[dataMedian-1]+arr[dataMedian])/2;
		else median = (double)arr[dataMedian];
		
		return median;
	}
		
	public static float mean(int[] arr) { //fungsi untuk mencari mean(rata-rata) suatu data
		//Mencari Mean
		float mean;
		int jumlah = 0;
		for(int i = 0; i < arr.length; i++) {
			jumlah = jumlah + arr[i];
		}
		mean = (float)jumlah / arr.length;
		
		return mean;
	}
	
	public static ArrayList<Integer> modus(int[] arr) { //fungsi untuk mencari modus menggunakan ArrayList
		arr = sortingArr(arr);
		ArrayList<Integer> angkaModus = new ArrayList<Integer>();
		int dataModus = 0 ,modusSementara = 1, modusAkhir = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length;j++) {
				if(arr[j] == arr[i] && j != i) {
					modusSementara++;
					if(modusSementara >= modusAkhir) {
						modusAkhir = modusSementara;
						if(arr[j] != dataModus)
							angkaModus.add(arr[j]);
						dataModus = arr[j];
					}
				}
				else modusSementara = 1;
			}
		}
		return angkaModus;
	}
	public static void cetakArrList(ArrayList<Integer> angkaModus) { //fungsi sebagai pencetak ArrayList Modus
		for(int i = 0; i < angkaModus.size(); i++) {
			System.out.print(angkaModus.get(i) + " ");
		}
	}
/*fungsi untuk mencari modus manual, tetapi untuk fungsi ini memiliki kelemahan yaitu modus hanya boleh satu
	public static int modus0(int[] arr) {
		int angkaModus = 0, modusSementara = 1, modusAkhir = 1;
			
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == arr[i] && j != i) {
					modusSementara++;
					if(modusSementara >= modusAkhir) {
						modusAkhir = modusSementara;
						angkaModus = arr[j];
					}
				}
				else modusSementara = 1;
			}
		}			return angkaModus;
	} */
	
}

