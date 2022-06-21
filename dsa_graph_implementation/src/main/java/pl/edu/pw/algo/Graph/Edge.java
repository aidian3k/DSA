package pl.edu.pw.algo.Graph;

import pl.edu.pw.algo.Graph.Interfaces.EdgeInterface;

import java.util.Objects;

public class Edge implements EdgeInterface {
    private final int nodeFrom;
    private final int nodeTo;
    private final double weight;

    public Edge(int nodeFrom, int nodeTo, double weight){
        this.nodeFrom=nodeFrom;
        this.nodeTo=nodeTo;
        this.weight=weight;
    }

    public int getNodeFrom(){
        return nodeFrom;
    }

    public int getNodeTo(){
        return nodeTo;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return nodeFrom == edge.nodeFrom && nodeTo == edge.nodeTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeFrom, nodeTo);
    }

}
