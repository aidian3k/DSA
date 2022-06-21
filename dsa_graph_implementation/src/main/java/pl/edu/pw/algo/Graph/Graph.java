package pl.edu.pw.algo.Graph;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph extends BasicGraphFunctions {

    private static final Random rnd = new Random();
    public Graph(String path) throws IOException {
        super.readGraph(path);
    }

    public Graph(int rowsNum, int colNum, double minWeight, double maxWeight){
        if( rowsNum <= 0 || colNum <= 0 || minWeight < 0  && maxWeight <0 || minWeight > maxWeight ){
            throw new IllegalArgumentException("Illegal arguments given to the constructor!");
        }

        this.colNum = colNum;
        this.rowsNum = rowsNum;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;

        for (int c = 0; c < colNum; c++) {
            for (int r = 0; r < rowsNum; r++) {
                graph.add(new LinkedList<>()); //Initializing memory for the graph representation
            }
        }

        for(int i = 0 ; i < getNodesNum() ; ++i){
            int edgePerNode = rnd.nextInt(0, getNodesNum()/rowsNum);
            List<Edge> currentList = getConnectionList(i);

            for(int j = 0 ; j < edgePerNode ; ++j){
                Edge newEdge = new Edge(i, rnd.nextInt(0, getNodesNum()), rnd.nextDouble(minWeight, maxWeight));
                currentList.add(newEdge);
            }
        }
    }

    public int getColNum(){
        return this.colNum;
    }
    public int getRowsNum(){
        return this.rowsNum;
    }
    public int getNodesNum(){
        return colNum*rowsNum;
    }
    public double getMinWeight() { return minWeight; }
    public double getMaxWeight() { return maxWeight; }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + graph +
                ", colNum=" + colNum +
                ", rowsNum=" + rowsNum +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                '}';
    }
}