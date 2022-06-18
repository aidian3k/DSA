package pl.edu.pw.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.algo.Interfaces.SearcherIterative;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchIterativeTest {

    private SearcherIterative searcher;

    @BeforeEach
    void setUp() {
        searcher = new BinarySearchIterative();
    }

    @Test
    public void should_ReturnNegativeValue_When_ArrayIsNull1() {
        // given
        int [] nums = null;
        int toFind = 0;

        //when
        int result = searcher.searchIterative(nums, toFind);

        //then
        int expected = -1;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnNegativeValue_When_ArrayIsEmpty1() {
        // given
        int [] nums = {};
        int toFind = 0;

        //when
        int result = searcher.searchIterative(nums, toFind);

        //then
        int expected = -1;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnCorrectIndex_When_ArrayHasOneElement1() {
        // given
        int [] nums = {1};
        int toFind = 1;

        //when
        int result = searcher.searchIterative(nums, toFind);

        //then
        int expected = 0;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnNegativeValue_When_ArrayDoesNotHaveElem1() {
        // given
        int [] nums = {1,2,3};
        int toFind = 4;

        //when
        int result = searcher.searchIterative(nums, toFind);

        //then
        int expected = -1;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnCorrectIndex_When_ArrayHasOddNumOfElem1() {
        // given
        int [] nums = {-3,-1,0,2,4,6,8};
        int toFind = 0;

        //when
        int result = searcher.searchIterative(nums, toFind);

        //then
        int expected = 2;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnCorrectIndex_When_SearchingForMaxElem1() {
        // given
        int [] nums = {-3,-1,0,2,4,6,8};
        int toFind = 8;

        //when
        int result = searcher.searchIterative(nums, toFind);

        //then
        int expected = 6;
        assertEquals(result,expected);
    }
}