package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.VoucherSet;
import zw.co.deepkah.voucher.service.VoucherSetService;

import java.util.List;

@AllArgsConstructor
@Component
public class VoucherSetQueryResolver implements GraphQLQueryResolver {
    private VoucherSetService voucherSetService;

    public List<VoucherSet> getVoucherSetList(){
        return voucherSetService.findAll().get();
    }

    public VoucherSet getVoucherSetByName(String name){
        return voucherSetService.findByName(name);
    }




}
