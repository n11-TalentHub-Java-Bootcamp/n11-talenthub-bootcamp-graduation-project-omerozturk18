import axios from "axios";
import { environment } from "../environments/environment";
export class CustomerGuaranteeService {
    addGuarantee(customerGuarantee) {
        return axios.post(environment.customerGuaranteeServicePath, customerGuarantee) 
    }
    addAllGuaranteeList(customerGuaranteeList) {
        return axios.post(environment.customerGuaranteeServicePath, customerGuaranteeList) 
    }
    getAllCustomerGuaranteeList() {
        return axios.get(environment.customerGuaranteeServicePath)
    }
    getCustomerGuaranteeById(id) {
        return axios.get(environment.customerGuaranteeServicePath  + id)
    }
    getCustomerByCustomerId(customerId) {
        return axios.get(environment.customerGuaranteeServicePath+"customer/"  + customerId)
    }
    deleteCustomer(id) {
        return axios.delete(environment.customerGuaranteeServicePath+id)
    }
}