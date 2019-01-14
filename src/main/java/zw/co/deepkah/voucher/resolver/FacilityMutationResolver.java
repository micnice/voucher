package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Facility;
import zw.co.deepkah.voucher.service.FacilityService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FacilityMutationResolver implements GraphQLMutationResolver {

    private FacilityService facilityService;

    public Facility createFacility(Facility facility){
        return facilityService.save(facility);
    }

    public Facility updateFacility(Facility facility, Optional<String> facilityId){
        if(facilityId.isPresent()){
            facility = facilityService.getOne(facilityId.get()).get();
            }
        return facilityService.save(facility);
    }



}
