package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Scanner;

// 计算误码率
public class HuaWeiB202533 {

    public static void main(String[] args) {
        // String input = "3A3B\n2A4B";
        // String input = "5Y5Z\n5Y5Z";
        String input = "4Y5Z\n9Y";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String standard = scanner.nextLine();
        String transport = scanner.nextLine();
        LinkedList<ZipString> llStandard = getZipStrings(standard);
        LinkedList<ZipString> llTransport = getZipStrings(transport);
        int diff = 0, same = 0;
        while (!llStandard.isEmpty()) {
            ZipString zsStandard = llStandard.pollFirst();
            ZipString zsTransport = llTransport.pollFirst();
            int comparingCount = Math.min(zsStandard.getCount(), zsTransport.getCount());
            if (zsStandard.getCharacter() == zsTransport.getCharacter()) {
                same += comparingCount;
            } else {
                diff += comparingCount;
            }
            if (zsStandard.getCount() > comparingCount) {
                zsStandard.setCount(zsStandard.getCount() - comparingCount);
                llStandard.addFirst(zsStandard);
            }
            if (zsTransport.getCount() > comparingCount) {
                zsTransport.setCount(zsTransport.getCount() - comparingCount);
                llTransport.addFirst(zsTransport);
            }
        }
        System.out.println(diff + "/" + (same + diff));
    }

    private static LinkedList<ZipString> getZipStrings(String string) {
        LinkedList<ZipString> ll = new LinkedList<>();
        int count = 0;
        for (char item : string.toCharArray()) {
            if (Character.isDigit(item)) {
                count = count * 10 + (item - '0');
            } else {
                ll.add(new ZipString(count, item));
                count = 0;
            }
        }
        return ll;
    }

    static class ZipString {

        private int count;
        private char character;

        public ZipString(int count, char character) {
            this.count = count;
            this.character = character;
        }

        public int getCount() {
            return count;
        }

        public char getCharacter() {
            return character;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setCharacter(char character) {
            this.character = character;
        }
    }
}
