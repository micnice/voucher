package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.EducationStatus;
import zw.co.deepkah.voucher.document.MaritalStatus;

import java.time.LocalDate;
@Data
public class BeneficiaryIdentificationDto {
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

}
