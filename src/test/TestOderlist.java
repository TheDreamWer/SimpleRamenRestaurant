package test;

import control.FillOrderList;
import control.SaveOrderList;
import entities.OrderList;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestOderlist {


    @Test
    public void TestFill() {
        FillOrderList testFill = new FillOrderList();
        Assert.assertNotNull(testFill.getOrderlist());
        System.out.println(testFill.getOrderlist().getSumAmount());
    }

    @Test
    public void TestSave() throws IOException {
        SaveOrderList testSave = new SaveOrderList(new OrderList());
        testSave.Save();
    }
}
