package com.omerozturk.N11GraduationProject.gen.adapter.mernisAdapter;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class MernisServiceAdapter implements CustomerCheckService{
    @Override
    public boolean CheckIfRealCustomer(CsrCustomer csrCustomer) {
       /* DQQKPSPublicSoap publicSoap = new DQQKPSPublicSoap();

        try {
            int birthYear = LocalDateTime.ofInstant(
                    csrCustomer.getDateOfBirth().toInstant(), ZoneId.systemDefault()).getYear() ;
            return publicSoap.TCKimlikNoDogrula(Long.valueOf(csrCustomer.getIdentityNumber()),csrCustomer.getFirstName().toUpperCase(),csrCustomer.getLastName().toUpperCase(),birthYear);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return false;
    }
}
