import axios from "axios";
import { environment } from "../environments/environment";
export class CustomerCreditService {
    addCustomeCredit(customerCredit) {
        return axios.post(environment.customerCreditServicePath, customerCredit) 
    }
    getAllCustomerCreditList() {
        return axios.get(environment.customerCreditServicePath)
    }
    getCustomeCreditById(id) {
        return axios.get(environment.customerCreditServicePath  + id)
    }
    deleteCustomeCustomer(id) {
        return axios.delete(environment.customerCreditServicePath+id)
    }
    customerCreditResponse(customrResponse) {
        return axios.put(environment.customerCreditServicePath, customrResponse) 
    }
    getCustomeCreditsByCustomerId(customerId) {
        return axios.get(environment.customerCreditServicePath +"customer/" + customerId)
    }
    getCustomeCreditsByCreditId(creditId) {
        return axios.get(environment.customerCreditServicePath +"credit/" + creditId)
    }
    getCustomeCreditsByActiveCreditCustomer(customerId) {
        return axios.get(environment.customerCreditServicePath +"active-credits-customer/" + customerId)
    }
    getCustomerCreditsResults(identityNumber,dateOfBirth) {
        return axios.get(environment.customerCreditServicePath +"credit-result/" + identityNumber+"/"+dateOfBirth)
    }
    getCustomerCreditsResultBySystemApproved(identityNumber,dateOfBirth) {
        return axios.get(environment.customerCreditServicePath +"credit-result-approved/" + identityNumber+"/"+dateOfBirth)
    }
}