import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//100*100 사이즈 배열만들기
		int map[][]=new int[101][101];
		//색종이 수
		int num = sc.nextInt();
		//x 시작 좌표 배열
		int[] xarr=new int[num];
		//y 시작 좌표 배열
		int[] yarr=new int[num];
		//색종이들의 좌표 저장 및 변의 길이가 10이므로 시작 좌표부터 +10까지 채우기
		for(int i=0;i<num;i++) {
			xarr[i]=sc.nextInt();
			yarr[i]=sc.nextInt();
			for(int j=yarr[i];j<yarr[i]+10;j++) {
				for(int k=xarr[i];k<xarr[i]+10;k++) {
					map[j][k]=(i+1);
				}
			}
		}
		//0이 아닌 부분 세기
		int cnt=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++){
				if(map[i][j]!=0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
