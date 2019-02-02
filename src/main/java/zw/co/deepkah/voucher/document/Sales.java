package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "sales")
public class Sales extends BaseId {

    private String beneficiaryIdentityId;
    private String voucherSerialNumber;
    private String saleDate;
    private String soldBy;
    private VoucherSet voucherSet;
    private Boolean saleExhausted = Boolean.FALSE;
    private String ancVisitOneDate;
    private Boolean anc1Notified = Boolean.FALSE;
    private Boolean anc2Notified = Boolean.FALSE;
    private Boolean anc3Notified = Boolean.FALSE;
    private Boolean anc4Notified = Boolean.FALSE;
    private Boolean pnc7DaysNotified = Boolean.FALSE;
    private Boolean pnc6weeksNotified = Boolean.FALSE;
    private String dateOfDelivery;
    private String ancVisitTwoDate;
    private String ancVisitThreeDate;
    private String ancVisitFourDate;
    private String pnc7DaysVisitDate;
    private String pnc6weeksVisitDate;
    private String twentyDollarOTP;
    private String tenDollarOTP;

    public Sales(String id) {
        super(id);
    }
}
