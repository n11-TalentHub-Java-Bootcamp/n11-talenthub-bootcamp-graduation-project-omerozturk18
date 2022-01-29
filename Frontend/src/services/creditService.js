import axios from "axios";
import { environment } from "../environments/environment";
export class CreditService {
    addCredit(credit) {
        return axios.post(environment.creditServicePath, credit) 
    }
    getAllCreditList() {
        return axios.get(environment.creditServicePath)
    }
    getCreditById(id) {
        return axios.get(environment.creditServicePath  + id)
    }
    getCreditByName(creditName) {
        return axios.get(environment.creditServicePath +"name/" + creditName)
    }
    deleteCustomer(id) {
        return axios.delete(environment.creditServicePath+id)
    }
}