class MedianFinder {

    /** initialize your data structure here. */
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    boolean even = true;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        even = true;
    }
    
    
    public void addNum(int num) {

        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }

        even = !even;
        
    }
    
    public double findMedian() {
        if (even)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */