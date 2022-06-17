package pl.edu.pw.algo.Interfaces;

public interface HeapInterface extends Comparable<Double>{
    double pop();
    void put(double element);
    void heapUp(int index);
    void heapDown(int index);
    int getLeftChildren(int parent);
    int getRightChildren(int parent);
    int getParent(int children);
    boolean hasParent(int children);
    int getSize();
    double leftChildValue(int index);
    double rightChildValue(int index);
    double getElement(int index);
    void printHeap();
}
