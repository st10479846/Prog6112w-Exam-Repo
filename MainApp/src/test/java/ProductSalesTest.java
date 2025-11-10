



/**
 *
 * @author eugen
 */
import com.mycompany.mainapp.ProductData;
import com.mycompany.mainapp.ProductSales;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductSalesTest {

    ProductData data = new ProductData();
    ProductSales sales = new ProductSales(data);

    @Test
    public void getSalesOverLimit_ReturnNumberOfSales() {
        assertEquals(2, sales.GetSalesOverLimit());
    }

    @Test
    public void getSalesUnderLimit_ReturnNumberOfSales() {
        assertEquals(4, sales.GetSalesUnderLimit());
    }
}
