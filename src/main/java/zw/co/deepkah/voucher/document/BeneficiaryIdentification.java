package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.Transient;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Document(collection = "beneficiary_identification")
public class BeneficiaryIdentification extends BaseId {

    private String firstName;
    private String lastName;
    private MaritalStatus maritalStatus;
    private LocalDate birthDate;
    private EducationStatus educationStatus;
    private LocalDate lmp;
    private Long parity;
    private String identificationNumber;
    private String latitude;
    private String longitude;
    private Boolean isAssessed = Boolean.FALSE;
    private LocalDate dataCollectionDate;
    private Long povertyScore;

    @Transient
    public Long getPovertyScore() {
        return povertyScore;
    }

    public void setPovertyScore(Long povertyScore) {
        this.povertyScore = povertyScore;
    }
}


