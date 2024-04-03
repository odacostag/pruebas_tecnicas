import axios from "axios";

const COMPANY_ALL_BASE_MICROSERVICES_URL = "http://localhost:8080/company";
const INVENTORY_BASE_MICROSERVICES_URL = "http://localhost:8080/inventory";
const PRODUCT_BASE_MICROSERVICES_URL = "http://localhost:8080/product";

class CompanyService{
    getCompanyAll(){
        return axios.get(COMPANY_ALL_BASE_MICROSERVICES_URL)
    }

    createCompany(company){
        return axios.post(COMPANY_ALL_BASE_MICROSERVICES_URL,company)
    }

    validateUser(email,password){
        return axios.get(INVENTORY_BASE_MICROSERVICES_URL + '/'+email +'/'+password)
    }
    getProductAll(){
        return axios.get(PRODUCT_BASE_MICROSERVICES_URL)
    }

    createProduct(product){
        return axios.post(PRODUCT_BASE_MICROSERVICES_URL,product)
    }
    
    
}

export default new CompanyService();