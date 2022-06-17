package pl.edu.pw.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.algo.Interfaces.SortingInterface;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    SortingInterface sorting;

    @BeforeEach
    public void setUp() {
        sorting = new InsertionSort();
    }

    @Test
    public void should_ReturnArray_when_ArrayIsEmpty(){
        //given
        double[] nums = {};

        //when
        double [] numsExpected = {};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasOneElement(){
        //given
        double [] nums  = {1};

        //when
        double [] numsExpected = {1};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasTwoSortedElem(){
        //given
        double[] nums = {1,3};
        sorting.sort(nums);

        //when
        double [] numsExpected = {1,3};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasTwoUnSortedElem(){
        //given
        double[] nums = {5,2};
        sorting.sort(nums);

        //when
        double [] numsExpected = {2,5};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasTwoEqualElem(){
        //given
        double[] nums = {2,2};
        sorting.sort(nums);

        //when
        double [] numsExpected = {2,2};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasManyEqualElem(){
        //given
        double[] nums = {2,2,2,2,2,2,2,2,2,2};
        sorting.sort(nums);

        //when
        double [] numsExpected = {2,2,2,2,2,2,2,2,2,2};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasNegativeElem(){
        //given
        double[] nums = {-3,-1,-5,-1};
        sorting.sort(nums);

        //when
        double [] numsExpected = {-5,-3,-1,-1};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayIsOptimistic(){
        //given
        double[] nums = {-8,-7,-6,-5,-4,-3,-2,-1};
        sorting.sort(nums);

        //when
        double [] numsExpected = {-8,-7,-6,-5,-4,-3,-2,-1};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayIsPessimistic(){
        //given
        double[] nums = {5,4,3,2,1};
        sorting.sort(nums);

        //when
        double [] numsExpected = {1,2,3,4,5};

        //then
        assertArrayEquals(numsExpected,nums);
    }

    @Test
    public void should_ReturnArray_when_ArrayHasManyElem(){
        //given
        double[] nums = new double[1000];
        for(int i = 0 ; i < 1000; i ++){
            nums[i] = (new java.util.Random()).nextDouble(0,1000);
        }
        sorting.sort(nums);

        //when
        double [] numsExpected = nums;
        Arrays.sort(numsExpected);

        //then
        assertArrayEquals(numsExpected,nums);
    }

}