package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.service.SalesService;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SalesQueryResolver implements GraphQLQueryResolver {

    private SalesService salesService;

    public Sales saleById(Optional<String> salesId){
        Sales sales = new Sales();
        if (salesId.isPresent()) {

            sales = salesService.getOne(salesId.get()).get();
        }
        return sales;
        }

    public List<Sales> salesList(){
     return salesService.findAll().get();
    }

    public Sales getSaleByVoucherSerialNumber(String voucherSerialNumber){
     return salesService.findByVoucherSerialNumber(voucherSerialNumber);
    }



}
