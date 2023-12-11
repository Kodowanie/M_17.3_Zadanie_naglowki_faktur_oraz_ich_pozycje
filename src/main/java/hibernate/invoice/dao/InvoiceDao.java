package hibernate.invoice.dao;

import hibernate.invoice.Invoice;
import hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Transactional
@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {
    List<Invoice> findByNumber(String number);
}
