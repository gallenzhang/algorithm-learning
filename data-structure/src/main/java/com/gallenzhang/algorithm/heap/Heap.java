package com.gallenzhang.algorithm.heap;
import lombok.Data;

/**
 * @author : zhangxq
 * @date : 2019/3/7
 * @description :堆
 */
@Data
public class Heap {

    private static final int DEFAULT_CAPACITY = 50;

    /**
     * 存储数据，下标从1开始
     */
    private Comparable[] arr;

    /**
     * 堆中已存储数据个数
     */
    private int count;


    public Heap(){
        this.arr = new Comparable[DEFAULT_CAPACITY + 1];
        this.count = 0;
    }

    public Heap(int capacity){
        this.arr = new Comparable[capacity + 1];
        this.count = 0;
    }

    public Heap(Comparable[] data){
        this.count = data.length;
        this.arr = new Comparable[data.length + 1];
        for(int i = 0; i<data.length; i++){
            arr[i+1] = data[i];
        }
        buildHeap();
    }

    /**
     * 交互数据
     * @param i
     * @param j
     */
    private void swap(int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * "从下往上"调整
     * @param pos
     */
    private void upAdjust(int pos){
        while (pos / 2 >0 && arr[pos / 2].compareTo(arr[pos]) < 0){
            swap(pos,pos / 2);
            pos = pos / 2;
        }
    }

    /**
     * "从上往下"调整
     * @param pos:下沉节点下标
     * @param n：堆有效大小
     */
    private void downAdjust(int pos,int n){
        int maxPos = pos;
        while (true){
            if(pos * 2 <= n && arr[pos * 2].compareTo(arr[pos]) > 0){
                maxPos = pos * 2;
            }
            if(pos * 2 + 1 <= n && arr[pos * 2 + 1].compareTo(arr[maxPos]) > 0){
                maxPos = pos * 2 + 1;
            }

            if(maxPos == pos){
                break;
            }
            swap(pos,maxPos);
            pos = maxPos;
        }
    }

    /**
     * 构造堆
     */
    private void buildHeap(){
        for(int i = count / 2; i>0; i--){
            downAdjust(i,count);
        }
    }

    /**
     * 往堆中插入数据
     * @param data
     */
    public void insert(Comparable data){
        if(count + 1 >= arr.length){
            throw new IllegalArgumentException();
        }

        count++;
        arr[count] = data;
        upAdjust(count);
    }

    /**
     * 删除堆顶元素
     */
    public void removeTop(){
        if(count == 0){
            return;
        }

        arr[1] = arr[count];
        arr[count] = null;
        count--;
        downAdjust(1,count);
    }

    /**
     * 堆排序
     */
    public void sort(){
        int n = count;
        for (int i = count; i > 1 ; i--){
            swap(1,i);
            downAdjust(1,--n);
        }
    }

    public static void main(String[] args) {
        //sort test
        Integer[] arr = new Integer[]{5,8,16,22,13,2,19,7,10,6};
        Heap heap = new Heap(arr);
        heap.sort();
        System.out.println(heap.toString());

        //build heap test
        Heap heap1 = new Heap(arr);
        System.out.println(heap1.toString());

        //removeTop test
        heap1.removeTop();
        System.out.println(heap1.toString());

        //insert test
        Heap heap2 = new Heap(10);
        for(Integer a : arr){
            heap2.insert(a);
        }
        System.out.println(heap2.toString());
    }

}
