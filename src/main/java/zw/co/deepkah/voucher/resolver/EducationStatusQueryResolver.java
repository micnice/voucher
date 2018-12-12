package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.EducationStatus;

import java.util.Arrays;
import java.util.List;

@Component
public class EducationStatusQueryResolver implements GraphQLQueryResolver {

    public List<EducationStatus>  getEductationStatusList(){
        return Arrays.asList(EducationStatus.values());
    }
}
