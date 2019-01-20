package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Level;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.dto.VoucherTypeDto;
import zw.co.deepkah.voucher.service.LevelService;
import zw.co.deepkah.voucher.service.VoucherTypeService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VoucherTypeMutationResolver implements GraphQLMutationResolver {
    
    private VoucherTypeService voucherTypeService;
    private LevelService levelService;


    public VoucherType createVoucherType(VoucherTypeDto voucherTypeDto){
        Level level = levelService.findByName(voucherTypeDto.getLevel());
        VoucherType voucherType= new VoucherType();
        voucherType.setName(voucherTypeDto.getName());
        voucherType.setDescription(voucherTypeDto.getDescription());
        voucherType.setLevel(level);
        voucherType.setPrice(voucherTypeDto.getPrice());
        return voucherTypeService.save(voucherType);
    }

    public VoucherType updateVoucherType(VoucherTypeDto voucherTypeDto, Optional<String> voucherTypeId){
        VoucherType voucherType = new VoucherType();
        voucherTypeId.ifPresent(s -> {
            Level level = levelService.findByName(voucherTypeDto.getLevel());
            voucherType.setId(voucherTypeService.getOne(s).get().getId());
            voucherType.setName(voucherTypeDto.getName());
            voucherType.setDescription(voucherTypeDto.getDescription());
            voucherType.setLevel(level);
            voucherType.setPrice(voucherTypeDto.getPrice());
        });

        return voucherType;
    }
}
