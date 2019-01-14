package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.Facility;
import zw.co.deepkah.voucher.service.FacilityService;

import java.util.List;

@AllArgsConstructor
@Component
public class FacilityQueryResolver implements GraphQLQueryResolver {

    private FacilityService facilityService;

    public List<Facility> getFacilityList(){
        return facilityService.findAll().get();
    }

    public Facility findByName(String name){

        return facilityService.findByName(name);
    }
}
