import axios from "axios";
import { environment } from "../environments/environment";
export class CustomerService {
    addCustomer(customer) {
        return axios.post(environment.customerServicePath, customer) 
    }
    getAllCustomerList() {
        return axios.get(environment.customerServicePath)
    }
    getCustomerById(id) {
        return axios.get(environment.customerServicePath  + id)
    }
    getCustomerByIdentityNumber(identityNumber) {
        return axios.get(environment.customerServicePath+"identityNumber/"  + identityNumber)
    }
    deleteCustomer(id) {
        return axios.delete(environment.customerServicePath+id)
    }
}