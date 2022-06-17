package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.HeapInterface;
import java.util.ArrayList;
import java.util.Collections;

public class Heap implements HeapInterface {

    private final ArrayList<Double> heap;

    public Heap(int maxSize){
        heap = new ArrayList<>(maxSize);
    }

    public Heap(){
        heap = new ArrayList<>();
    }

    @Override
    public double pop() {

        if(getSize() == 0 ){
            throw new IllegalStateException();
        }

        double removedElement = heap.get(0);
        heap.set(0, heap.get(getSize()-1));
        heap.remove(getSize()-1);
        heapDown(0);

        return removedElement;
    }

    @Override
    public void put(double element) {
        heap.add(element);
        heapUp(heap.size()-1);
    }

    @Override
    public void heapUp(int index) {
        double element = heap.get(index);

        while(hasParent(index) && element < heap.get(getParent(index))){
            Collections.swap(heap,index,getParent(index));
            index = getParent(index);
        }

    }

    @Override
    public void heapDown(int index) {
        while(getLeftChildren(index) < getSize() ){
            int smallerChildIndex = getLeftChildren(index);

            if(getRightChildren(index) < getSize() &&  leftChildValue(index) > rightChildValue(index)){
                smallerChildIndex = getRightChildren(index);
            }

            if(getElement(index) < getElement(smallerChildIndex)){
                break;
            } else {
                Collections.swap(heap,index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    @Override
    public int getLeftChildren(int parent) {
        return 2*parent+1;
    }

    @Override
    public int getRightChildren(int parent) {
        return 2*parent+2;
    }

    @Override
    public int getParent(int children) {
        return (children-1)/2;
    }

    @Override
    public boolean hasParent(int children) {
        return getParent(children) >= 0;
    }

    @Override
    public int getSize() {
        return heap.size();
    }

    @Override
    public double leftChildValue(int index) {
        return heap.get(getLeftChildren(index));
    }

    @Override
    public double rightChildValue(int index) {
        return heap.get(getRightChildren(index));
    }

    @Override
    public double getElement(int index) {
        return heap.get(index);
    }

    @Override
    public void printHeap() {
        for(double element : heap){
            System.out.println(element);
        }
    }

    @Override
    public int compareTo(Double o) {
        return 0;
    }

}
