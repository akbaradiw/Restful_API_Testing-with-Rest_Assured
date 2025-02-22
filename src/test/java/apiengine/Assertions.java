package apiengine;

import org.testng.Assert;

import com.example.model.ResponseItem;
public class Assertions {

public void assertAddProduct(ResponseItem responseItem) {
    Assert.assertEquals(responseItem.name,"Handuk Hitam");
    Assert.assertNotNull(responseItem.id);
    Assert.assertNotNull(responseItem.createdAt);
    Assert.assertEquals(responseItem.data.year, 2029);
    Assert.assertEquals(responseItem.data.price, 1849);
    Assert.assertEquals(responseItem.data.CPUModel, "Intel Core i9");
    Assert.assertEquals(responseItem.data.hardDiskSize, "1 TB");
}

public void getProduct(ResponseItem responseItem) {
    Assert.assertEquals(responseItem.name,"Apple AirPods");
    Assert.assertEquals(responseItem.data.generation, "3rd");
    Assert.assertEquals(responseItem.data.price, 120);
}


}
