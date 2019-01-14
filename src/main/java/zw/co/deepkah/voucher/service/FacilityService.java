package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.Facility;

public interface FacilityService extends IService<Facility>{


    Facility findByName(String name);

}
