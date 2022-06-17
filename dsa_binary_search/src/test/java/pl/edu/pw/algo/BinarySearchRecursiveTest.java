package pl.edu.pw.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchRecursiveTest {

    private SearcherRecursive searcher;

    @BeforeEach
    public void setUp() {
        searcher = new BinarySearchRecursive();
    }

    @Test
    public void should_ReturnNegativeValue_When_ArrayIsNull() {
        // given
        int [] nums = null;
        int toFind = 0;

        //when
        int result = searcher.binarySearch(nums, 0, 0, toFind);

        //then
        int expected = -1;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnNegativeValue_When_ArrayIsEmpty() {
        // given
        int [] nums = {};
        int toFind = 0;

        //when
        int result = searcher.binarySearch(nums, 0, nums.length-1, toFind);

        //then
        int expected = -1;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnCorrectIndex_When_ArrayHasOneElement() {
        // given
        int [] nums = {1};
        int toFind = 1;

        //when
        int result = searcher.binarySearch(nums, 0, nums.length-1, toFind);

        //then
        int expected = 0;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnNegativeValue_When_ArrayDoesNotHaveElem() {
        // given
        int [] nums = {1,2,3};
        int toFind = 4;

        //when
        int result = searcher.binarySearch(nums, 0, nums.length-1, toFind);

        //then
        int expected = -1;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnCorrectIndex_When_ArrayHasOddNumOfElem() {
        // given
        int [] nums = {-3,-1,0,2,4,6,8};
        int toFind = 0;

        //when
        int result = searcher.binarySearch(nums, 0, nums.length-1, toFind);

        //then
        int expected = 2;
        assertEquals(result,expected);
    }

    @Test
    public void should_ReturnCorrectIndex_When_SearchingForMaxElem() {
        // given
        int [] nums = {-3,-1,0,2,4,6,8};
        int toFind = 8;

        //when
        int result = searcher.binarySearch(nums, 0, nums.length-1, toFind);

        //then
        int expected = 6;
        assertEquals(result,expected);
    }
}