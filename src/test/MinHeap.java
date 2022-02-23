package test;

import java.util.Arrays;

public class MinHeap{
    private int[] array;
    private int size;

    public MinHeap(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("!!!");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--){
            percolateDown(i);
        }
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }
    private void percolateUp(int index){
        //stop condition when index <= 0
        while (index > 0){
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]){
                swap(array, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDown(int index){
        //stop condition when index > (size) / 2 -1;
        while (index <= size / 2 - 1){
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidate = leftChildIndex;
            if(rightChildIndex < size && array[leftChildIndex] >= array[rightChildIndex]){
                swapCandidate = rightChildIndex;
            }
            if(array[index] > array[swapCandidate]){
                swap(array, index, swapCandidate);
            }else{
                break;
            }
            index = swapCandidate;
        }
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return array[0];

    }

    public int poll(){
        if (size == 0){
            throw new IllegalArgumentException("!!!");
        }
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;

    }

    public void offer(int ele){
        if(size == array.length){
            array = Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    public Integer update(int index, int ele){
        if(index < 0 || index > size){
            return null;
        }
        int old = array[index];
        array[index] = ele;
        if (ele < old){
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return old;
    }

    private void swap(int[] array, int l, int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }


    }

