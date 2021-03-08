import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests  extends TestBase{

    @Test
    public void test(){
        config.yandex().navigateToMarket();
        config.yandex().selectedComputer();
        config.yandex().selectTablets();
        config.yandex().setPriceRange(20000,35000);
        config.yandex().selectProducer("Apple");
        Assert.assertTrue(config.yandex().varifySearchResult());



    }
}
