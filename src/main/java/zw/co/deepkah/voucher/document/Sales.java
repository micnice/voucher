package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection = "sales")
public class Sales extends BaseId {

    private String beneficiaryIdentityId;
    private String voucherSerialNumber;
    private Date saleDate;
    private String soldBy;
    private VoucherSet voucherSet;
    private Boolean saleExhausted = Boolean.FALSE;
    private Date ancVisitOneDate;
    private Boolean anc1Notified = Boolean.FALSE;
    private Boolean anc2Notified = Boolean.FALSE;
    private Boolean anc3Notified = Boolean.FALSE;
    private Boolean anc4Notified = Boolean.FALSE;
    private Boolean pnc7DaysNotified = Boolean.FALSE;
    private Boolean pnc6weeksNotified = Boolean.FALSE;
    private Date dateOfDelivery;
    private Date ancVisitTwoDate;
    private Date ancVisitThreeDate;
    private Date ancVisitFourDate;
    private Date pnc7DaysVisitDate;
    private Date pnc6weeksVisitDate;
    private String twentyDollarOTP;
    private String tenDollarOTP;


}
