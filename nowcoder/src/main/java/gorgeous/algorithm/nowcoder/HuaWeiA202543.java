package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Excel单元格数值统计
public class HuaWeiA202543 {

    public static void main(String[] args) {
        String input = "5 3\n10 12 =C5\n15 5 6\n7 8 =3+C2\n6 =B2-A1 =C2\n7 5 3\nB2:C4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        String[][] grid = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = scanner.next();
            }
        }
        String[] region = scanner.next().split(":");
        int[] start = getCellCoordinate(region[0]);
        int[] end = getCellCoordinate(region[1]);
        int answer = 0;
        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                answer += getCellValue(grid, i, j);
            }
        }

        System.out.println(answer);
    }

    private static int getCellValue(String[][] grid, int i, int j) {
        if (grid[i][j].charAt(0) == '=') {
            String function = grid[i][j].substring(1);
            if (function.contains("+")) {
                return operate(grid, function.split("\\+"), true);
            } else if (function.contains("-")) {
                return operate(grid, function.split("\\-"), false);
            } else {
                int[] coordinate = getCellCoordinate(function);
                return getCellValue(grid, coordinate[0], coordinate[1]);
            }
        } else {
            if (isCoordinate(grid[i][j])) {
                int[] coordinate = getCellCoordinate(grid[i][j]);
                return getCellValue(grid, coordinate[0], coordinate[1]);
            } else {
                return Integer.parseInt(grid[i][j]);
            }
        }
    }

    private static int[] getCellCoordinate(String position) {
        int column = position.charAt(0) - 65;
        int row = Integer.parseInt(position.substring(1)) - 1;
        return new int[]{row, column};
    }

    private static boolean isCoordinate(String string) {
        return string.charAt(0) >= 'A' && string.charAt(0) <= 'Z';
    }

    private static int operate(String[][] grid, String[] cells, boolean isAdd) {
        List<Integer> list = new ArrayList<>();
        for (String cell : cells) {
            if (isCoordinate(cell)) {
                int[] coordinate = getCellCoordinate(cell);
                list.add(getCellValue(grid, coordinate[0], coordinate[1]));
            } else {
                list.add(Integer.valueOf(cell));
            }
        }

        return isAdd ? list.getFirst() + list.getLast() : list.getFirst() - list.getLast();
    }
}
