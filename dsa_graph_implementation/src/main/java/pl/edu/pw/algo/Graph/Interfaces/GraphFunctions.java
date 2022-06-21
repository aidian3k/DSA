package pl.edu.pw.algo.Graph.Interfaces;

import pl.edu.pw.algo.Graph.Edge;

import java.io.IOException;
import java.util.LinkedList;

public interface GraphFunctions {

    void addEdgeToList(int index, Edge e); // Default set public

    void saveGraph (String path) throws IOException;

    void readGraph(String path) throws IOException;

    LinkedList<Edge> getConnectionList(int node);

}
