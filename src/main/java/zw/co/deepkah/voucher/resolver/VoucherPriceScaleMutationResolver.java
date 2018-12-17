package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.VoucherPriceScale;
import zw.co.deepkah.voucher.dto.VoucherPriceScaleDto;
import zw.co.deepkah.voucher.service.VoucherPriceScaleService;

import java.util.Optional;

@AllArgsConstructor@Component
public class VoucherPriceScaleMutationResolver implements GraphQLMutationResolver {

    private VoucherPriceScaleService voucherPriceScaleService;

    public VoucherPriceScale createVoucherPriceScale(VoucherPriceScaleDto voucherPriceScaleDto){
        VoucherPriceScale voucherPriceScale= new VoucherPriceScale();
        voucherPriceScale.setPriceOfService(voucherPriceScaleDto.getPriceOfService());
        voucherPriceScale.setServiceProvisionLevel(voucherPriceScaleDto.getServiceProvisionLevel());
        voucherPriceScale.setVoucherType(voucherPriceScaleDto.getVoucherType());
        return voucherPriceScaleService.save(voucherPriceScale);
    }



    public VoucherPriceScale updateVoucherPriceScale(VoucherPriceScaleDto voucherPriceScaleDto, Optional<String> voucherPriceScaleId){
        VoucherPriceScale voucherPriceScale = new VoucherPriceScale();
        voucherPriceScaleId.ifPresent(s -> {

            voucherPriceScale.setId(voucherPriceScaleService.getOne(s).get().getId());
            voucherPriceScale.setPriceOfService(voucherPriceScaleDto.getPriceOfService());
            voucherPriceScale.setServiceProvisionLevel(voucherPriceScaleDto.getServiceProvisionLevel());
            voucherPriceScale.setVoucherType(voucherPriceScaleDto.getVoucherType());
        });

        return voucherPriceScale;
    }
}
