package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.EducationStatus;
import zw.co.deepkah.voucher.document.MaritalStatus;

import java.time.LocalDate;
@Data
public class BeneficiaryIdentificationDto {

    private String firstName;
    private String lastName;
    private String maritalStatusDto;
    private String birthDate;
    private MaritalStatus maritalStatus;
    private EducationStatus educationStatus;
    private String educationStatusDto;
    private String lmp;
    private Long parity;
    private String identificationNumber;
    private String latitude;
    private String longitude;
    private String phoneNumber;
    private String address;
    private LocalDate dateIdentified;
    private String IdentifiedBy;
    private String pregnancyStatus;
    private String dataCollectionDate;
    private String ga;


}
