package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.PregnancyStatus;

import java.util.Arrays;
import java.util.List;

@Component
public class PregnancyStatusQueryResolver implements GraphQLQueryResolver {


    public List<PregnancyStatus> pregnacyStatusList(){
        return Arrays.asList(PregnancyStatus.values());
    }
}
