package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.SaleIdentificationData;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.service.SalesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SalesIdentificationDataQueryResolver implements GraphQLQueryResolver {

    private SalesService salesService;
    private BeneficiaryIdentificationService beneficiaryIdentificationService;

    public  List<SaleIdentificationData> getVoucherSaleIdentificationDataList(){

      Optional<List<Sales>> allSales = salesService.findAll();
      List<SaleIdentificationData> identificationDataList = new ArrayList<>();
          if (allSales != null && !allSales.get().isEmpty()) {
              allSales.get().stream().forEach(s -> {
                  try {
                      BeneficiaryIdentification beneficiaryIdentification = beneficiaryIdentificationService.getOne(s.getBeneficiaryIdentityId()).get();
                      SaleIdentificationData sid = new SaleIdentificationData();
                      sid.setBeneficiaryIdentityId(beneficiaryIdentification.getId());
                      sid.setFirstName(beneficiaryIdentification.getFirstName());
                      sid.setLastName(beneficiaryIdentification.getLastName());
                      sid.setIdentificationNumber(beneficiaryIdentification.getIdentificationNumber());
                      sid.setSaleId(s.getId());
                      sid.setVoucherSerialNumber(s.getVoucherSerialNumber());
                      sid.setPackageName(s.getVoucherSet().getName());
                      identificationDataList.add(sid);
                  }catch (Exception ex){
                      ex.printStackTrace();
                  }

              });


          }


    return identificationDataList;

    }



}
