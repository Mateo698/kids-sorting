import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void sortBubbleWithAverage(double[] array) {
		boolean changed = true;
		ArrayList<Integer> numChanges = new ArrayList<Integer>();
		for(int i=1; i<array.length && changed;i++) {
			changed = false;
			int changes = 0;
			for(int j=0;j<array.length-1;j++) {
				if(array[j]>array[j+1]) {
					double temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					changed = true;
					changes++;
				}
			}
			numChanges.add(changes);
			changes = 0;
		}
		
		double averageChanges = 0;
		for(int i=0;i<numChanges.size();i++) {
			averageChanges += numChanges.get(i);
		}
		averageChanges = averageChanges/numChanges.size();
		String strArray = "";
		for(int i =0;i<array.length;i++) {
			strArray += array[i] + " ";
		}
		System.out.println(averageChanges+" - "+strArray);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(br.readLine());
		System.out.println(cases);
		for(int i=0;i<cases;i++) {
			String arrayInput = br.readLine();
			String[] parts = arrayInput.split(" ");
			double[] array = new double[parts.length];
			for(int j=0;j<parts.length;j++) {
				array[j] = Double.parseDouble(parts[j]);
			}
			sortBubbleWithAverage(array);
		}
	}
	
}
