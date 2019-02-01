package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "beneficiary_identification")
public class BeneficiaryIdentification extends BaseId {

    private String firstName;
    private String lastName;
    private MaritalStatus maritalStatus;
    private Date birthDate;
    private EducationStatus educationStatus;
    private Date lmp;
    private Long parity;
    private String identificationNumber;
    private String latitude;
    private String longitude;
    private Boolean isAssessed = Boolean.FALSE;
    private Boolean reAssess = Boolean.FALSE;
    private Date dataCollectionDate;
    private Date edd;
    private String phoneNumber;
    private Long povertyScore;
    private Boolean reassess = Boolean.FALSE;

    public BeneficiaryIdentification(String id) {
        super(id);
    }

    @Transient
    public Long getPovertyScore() {
        return povertyScore;
    }

    public void setPovertyScore(Long povertyScore) {
        this.povertyScore = povertyScore;
    }
}


