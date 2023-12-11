package hibernate.invoice;

import hibernate.invoice.dao.InvoiceDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {
	@Autowired
	private InvoiceDao invoiceDao;
	@Test
	void testInvoiceDaoSave() {
		//given
		Item item = new Item(new BigDecimal(100),10, new BigDecimal(100));
		Item item2 = new Item(new BigDecimal(200),20, new BigDecimal(200));
		Product product = new Product("Product A");
		Product product2 = new Product("Product B");
		Invoice invoice = new Invoice("Invoice 1");
		item.setProduct(product);
		item2.setProduct(product2);
		item.setInvoice(invoice);
		item2.setInvoice(invoice);
		invoice.getItems().add(item);
		invoice.getItems().add(item2);
		//when
		invoiceDao.save(invoice);
		int invoiceId = invoice.getId();
		//then
		assertNotEquals(0, invoiceId);
		//cleanUp
//		productDao.deleteAll();
	}
	@Test
	void deleteAll(){
		invoiceDao.deleteAll();
	}

}
