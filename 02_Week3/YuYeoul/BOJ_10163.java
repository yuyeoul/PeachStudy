import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//전체 크기 2차원 배열 생성
		int[][]arr=new int[1001][1001];
		Scanner sc = new Scanner(System.in);
		//전체 색종이 개수 입력받기
		int num= sc.nextInt();
		for(int i=0;i<num;i++) {
			//색종이의 좌표값 받아서 배열에 저장
			int[] ia=new int[4];
			for(int j=0;j<4;j++) {
			ia[j]=sc.nextInt();
			}
			//시작점 x,y좌표와 높이 너비로 2차원 배열에 색종이 번호로 값 변경하기
			for(int j=ia[0];j<ia[0]+ia[2];j++) {
				for(int k=ia[1];k<ia[1]+ia[3];k++) {
					arr[j][k]=(i+1);
				}
			}
			
		}
		//숫자를 셀 배열을 만들어서 2차원배열에 입력되어있는 숫자 세기
		int[]sum=new int[num+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				sum[arr[i][j]]++;
			}
		}
		for(int i=1;i<sum.length;i++) {
			System.out.println(sum[i]);
		}

	}

}