package pl.edu.pw.algo.Graph;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicGraphFunctionsTest {

    private Graph graph;

    @BeforeEach
    public void setUp() {
        BasicGraphFunctions bf = new BasicGraphFunctions();
    }

    @Test
    public void should_throwAnException_when_EdgeIsNull() {
        //given
        Edge newEdge = null;
        graph = new Graph(1,1,0,1);

        //when
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> graph.addEdgeToList(0,newEdge));

        //then
        assertEquals("Given Edge is null!",expected.getMessage());
    }

    @Test
    public void should_throwAnException_when_IndexIsOutOfBound() {
        //given
        Edge newEdge = new Edge(0,1,2);
        graph = new Graph(1,1,0,1);

        //when
        IndexOutOfBoundsException expected = assertThrows(IndexOutOfBoundsException.class, () -> graph.addEdgeToList(2,newEdge));

        //then
        assertEquals("There is a problem with reading given graph! The size given is > than given lines with data in file", expected.getMessage());
    }

    @Test
    public void should_addEdgeToGraph_when_EdgeIsCorrect() {
        //given
        Edge newEdge = new Edge(0,1,2);
        graph = new Graph(1,1,0,1);

        //when
        LinkedList<Edge> answer = new LinkedList<>();
        answer.add(newEdge);
        graph.addEdgeToList(0,newEdge);

        //then

        assertEquals(answer, graph.getConnectionList(0));
    }

    @Test
    public void should_throwAnException_when_graphIsNull() {
        //given
        graph = null;

        //when
        NullPointerException expected = assertThrows(NullPointerException.class, () -> graph.saveGraph(""));
    }

    @Test
    public void should_throwAnException_when_GivenFileHasNothing() {
        //when
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> graph = new Graph("src/test/java/TestGraphs/TestGraph1_nothing"));

        //then
        assertEquals("FILE_READ_PROBLEM: There is a problem with reading given graph, check the file with graph!", expected.getMessage());
    }

    @Test
    void whenReadingGraph_givenFileWithMoreDataThanRowsOrCol_thenThrowAnException() {
        //Given and when
        Throwable exception=assertThrows(IndexOutOfBoundsException.class, () -> graph = new Graph("src/test/java/TestGraphs/TestGraph8_givenFileWithMoreThanRowsOrCol"));

        //Then

        assertEquals("There is a problem with reading given graph! The size given is > than given lines with data in file", exception.getMessage());

    }

    @Test
    public void should_throwAnException_when_givenGraphHasOnlyRows() {
        //when
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> graph = new Graph("src/test/java/TestGraphs/TestGraph2_onlyRowsGiven"));

        //then
        assertEquals("FILE_READ_PROBLEM: There is a problem with reading given graph, check the file with graph!", expected.getMessage());
    }

    @Test
    public void should_throwAnException_when_givenGraphHasBadStructure() {
        //when
        IndexOutOfBoundsException expected = assertThrows(IndexOutOfBoundsException.class, () -> graph = new Graph("src/test/java/TestGraphs/TestGraph3_IncorrectNumberOfNodes"));

        //then
        assertEquals("There is a problem with reading given graph! The size given is > than given lines with data in file", expected.getMessage());
    }

    @Test
    public void should_throwAnException_when_givenGraphHasDotInstead() {
        //when
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class, () -> graph = new Graph("src/test/java/TestGraphs/TestGraph4_graphHasDotInstead"));

        //then
        assertEquals("FILE_READ_PROBLEM: There is a problem with reading given graph, check the file with graph!", expected.getMessage());
    }

    @Test
    public void whenReadingGraph_givenFileHasBadStructure_thenThrowAnException(){

        //Given and when
        Throwable exception=assertThrows(IllegalArgumentException.class, () -> graph = new Graph("src/test/java/TestGraphs/TestGraph9_fileHasBadStructure"));

        //Then

        assertEquals("FILE_READ_PROBLEM: There is a problem with reading given graph, check the file with graph!", exception.getMessage());

    }

    @Test
    public void should_returnGraph_when_GraphHasOneNode() throws IOException {
        //given
        graph = new Graph("src/test/java/TestGraphs/TestGraph5_GraphHasOneNode");

        //when
        int expectedColNum = 1;
        int expectedRowNum = 1;
        boolean expectedMinWeight = true;
        boolean expectedMaxWeight = true;

        //then
        assertEquals(expectedColNum, graph.getColNum());
        assertEquals(expectedRowNum, graph.getRowsNum());
        assertEquals(expectedMaxWeight, graph.getMaxWeight() <= 1 && graph.getMinWeight() >=0);
        assertEquals(expectedMinWeight, graph.getMaxWeight() <= 1 && graph.getMinWeight() >=0);
    }

    @Test
    public void should_returnGraph_when_GraphTwoNodes() throws IOException {
        //given
        graph = new Graph("src/test/java/TestGraphs/TestGraph6_GraphHasTwoNodes");

        //when

        int expectedColNum = 2;
        int expectedRowNum = 2;
        boolean expectedMinWeight = true;
        boolean expectedMaxWeight = true;

        //then
        assertEquals(expectedColNum,graph.getColNum());
        assertEquals(expectedRowNum,graph.getRowsNum());
        assertEquals(expectedMaxWeight, graph.getMaxWeight() <= 1 && graph.getMinWeight() >=0);
        assertEquals(expectedMinWeight, graph.getMaxWeight() <= 1 && graph.getMinWeight() >=0);
    }

    @Test
    public void should_returnGraph_when_GraphHasNumerousNodes() throws IOException {
        //given
        graph = new Graph("src/test/java/TestGraphs/TestGraph7_GraphHasNumerousNodes");

        //when
        int expectedColNum = 5;
        int expectedRowNum = 5;
        boolean expectedMinWeight = true;
        boolean expectedMaxWeight = true;

        //then
        assertEquals(expectedColNum,graph.getColNum());
        assertEquals(expectedRowNum,graph.getRowsNum());
        assertEquals(expectedMaxWeight, graph.getMaxWeight() <= 1 && graph.getMinWeight() >=0);
        assertEquals(expectedMinWeight, graph.getMaxWeight() <= 1 && graph.getMinWeight() >=0);
    }

}