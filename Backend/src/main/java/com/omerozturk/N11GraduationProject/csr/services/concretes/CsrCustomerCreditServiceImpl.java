package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;
import com.omerozturk.N11GraduationProject.cnt.services.abstracts.CntMessageService;
import com.omerozturk.N11GraduationProject.crd.services.abstracts.CrdCreditService;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditResponseDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerCreditService;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrGuaranteeService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerCreditEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerCreditMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerCreditNotFoundException;
import com.omerozturk.N11GraduationProject.gen.adapter.creditScoreAdapter.CustomerCreditScoreService;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CsrCustomerCreditServiceImpl implements CsrCustomerCreditService {

    private final CsrCustomerCreditEntityService csrCustomerCreditEntityService;
    private final CsrCustomerService csrCustomerService;
    private final CrdCreditService crdCreditService;
    private final CustomerCreditScoreService customerCreditScoreService;
    private final CsrGuaranteeService csrGuaranteeService;
    private final CntMessageService cntMessageService;

    @Override
    public DataResult<List<CsrCustomerCreditDto>> findAll() {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findAll();
        List<CsrCustomerCreditDto> csrCustomerCreditDtoList = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<>(csrCustomerCreditDtoList,"Krediler Listelendi");
    }

    @Override
    public DataResult<CsrCustomerCreditDto> findById(Long id) {
        CsrCustomerCredit csrCustomerCredit = getCsrCustomerCredit(id);
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
        return new SuccessDataResult<>(csrCustomerCreditDto,"Kredi Getirildi");
    }
     @Override
    public DataResult<List<CsrCustomerCreditDto>> findByCustomerId(Long customerId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findByCustomerId(customerId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kullanıcıya Ait Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<>(crdCreditDtoList,"Kullanıcının Kredileri Getirildi");
    }
    @Override
    public DataResult<List<CsrCustomerCreditDto>> findActiveCreditsByCustomerId(Long customerId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findActiveCreditsByCustomerId(customerId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kullanıcıya Ait Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<>(crdCreditDtoList,"Kullanıcının Kredileri Getirildi");
    }
     @Override
    public DataResult<List<CsrCustomerCreditDto>> findByCreditId(Long creditId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findByCreditId(creditId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<>(crdCreditDtoList,"Kredi Türüne Göre Kredileri Getirildi");
    }



    @Override
    @Transactional
    public DataResult<CsrCustomerCreditDto> applyForCredit(CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto) {
        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditSaveRequestDtoToCsrCustomerCredit(csrCustomerCreditSaveRequestDto);
        CsrCustomer csrCustomer = customerIsThere(csrCustomerCredit.getCsrCustomerId());
        CsrCustomerCredit customerHaveSystemApprovedCredit = customerHaveSystemApprovedCredit(csrCustomerCredit.getCsrCustomerId());
        if(customerHaveSystemApprovedCredit !=null){
            CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(customerHaveSystemApprovedCredit);
            return new SuccessDataResult<>(csrCustomerCreditDto,"Zaten Onay Bekleyen Bir Krediniz Var");
        }
        creditIsThere(csrCustomerCredit.getCrdCreditId());

        CsrCustomerCredit csrCustomerCreditResponse = customerCreditLimit(csrCustomerCredit, csrCustomer.getIdentityNumber(), csrCustomer.getSalary().intValue());

        return saveCustomerCredit(csrCustomerCreditResponse,csrCustomer.getPhoneNumber());
    }

    @Override
    @Transactional
    public DataResult<CsrCustomerCreditDto> customerCreditResponse(CsrCustomerCreditResponseDto csrCustomerCreditResponseDto) {
        CsrCustomerCredit csrCustomerCredit = getCsrCustomerCredit(csrCustomerCreditResponseDto.getId());
        if(csrCustomerCredit.getCreditResult() == EnumCreditResult.SYSTEM_DENIED){
            return new ErrorDataResult<>("Krediniz Onaylanmamıştır.");
        }
        if(csrCustomerCredit.getCreditResult()==EnumCreditResult.CUSTOMER_APPROVED || csrCustomerCredit.getCreditResult()==EnumCreditResult.CUSTOMER_DENIED){
            return new ErrorDataResult<>("Bu Krediyi Zaten Cevapladınız.");
        }

        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit.setCreditResult(csrCustomerCreditResponseDto.getCreditResult());
        if(csrCustomerCredit.getCreditResult()==EnumCreditResult.CUSTOMER_DENIED){
            csrCustomerCredit.setStatus(EnumStatus.PASSIVE);
        }
        csrCustomerCreditEntityService.save(csrCustomerCredit);
        log.info("Customer Response Credit {}", csrCustomerCredit);
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
       DataResult result= csrCustomerCreditDto.getCreditResult()==EnumCreditResult.CUSTOMER_APPROVED?
                new SuccessDataResult<>(csrCustomerCreditDto,"Kredinizi Onayladınız, Krediniz Hesabınıza Yatırılacaktır."):
                new ErrorDataResult(csrCustomerCreditDto,"Krediyi Reddettiniz, Krediden Yararlanamayacaksınız.");
       return result;
    }

    @Override
    public Result delete(Long id) {
        CsrCustomerCredit csrCustomerCredit = getCsrCustomerCredit(id);
        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit.setStatus(EnumStatus.DELETED);
        csrCustomerCreditEntityService.save(csrCustomerCredit);
        log.info("Deleted Customer Credit {}", csrCustomerCredit);
        return new SuccessResult("Müşteri Kredisi Silindi");
    }

    @Override
    public DataResult<List<CsrCustomerCreditDto>> findCustomerCreditsResults(String identityNumber, Date dateOfBirth) {
        DataResult customerControlResult = customerControlByIdentityNumberAndDateOfBrith(identityNumber, dateOfBirth);
        if(!customerControlResult.isSuccess()){
            return new ErrorDataResult<>(customerControlResult.getMessage());
        }
        List<CsrCustomerCredit> customerCreditList = csrCustomerCreditEntityService.findByCustomerIdentityNumber(identityNumber);
        if(customerCreditList.isEmpty()){
            return new ErrorDataResult<>("Size Ait Bir Kredi Bulunamadı!");
        }
        List<CsrCustomerCreditDto> csrCustomerCreditDtoList = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(customerCreditList);
        return new SuccessDataResult<>(csrCustomerCreditDtoList,"Kredi Sonuçlarınız Listeleniyor");
    }

    @Override
    public DataResult<CsrCustomerCreditDto> findCustomerCreditsResultBySystemApproved(String identityNumber, Date dateOfBirth) {
        DataResult customerControlResult = customerControlByIdentityNumberAndDateOfBrith(identityNumber, dateOfBirth);
        if(!customerControlResult.isSuccess()){
            return new ErrorDataResult<>(customerControlResult.getMessage());
        }
        CsrCustomerCredit customerCredit = csrCustomerCreditEntityService.findByCustomerIdentityNumberAndSystemApproved(identityNumber);
        if(customerCredit == null){
            return new ErrorDataResult<>("Size Ait Onay Bekleyen Bir Kredi Bulunamadı!");
        }
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper
                .INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(customerCredit);
        return new SuccessDataResult<>(csrCustomerCreditDto,"Kredi Sonucu Getirildi");
    }

    private  DataResult<CsrCustomerCreditDto> saveCustomerCredit(CsrCustomerCredit csrCustomerCredit,String phoneNNumber){
        csrCustomerCredit.setStatus(EnumStatus.ACTIVE);
        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit = csrCustomerCreditEntityService.save(csrCustomerCredit);

        if(csrCustomerCredit.getCreditResult() == EnumCreditResult.SYSTEM_APPROVED){
            sendSms(csrCustomerCredit,phoneNNumber);
        }
        log.info("Customer Credit Apply And Saved {}", csrCustomerCredit);
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
        return new SuccessDataResult<>(csrCustomerCreditDto,"Kredi İsteğiniz Alındı");
    }
    private CsrCustomerCredit getCsrCustomerCredit(Long id){
        CsrCustomerCredit csrCustomerCredit = csrCustomerCreditEntityService.findById(id);
        if (csrCustomerCredit == null || csrCustomerCredit.getStatus() != EnumStatus.ACTIVE){
            throw new CsrCustomerCreditNotFoundException("Kredi Bulunanamdı!");
        }
        return csrCustomerCredit;
    }

    private CsrCustomerCredit customerHaveSystemApprovedCredit(Long csrCustomerId) {
        return csrCustomerCreditEntityService.findHaveSystemApprovedCreditByCustomerId(csrCustomerId);
    }
    private DataResult customerControlByIdentityNumberAndDateOfBrith(String identityNumber, Date dateOfBirth) {
        if (identityNumber.isEmpty() || dateOfBirth==null){
            return new ErrorDataResult<>("Kimlik Numarası ve Doğum Tarihi Boş Geçilemez!");
        }
        DataResult<CsrCustomerDto> customerDtoDataResult = csrCustomerService.findByIdentityNumber(identityNumber);
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String resultDateOfBirth = df.format(customerDtoDataResult.getData().getDateOfBirth());
        String dateOfBirthString = df.format(dateOfBirth);

        if( !resultDateOfBirth.equals(dateOfBirthString) ){
            return new ErrorDataResult<>("Veriler Hatalı, Lütfen Bilgilerinizi Kontrol Ediniz!");
        }
        return new SuccessDataResult();
    }
    private CsrCustomer customerIsThere(Long csrCustomerId) {
        DataResult<CsrCustomerDto> csrCustomerDto = csrCustomerService.findById(csrCustomerId);
        return CsrCustomerMapper.INSTANCE.convertCsrCustomerDtoToCsrCustomer(csrCustomerDto.getData());
    }
    private void creditIsThere(Long credCreditId) {
        crdCreditService.findById(credCreditId);
    }

    private CsrCustomerCredit customerCreditLimit(CsrCustomerCredit csrCustomerCredit,String identityNumber,int salary){

        int customerCreditScore = customerCreditScoreService.calculateCreditScore(Long.valueOf(identityNumber));
        int guaranteeRate=0;
        if (customerCreditScore<500){
            csrCustomerCredit.setCreditAmount(BigDecimal.ZERO);
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_DENIED);
            csrCustomerCredit.setResultExplanation("Kredi Reddedildi. Kredi Skoru Yetersiz");
            return csrCustomerCredit;
        }
        else if (customerCreditScore >= 500 && customerCreditScore<1000 && salary<5000){
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            csrCustomerCredit.setCreditAmount(new BigDecimal(10000));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=10;
        }
        else if (customerCreditScore>=500 && customerCreditScore<1000 && salary>=5000 && salary<10000){
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            csrCustomerCredit.setCreditAmount(new BigDecimal(20000));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=20;
        }
        else if (customerCreditScore>=500 && customerCreditScore<1000 && salary>=10000){
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            int creditAmount= (salary*(4/2));
            csrCustomerCredit.setCreditAmount(new BigDecimal(creditAmount));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=25;
        }
        else if (customerCreditScore >= 1000){
            int creditAmount= (salary*4);
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            csrCustomerCredit.setCreditAmount(new BigDecimal(creditAmount));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=50;
        }
        else {
            csrCustomerCredit.setCreditAmount(BigDecimal.ZERO);
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_DENIED);
            csrCustomerCredit.setResultExplanation("Kredi Reddedildi. Kredi Skoru Yetersiz");
            return csrCustomerCredit;
        }
       int totalCustomerGuarantee = csrGuaranteeService.findByCustomerTotalGuarantee(csrCustomerCredit.getCsrCustomerId()).intValue();
        if(totalCustomerGuarantee>0){
            int creditAmount = totalCustomerGuarantee * (guaranteeRate/100)+csrCustomerCredit.getCreditAmount().intValue();
            csrCustomerCredit.setCreditAmount(new BigDecimal(creditAmount));
        }
        return csrCustomerCredit;
    }
    private  void sendSms(CsrCustomerCredit csrCustomerCredit, String phoneNumber) {
        CntMessageSendRequestDto cntMessageSendRequestDto=new CntMessageSendRequestDto();
        cntMessageSendRequestDto.setTitle("Kredi Onayı");
        cntMessageSendRequestDto.setContents("N11 Bootcamp: Krediniz Onaylandı. Kredinizi Kabul Etmek İçin Linke Basınız: https://bit.ly/3u0rdIG");
        cntMessageSendRequestDto.setCsrCustomerId(csrCustomerCredit.getCsrCustomerId());
        DataResult<CntMessageDto> cntMessageDtoDataResult = cntMessageService.sendMessage(cntMessageSendRequestDto);
        if(!cntMessageDtoDataResult.isSuccess()){
            throw new RuntimeException("Hata Oluştu Lütfen Dahas Sonra Tekrar Deneyiniz!");
        }
    }
}
