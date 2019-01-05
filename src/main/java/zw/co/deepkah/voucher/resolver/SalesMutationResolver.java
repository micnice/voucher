package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.dto.SalesDto;
import zw.co.deepkah.voucher.service.SalesService;

import java.time.LocalDate;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SalesMutationResolver implements GraphQLMutationResolver {

    private SalesService salesService;

    public Sales createSales(SalesDto salesDto){
        Sales sales = new Sales();
        sales.setSaleDate(LocalDate.parse(salesDto.getSaleDate()));
        sales.setSoldBy(salesDto.getSoldBy());
        sales.setVoucherSerialNumber(salesDto.getVoucherSerialNumber());
        return salesService.save(sales);
    }


    public Sales updateSales(SalesDto salesDto, Optional<String> salesId){
        Sales sales = new Sales();
        salesId.ifPresent(s -> {
            sales.setId(salesService.getOne(s).get().getId());
            sales.setSaleDate(LocalDate.parse(salesDto.getSaleDate()));
            sales.setSoldBy(salesDto.getSoldBy());
            sales.setVoucherSerialNumber(salesDto.getVoucherSerialNumber());
        });

        return salesService.save(sales);
    }
}
