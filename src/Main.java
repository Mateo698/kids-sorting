import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<double[]> arrays = new ArrayList<double[]>();
		int cases = Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++) {
			String arrayInput = br.readLine();
			String[] parts = arrayInput.split(" ");
			double[] array = new double[parts.length];
	
			for(int j=0;j<parts.length;j++) {
			array[j] = Double.parseDouble(parts[j]);
			}
			arrays.add(array);
		}
		for(int i =0; i<arrays.size();i++) {
			sortBubbleWithAverage(arrays.get(i));
		}
		br.close();
		bw.close();	
	}
	
	public static void sortBubbleWithAverage(double[] array) throws IOException {
		ArrayList<Integer> numChanges = new ArrayList<Integer>();
		for(int i=1; i<array.length;i++) {
			//changed = false;
			int changes = 0;
			for(int j=0;j<array.length-1;j++) {
				if(array[j]>array[j+1]) {
					double temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					//changed = true;
					changes++;
				}
			}
			
			numChanges.add(changes);
			
		}
		
		DecimalFormat df = new DecimalFormat("###.##");
		
		double averageChanges = 0;
		for(int i=0;i<numChanges.size();i++) {
			averageChanges += numChanges.get(i);
		}
		averageChanges = averageChanges/numChanges.size();
		String strArray = "";
		for(int i =0;i<array.length;i++) {
			if(i==array.length-1) {
				strArray += array[i];
			}
			else {
				strArray += array[i] + " ";
			}
		}
		bw.write(df.format(averageChanges)+" - "+strArray);
	}
	
}
