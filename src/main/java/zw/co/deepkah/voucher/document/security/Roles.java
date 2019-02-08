package zw.co.deepkah.voucher.document.security;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

    ADMINISTRATOR ,BENEFICIARY_IDENTIFIER , BENEFICIARY_ASSESSOR, CLAIMS_ASSESSOR,
    MANAGEMENT , DATA_ENTRY_CLERK, INSTITUTION_MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}
