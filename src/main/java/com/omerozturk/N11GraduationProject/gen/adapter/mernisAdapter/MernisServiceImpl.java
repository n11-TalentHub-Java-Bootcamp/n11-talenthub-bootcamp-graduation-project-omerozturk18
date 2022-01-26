package com.omerozturk.N11GraduationProject.gen.adapter.mernisAdapter;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import org.springframework.stereotype.Service;
import tr.identity.check.ws.client.KPSPublic;
import tr.identity.check.ws.client.KPSPublicSoap;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class MernisServiceImpl implements CustomerCheckService{
    @Override
    public boolean checkIfRealCustomer(CsrCustomer csrCustomer) {
        KPSPublic service=new KPSPublic();
       KPSPublicSoap soapService= service.getKPSPublicSoap();

        try {
            int birthYear = LocalDateTime.ofInstant(
                    csrCustomer.getDateOfBirth().toInstant(), ZoneId.systemDefault()).getYear() ;
            return soapService.tcKimlikNoDogrula(Long.valueOf(csrCustomer.getIdentityNumber()),csrCustomer.getFirstName().toUpperCase(),csrCustomer.getLastName().toUpperCase(),birthYear);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
