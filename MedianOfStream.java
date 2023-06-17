package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer>minHeap=new PriorityQueue<>();
     public void insertNum(int num){
         if(maxHeap.isEmpty() || maxHeap.peek()>=num){
             maxHeap.add(num);
         }
         else{
             minHeap.add(num);
         }
         if(maxHeap.size()>minHeap.size()+1){
             minHeap.add(maxHeap.poll());
         }
         else if(minHeap.size()>maxHeap.size()){
             maxHeap.add(minHeap.poll());
         }
     }

     public double findMedian(){
         if(maxHeap.size()==minHeap.size()){
             return maxHeap.peek()/2 +minHeap.peek()/2 ;
         }
         return maxHeap.peek();

     }
}
