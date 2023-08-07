import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//스위치 배열 생성
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		//인원 수 받아서 루프
		int pe = sc.nextInt();
		for (int i = 0; i < pe; i++) {
			//남학생일 경우 해당 배수에 대해 0이면 1 1이면 0으로 바꿔주기
			if (sc.nextInt() == 1) {
				int m = sc.nextInt();
				int m1 = m;
				int iq = 2;
				while (true) {
					if (arr[m1 - 1] == 0) {
						arr[m1 - 1] = 1;
					} else {
						arr[m1 - 1] = 0;
					}
					m1 = iq * m;
					iq++;
					if (m1 > arr.length) {
						break;
					}
				}
				//여학생일 경우 배열의 범위를 넘어서지 않는 선에서 기준점 기준으로 대칭이 되는 최대 인덱스 찾기
			} else {
				int f = sc.nextInt() - 1;
				int d = 0;
				while (true) {
					if (((f - d) >= 0 && (f + d) <= arr.length - 1) && arr[f - d] == arr[f + d]) {
						d++;
					} else {
						d--;
						break;
					}
				}
				//최대 인덱스 기준으로 해당 범위 스위치 변경해주기
				for (int j = f - d; j <= f + d;j++) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			}
		}
		//20개 마다 끊어서 출력
		for(int i=0;i<arr.length;i++) {
            if(i<arr.length-1) {
			System.out.print(arr[i]+" ");
        }else {
				System.out.print(arr[i]);
			}
            if((i+1)%20==0) {
				System.out.println();
			}
		}

	}

}