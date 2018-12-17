package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.dto.VoucherTypeDto;
import zw.co.deepkah.voucher.service.VoucherTypeService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VoucherTypeMutationResolver implements GraphQLMutationResolver {
    
    private VoucherTypeService voucherTypeService;


    public VoucherType createVoucherType(VoucherTypeDto voucherTypeDto){
        VoucherType voucherType= new VoucherType();
        voucherType.setName(voucherTypeDto.getName());
        voucherType.setDescription(voucherTypeDto.getDescription());
        return voucherTypeService.save(voucherType);
    }

    public VoucherType updateVoucherType(VoucherTypeDto voucherTypeDto, Optional<String> voucherTypeId){
        VoucherType voucherType = new VoucherType();
        voucherTypeId.ifPresent(s -> {

            voucherType.setId(voucherTypeService.getOne(s).get().getId());
            voucherType.setName(voucherTypeDto.getName());
            voucherType.setDescription(voucherTypeDto.getDescription());
        });

        return voucherType;
    }
}
