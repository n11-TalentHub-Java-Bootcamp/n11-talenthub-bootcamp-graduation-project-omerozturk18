import React from 'react';
import { toast } from 'react-toastify';
import { Col, Container, Row, Table } from 'reactstrap';
import { CustomerCreditService } from '../../services/customerCreditService';

class CreditResultList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            custumerCreditList: []
        };
    }
    componentDidMount() {
        if (this.props.customerId != null) {
            let customerCreditService = new CustomerCreditService();
            customerCreditService.getCustomeCreditsByCustomerId(this.props.customerId)
                .then(response => this.handleResponse(response.data))
                .catch(error => this.handleError(error?.response?.data));
        }
    }
    handleResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.setState({ custumerCreditList: response.data })
        } else {
            toast.error(response.message);
        }
    }
    handleError(response) {
        let message = "";
        response?.message ?
            message = response.message :
            message = "Hata, Bir Sorun Oluştu Lütfen Daha Sonra Deneyiniz";
        toast.error(message);
    }
    currencyFormat(num) {
        return num.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,') + ' ₺'
    }
    render() {
        return <div>
            <div className="spacer" id="forms-component">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="4" className="text-center">
                            <h1 className="title font-bold">Kredi Başvuruları</h1>
                        </Col>
                    </Row>
                </Container>
                <Container>
                    <Row>
                        <Col md="12">
                            <div className="table-responsive">
                                <Table>
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Sonuç Açıklaması</th>
                                            <th>Kredi Tutarı</th>
                                            <th>Kredi Türü</th>
                                            <th>Kredi Sonucu</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.custumerCreditList.map((custumerCredit, i) => (
                                            <tr key={custumerCredit.id}>
                                                <td>{i + 1}</td>
                                                <td>{custumerCredit.resultExplanation}</td>
                                                <td>{this.currencyFormat(custumerCredit.creditAmount)}</td>
                                                <td>{custumerCredit.crdCreditId}</td>
                                                <td><span
                                                    className={custumerCredit.creditResult === "CUSTOMER_APPROVED" || custumerCredit.creditResult === "SYSTEM_APPROVED" ?
                                                        "label label-success font-16" : "label label-danger font-16"}>
                                                    {
                                                        custumerCredit.creditResult === "CUSTOMER_DENIED" ?
                                                            "Krediyi Reddettiniz" :
                                                            custumerCredit.creditResult === "CUSTOMER_APPROVED" ?
                                                                "Krediyi Onayladınız" :
                                                                custumerCredit.creditResult === "SYSTEM_APPROVED" ?
                                                                    "Sistem Trafından Onaylandı" :
                                                                    "Sistem Trafından Reddedildi"
                                                    }
                                                </span> </td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </Table>
                            </div>
                        </Col>
                    </Row>
                </Container>
            </div>
        </div>;
    }
}
export default CreditResultList;