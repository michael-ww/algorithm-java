package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// Time complexity: O(n!)
public class NowCoderKillMonster {

    public static void main(String[] args) {
        String input = "3\n3 100\n10 20\n45 89\n5 40\n3 100\n10 20\n45 90\n5 40\n3 100\n10 20\n45 84\n5 40";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int i = 0; i < caseCount; i++) {
            int skillCount = scanner.nextInt();
            int totalBlood = scanner.nextInt();
            int[][] skillDamages = new int[skillCount][2];
            for (int j = 0; j < skillCount; j++) {
                skillDamages[j][0] = scanner.nextInt();
                skillDamages[j][1] = scanner.nextInt();
            }
            int answer = backstrack(skillDamages, 0, totalBlood);
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }
    }

    private static int backstrack(int[][] skillDamages, int index, int blood) {
        if (blood <= 0) {
            return index;
        }
        if (index >= skillDamages.length) {
            return Integer.MAX_VALUE;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = index; i < skillDamages.length; i++) {
            swap(skillDamages, index, i);
            answer = Math.min(answer, backstrack(skillDamages, index + 1, blood - (blood <= skillDamages[index][1] ? 2 * skillDamages[index][0] : skillDamages[index][0])));
            swap(skillDamages, index, i);
        }

        return answer;
    }

    private static void swap(int[][] skillDamage, int i, int j) {
        int skill = skillDamage[i][0];
        int damage = skillDamage[i][1];
        skillDamage[i][0] = skillDamage[j][0];
        skillDamage[i][1] = skillDamage[j][1];
        skillDamage[j][0] = skill;
        skillDamage[j][1] = damage;
    }
}
