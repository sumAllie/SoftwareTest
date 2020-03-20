import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class Test1 {
    private ArrayList<Integer> list, list1;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
    }
    @After
    public void tearDown(){
        list = null;
        list1 = null;
    }

    //Tests for addAll
    //IndexOutOfBound
    @Test
    public void addAll_Index_OverBound(){
        int num = list.size()+1;
        try {
            list.addAll(num, list1);
        } catch (IndexOutOfBoundsException e){
            return;
        }
        fail("IndexOutOfBoundsException expected");
    }

    @Test
    public void addAll_Index_BeyondBound(){
        int num = -1;
        try {
            list.addAll(num, list1);
        } catch (IndexOutOfBoundsException e){
            return;
        }
        fail("IndexOutOfBoundsException expected");
    }
    //NullPointer
    @Test
    public void addAll_NullPointer(){
        try {
            list.addAll(0, null);
        } catch (NullPointerException e){
            return;
        }
        fail("NullPointerException expected");
    }

    //Tests for subList
    //IndexOutOfBound
    @Test
    public void subList_FromIndex_Negative(){
        int fromIndex = -1;
        int toIndex = list.size() - 1;
        try {
            list.subList(fromIndex, toIndex);
        } catch (IndexOutOfBoundsException e){
            return;
        }
        fail("IndexOutOfBoundsException expected");
    }
    @Test
    public void subList_ToIndex_OverBound(){
        int fromIndex = 0;
        int toIndex = list.size() + 1;
        try {
            list.subList(fromIndex, toIndex);
        } catch (IndexOutOfBoundsException e){
            return;
        }
        fail("IndexOutOfBoundsException expected");
    }
    //IllegalArgumentException
    @Test
    public void subList_Indices_OutOfOrder(){
        int fromIndex = list.size() - 1;
        int toIndex = 0;
        try {
            list.subList(fromIndex, toIndex);
        } catch (IllegalArgumentException e){
            return;
        }
        fail("IllegalArgumentException expected");
    }

}