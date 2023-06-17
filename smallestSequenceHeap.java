package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class smallestSequenceHeap {
    static int lengthOfSmallestSubsequence(int K, int []v)
    {
        // Initialize priority queue
        PriorityQueue<Integer> pq =
                new PriorityQueue<Integer>(Collections.reverseOrder());

        // Loop to insert all elements into
        // the priority queue
        for (int i = 0; i < v.length; i++)
        {
            pq.add(v[i]);
        }
        int sum = 0, count = 0;

        // Loop to find the smallest
        // subsequence such that sum of elements
        // is greater than equal to given number K
        while (!pq.isEmpty() && sum < K)
        {
            sum += pq.peek();
            pq.remove();
            count++;
        }

        // If sum is less than K
        // then return -1 else return count.
        if (sum < K)
        {
            return -1;
        }
        return count;
    }
}
