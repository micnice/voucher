package zw.co.deepkah.voucher.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zw.co.deepkah.voucher.document.*;
import zw.co.deepkah.voucher.dto.BeneficiaryIdentificationDto;
import zw.co.deepkah.voucher.service.AddressDetailsService;
import zw.co.deepkah.voucher.service.BeneficiaryAssessmentService;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.service.ContactDetailsService;



import java.time.LocalDate;
import java.util.Iterator;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class BeneficiaryIdentificationUploadResource {

    private BeneficiaryIdentificationService beneficiaryIdentificationService;
    private BeneficiaryAssessmentService beneficiaryAssessmentService;
    private AddressDetailsService addressDetailsService;
    private ContactDetailsService contactDetailsService;



    @PostMapping("/excel-upload")
    public BeneficiaryIdentification readExcelUpload(@RequestParam("file") MultipartFile multipartFile) throws Exception {

        BeneficiaryIdentificationDto beneficiaryIdentificationDto = new BeneficiaryIdentificationDto();
        AddressDetails addressDetails = new AddressDetails();
        ContactDetails contactDetails = new ContactDetails();
        BeneficiaryIdentification beneficiaryIdentification = new BeneficiaryIdentification();
        BeneficiaryIdentification beneficiaryIdentification1 = new BeneficiaryIdentification();
        BeneficiaryAssessment beneficiaryAssessment = new BeneficiaryAssessment();
        Workbook workbook = new XSSFWorkbook(multipartFile.getInputStream());

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Iterator<Cell> cellsInRow = currentRow.iterator();

            while (cellsInRow.hasNext()) {

                Cell currentCell = cellsInRow.next();


                if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setFirstName(currentCell.getStringCellValue());

                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setLastName(currentCell.getStringCellValue());
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setIdentificationNumber(currentCell.getStringCellValue());
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setPhoneNumber(currentCell.getStringCellValue());
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setAddress(currentCell.getStringCellValue());
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setParity(Long.valueOf(currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setMaritalStatusDto(currentCell.getStringCellValue());
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setEducationStatusDto(currentCell.getStringCellValue());
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setBirthDate(LocalDate.parse(currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setLmp(LocalDate.parse(currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setDateIdentified(LocalDate.parse(currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setIdentifiedBy((currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setLatitude((currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setLongitude((currentCell.getStringCellValue()));
                } else if (currentCell.getCellType() == CellType.STRING) {
                    beneficiaryIdentificationDto.setLatitude((currentCell.getStringCellValue()));
                }
            }
        }
        beneficiaryIdentification.setFirstName(beneficiaryIdentificationDto.getFirstName());
        beneficiaryIdentification.setLastName(beneficiaryIdentificationDto.getLastName());
        beneficiaryIdentification.setIdentificationNumber(beneficiaryIdentificationDto.getIdentificationNumber());
        beneficiaryIdentification.setParity(beneficiaryIdentificationDto.getParity());
        beneficiaryIdentification.setLmp(beneficiaryIdentificationDto.getLmp());
        beneficiaryIdentification.setBirthDate(beneficiaryIdentificationDto.getBirthDate());
        beneficiaryIdentification.setCreatedBy(beneficiaryIdentificationDto.getIdentifiedBy());
        beneficiaryIdentification.setDateCreated(beneficiaryIdentificationDto.getDateIdentified());


        if (beneficiaryIdentificationDto.getMaritalStatusDto().equalsIgnoreCase(MaritalStatus.DIVORCED.toString()))
            beneficiaryIdentification.setMaritalStatus(MaritalStatus.DIVORCED);
        else if (beneficiaryIdentificationDto.getMaritalStatusDto().equalsIgnoreCase(MaritalStatus.MARRIED.toString()))
            beneficiaryIdentification.setMaritalStatus(MaritalStatus.MARRIED);
        else if (beneficiaryIdentificationDto.getMaritalStatusDto().equalsIgnoreCase(MaritalStatus.SINGLE.toString()))
            beneficiaryIdentification.setMaritalStatus(MaritalStatus.SINGLE);
        else if (beneficiaryIdentificationDto.getMaritalStatusDto().equalsIgnoreCase(MaritalStatus.WIDOWED.toString()))
            beneficiaryIdentification.setMaritalStatus(MaritalStatus.SINGLE);
        beneficiaryIdentification.setLongitude(beneficiaryIdentificationDto.getLongitude());
        beneficiaryIdentification.setLatitude(beneficiaryIdentificationDto.getLatitude());
        if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.ALEVEL.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.ALEVEL);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.DEGREE.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.DEGREE);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.HIGHER_NATIONAL_DIPLOMA.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.HIGHER_NATIONAL_DIPLOMA);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.MASTERS.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.MASTERS);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.NATIONAL_CERTIFICATE.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.NATIONAL_CERTIFICATE);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.NATIONAL_DIPLOMA.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.NATIONAL_DIPLOMA);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.OLEVEL.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.OLEVEL);
        else if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(EducationStatus.PHD.toString()))
            beneficiaryIdentification.setEducationStatus(EducationStatus.PHD);
        beneficiaryIdentification1.setId(beneficiaryIdentificationService.save(beneficiaryIdentification).getId());

        beneficiaryAssessment.setBeneficiaryIdentityId(beneficiaryIdentification1.getId());
        if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(PregnancyStatus.YES.toString()))
            beneficiaryAssessment.setPregnancyStatus(PregnancyStatus.YES);
        if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(PregnancyStatus.NO.toString()))
            beneficiaryAssessment.setPregnancyStatus(PregnancyStatus.NO);
        if (beneficiaryIdentificationDto.getPregnancyStatus().equalsIgnoreCase(PregnancyStatus.NA.toString()))
            beneficiaryAssessment.setPregnancyStatus(PregnancyStatus.NA);
        beneficiaryAssessment.setLongitude(beneficiaryIdentificationDto.getLongitude());
        beneficiaryAssessment.setLatitude(beneficiaryIdentificationDto.getLatitude());
        beneficiaryAssessmentService.save(beneficiaryAssessment);

        addressDetails.setBeneficiaryIdentificationId(beneficiaryIdentification1.getId());
        addressDetails.setAddressDescription(beneficiaryIdentificationDto.getAddress());
        addressDetailsService.save(addressDetails);

        contactDetails.setBeneficiaryIdentityId(beneficiaryIdentification1.getId());
        contactDetails.setContactDescription(beneficiaryIdentificationDto.getPhoneNumber());
        contactDetailsService.save(contactDetails);


        workbook.close();

        return beneficiaryIdentification;
    }
}
