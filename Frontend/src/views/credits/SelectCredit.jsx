import React from 'react';
import { Row, Col, Container, Card, CardBody, Button } from 'reactstrap';
import { CreditService } from '../../services/creditService';
import { toast } from 'react-toastify';
import { CustomerCreditService } from '../../services/customerCreditService';

import img1 from '../../assets/images/credit.png';


class SelectCredit extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            creditList: [],
        };
        this.handleOnClick = this.handleOnClick.bind(this);
    }
    componentDidMount() {
        this.getCreditList();
    }
    getCreditList() {
        let creditService = new CreditService();
        creditService.getAllCreditList()
            .then(response => this.handleResponse(response.data))
            .catch(error => this.handleError(error?.response?.data));
    }

    handleOnClick = (credit) => {
        let customerCreditService = new CustomerCreditService();
        customerCreditService.addCustomeCredit({ crdCreditId:credit.id, csrCustomerId: this.props.customerId })
                .then(response => this.handleAddCustomeCreditResponse(response.data))
                .catch(error => this.handleError(error?.response?.data));
    }

    handleResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.setState({ creditList: response.data })
        } else {
            toast.error(response.message);
        }
    }
    handleAddCustomeCreditResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.props.customerCredit(response.data);
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

    render() {
        return <div>
            <div className="spacer" id="forms-component">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="4" className="text-center">
                            <h1 className="title font-bold">Kredi Seçiniz</h1>
                            <h6 className="subtitle">Almak İstediğiniz Kredi Türünü Seçiniz</h6>
                        </Col>
                    </Row>
                </Container>

                <Container>
                    <Row className="m-t-40">
                        {this.state.creditList.map((credit, i) => (
                            <Col md="4" key={credit.id}>
                                <Button className="img-ho" onClick={() => this.handleOnClick(credit)}><img className="card-img-top" src={img1} alt="wrappixel kit" /></Button>
                                <Card className="card-shadow">
                                    <CardBody>
                                        <h5 className="font-medium m-b-0">{credit.name}</h5>
                                        <p className="m-b-0 font-14">{credit.explanation}</p>
                                    </CardBody>
                                </Card>
                            </Col>
                        ))}
                    </Row>
                </Container>
            </div>
        </div>;
    }
}
export default SelectCredit;
