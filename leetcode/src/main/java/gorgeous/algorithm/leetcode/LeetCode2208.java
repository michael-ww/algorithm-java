package gorgeous.algorithm.leetcode;

import java.util.PriorityQueue;

public class LeetCode2208 {

    public int halveArray1(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            sum += num;
            pq.offer((double) num);
        }
        sum /= 2;
        int answer = 0;
        for (double minus = 0, current; minus < sum; answer++, minus += current) {
            current = pq.poll() / 2;
            pq.offer(current);
        }
        return answer;
    }

    public int halveArray2(int[] nums) {
        long[] heap = new long[nums.length];
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            heap[i] = nums[i] << 20;
            sum += heap[i];
            heapify(heap, i);
        }
        sum >>= 1;
        int answer = 0;
        for (long minus = 0, current; minus < sum; answer++, minus += current) {
            current = heap[0] >> 1;
            heap[0] = current;
            heapify(heap, 0);
        }

        return answer;
    }

    private void heapify(long[] heap, int index) {
        int left = index * 2 + 1;
        while (left < heap.length) {
            int largest = left + 1 < heap.length && heap[left + 1] > heap[left] ? left + 1 : left;
            largest = heap[largest] > heap[index] ? largest : index;
            if (largest == index) {
                break;
            }
            Utility.swap(heap, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
