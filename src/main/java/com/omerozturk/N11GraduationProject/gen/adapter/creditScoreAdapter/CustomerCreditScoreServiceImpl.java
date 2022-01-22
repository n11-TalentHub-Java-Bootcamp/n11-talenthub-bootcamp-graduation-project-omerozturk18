package com.omerozturk.N11GraduationProject.gen.adapter.creditScoreAdapter;

import org.springframework.stereotype.Service;

@Service
public class CustomerCreditScoreServiceImpl implements CustomerCreditScoreService
{
    @Override
    public int  calculateCreditScore(int identityNumber) {
        int lastDigitOfIdentityNumber=identityNumber %10;
        switch (lastDigitOfIdentityNumber) {
            case 0: {
                return 2000;
            }
            case 2: {
                return 550;
            }
            case 4: {
                return 1000;
            }
            case 6: {
                return 400;
            }
            case 8: {
                return 900;
            }
            default: {
                return 0;
            }
        }
    }
}
