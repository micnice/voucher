package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.VoucherSet;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.dto.VoucherSetDto;
import zw.co.deepkah.voucher.service.VoucherSetService;
import zw.co.deepkah.voucher.service.VoucherTypeService;

import java.util.*;

@Component

public class VoucherSetMutationResolver implements GraphQLMutationResolver {

    private VoucherSetService voucherSetService;
    private  VoucherTypeService voucherTypeService;
    private VoucherType voucherType;

    public VoucherSetMutationResolver(VoucherSetService voucherSetService, VoucherTypeService voucherTypeService) {
        this.voucherSetService = voucherSetService;
        this.voucherTypeService = voucherTypeService;
    }

    public VoucherSet createVoucherSet(VoucherSetDto voucherSetDto){
        VoucherSet voucherSet = new VoucherSet();
        List<VoucherType>  voucherTypeSet = new ArrayList<>();

        voucherSet.setName(voucherSetDto.getName());
        voucherSet.setDescription(voucherSetDto.getDescription());

        voucherSetDto.getVoucherTypeSet().stream().forEach(s -> {
           voucherType = voucherTypeService.getOne(s).get();
            voucherTypeSet.add(voucherType);
        });
       Set oderedSet =new LinkedHashSet(voucherTypeSet);
        voucherSet.setVoucherTypeSet(oderedSet);



        return voucherSetService.save(voucherSet);
    }


    public VoucherSet updateVoucherSet(VoucherSetDto voucherSetDto, Optional<String> voucherSetId){
        VoucherSet voucherSet = new VoucherSet();
        Set<VoucherType>  voucherTypeSet = new HashSet<>();
        if(voucherSetId.isPresent()){
            voucherSet = voucherSetService.getOne(voucherSetId.get()).get();
            voucherSet.setName(voucherSetDto.getName());
            voucherSet.setDescription(voucherSetDto.getDescription());
            voucherSetDto.getVoucherTypeSet().stream().forEach(voucherTypeSetId -> {
                voucherTypeSet.add(new VoucherType(voucherTypeService.getOne(voucherTypeSetId).get().getId()));
            });

            voucherSet.setVoucherTypeSet(voucherTypeSet);
        }
        return voucherSetService.save(voucherSet);
    }
}
