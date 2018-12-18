package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.service.VoucherTypeService;

import java.util.List;

@AllArgsConstructor
@Component
public class VoucherTypeQueryResolver implements GraphQLQueryResolver {

    private VoucherTypeService voucherTypeService;


    public List<VoucherType> getVoucherTypeList(){
        return  voucherTypeService.findAll().get();
    }

    public VoucherType getVoucherTypeByName(String name){
        return voucherTypeService.findByName(name);
    }

}
