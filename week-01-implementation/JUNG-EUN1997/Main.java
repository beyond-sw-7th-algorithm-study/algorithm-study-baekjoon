import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] price = br.readLine().split(" ");
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");
        String[] third = br.readLine().split(" ");

        int[] amountArray = new int[]{0, Integer.parseInt(price[0]), Integer.parseInt(price[1]), Integer.parseInt(price[2])}; // 동시 주차비 [0대, 1대, 2대, 3대]
        int paymentValue = 0; // 지불해야하는 주차비


        //트럭들의 입장, 퇴장 입력하는 array {입장시간, 퇴장시간}
        int[][] trucksArray = {
                {Integer.parseInt(first[0]), Integer.parseInt(first[1])}, // 트럭 A
                {Integer.parseInt(second[0]), Integer.parseInt(second[1])}, // 트럭 B
                {Integer.parseInt(third[0]), Integer.parseInt(third[1])} // 트럭 C
        };

        ArrayList<Integer>[] trucksTimeCountArray = new ArrayList[trucksArray.length]; // 실제 시간대별로 쪼개서 넣어넣는 용도의 array
        ArrayList<Integer> truckTimesArray = new ArrayList<>(); // 트럭별 구분 없이 시간대별로 쪼갠 값 넣는 용도의 array

        int tempNum = 0;
        for(int num[]:trucksArray) { //트럭의 개수만큼 반복하기
            int tempIn = num[0];
            int tempOut = num[1];

            trucksTimeCountArray[tempNum] = new ArrayList<Integer>();

            for (int i = tempIn; i < tempOut ; i++) { //trucksTimeCountArray에 입퇴시간 시간별로 쪼개 넣기
                trucksTimeCountArray[tempNum].add(i);
                truckTimesArray.add(i);
            }
            tempNum = tempNum + 1;
        }

        Collections.sort(truckTimesArray); // 시간 순서별로 정렬
        ArrayList<Integer> duplicationTimesArray = new ArrayList<>();

        for (int i = 0; i < truckTimesArray.toArray().length; i++) {
            int numI = truckTimesArray.get(i);
            int numIDuplicationCount = 0; // 중복된 차 수
            int numIPayment; // 중복개수에 따른 트럭주차비 > 개수에 맞게 배열 저장

            for (int j = 0; j < truckTimesArray.toArray().length; j++) {
                int numJ = truckTimesArray.get(j);
                if (numI == numJ) {
                    numIDuplicationCount++;
                }
            }

            numIPayment = amountArray[numIDuplicationCount];
            duplicationTimesArray.add(numIPayment);

        }
        for(int i : duplicationTimesArray){
            paymentValue += i;
        }

        System.out.println(paymentValue);
    }
}