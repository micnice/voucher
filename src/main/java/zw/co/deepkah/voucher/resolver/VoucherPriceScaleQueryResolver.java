package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import zw.co.deepkah.voucher.document.VoucherPriceScale;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.service.VoucherPriceScaleService;

import java.util.List;

@Component
@AllArgsConstructor
public class VoucherPriceScaleQueryResolver implements GraphQLQueryResolver {

    private VoucherPriceScaleService voucherPriceScaleService;


    public List<VoucherPriceScale> voucherPriceScaleListByvoucherTypeId(String voucherTypeId){
        return voucherPriceScaleService.findByVoucherType(new VoucherType(voucherTypeId));
        }


}
