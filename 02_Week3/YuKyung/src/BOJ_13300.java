import java.util.Scanner;

public class BOJ_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 학생 수
        int k = sc.nextInt(); // 각 방의 최대 수용 인원
        
        int[] girls = new int[7]; // 여학생들의 학년별 인원을 저장하는 배열
        int[] boys = new int[7]; // 남학생들의 학년별 인원을 저장하는 배열
        
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(); // 성별 (0: 여학생, 1: 남학생)
            int year = sc.nextInt(); // 학년
            
            if (s == 0) {
                girls[year]++; // 해당 학년의 여학생 인원 증가
            } else {
                boys[year]++; // 해당 학년의 남학생 인원 증가
            }
        }
        
        int cnt = 0; // 필요한 방의 수
        
        // 각 학년별로 필요한 방의 수 계산
        for (int i = 1; i <= 6; i++) {
            cnt += (girls[i] + k - 1) / k; // 여학생 인원을 최대 수용 인원으로 나누어 필요한 방의 수 계산
            cnt += (boys[i] + k - 1) / k; // 남학생 인원을 최대 수용 인원으로 나누어 필요한 방의 수 계산
        }
        
        System.out.println(cnt); // 필요한 방의 수 출력
    }
}