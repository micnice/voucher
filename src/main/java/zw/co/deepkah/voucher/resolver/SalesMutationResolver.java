package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.document.ServiceProvider;
import zw.co.deepkah.voucher.document.VoucherSet;
import zw.co.deepkah.voucher.dto.SalesDto;
import zw.co.deepkah.voucher.service.SalesService;
import zw.co.deepkah.voucher.service.ServiceProviderService;
import zw.co.deepkah.voucher.service.VoucherSetService;
import zw.co.deepkah.voucher.util.DateFormatter;

import java.time.LocalDate;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SalesMutationResolver implements GraphQLMutationResolver {

    private SalesService salesService;
    private ServiceProviderService serviceProviderService;
    private VoucherSetService voucherSetService;


    public Sales createSales(SalesDto salesDto){
        Sales sales = new Sales();
        sales.setSaleDate(DateFormatter.getDateFromString(salesDto.getSaleDate()));
        sales.setSoldBy(salesDto.getSoldBy());
        sales.setVoucherSerialNumber(salesDto.getVoucherSerialNumber());
        sales.setBeneficiaryIdentityId(salesDto.getBeneficiaryIdentityId());
        ServiceProvider serviceProvider=serviceProviderService.getOne(salesDto.getServiceProviderId()).get();
        sales.setServiceProvider(serviceProvider);
        VoucherSet voucherSet = voucherSetService.getOne(salesDto.getVoucherSetId()).get();

        sales.setVoucherSet(voucherSet);
        return salesService.save(sales);
    }


    public Sales updateSales(SalesDto salesDto, Optional<String> salesId){
        Sales sales = new Sales();
        salesId.ifPresent(s -> {
            sales.setId(salesService.getOne(s).get().getId());
            sales.setSaleDate(DateFormatter.getDateFromString(salesDto.getSaleDate()));
            sales.setSoldBy(salesDto.getSoldBy());
            sales.setVoucherSerialNumber(salesDto.getVoucherSerialNumber());
            sales.setBeneficiaryIdentityId(salesDto.getBeneficiaryIdentityId());
            ServiceProvider serviceProvider=serviceProviderService.getOne(salesDto.getServiceProviderId()).get();
            sales.setServiceProvider(serviceProvider);
            VoucherSet voucherSet = voucherSetService.getOne(salesDto.getVoucherSetId()).get();
            sales.setVoucherSet(voucherSet);
        });

        return salesService.save(sales);
    }
}
