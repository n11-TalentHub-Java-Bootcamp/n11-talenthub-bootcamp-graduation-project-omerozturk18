import React from 'react';
import { Redirect } from 'react-router-dom';
import { toast } from 'react-toastify';
import { Button, Card, CardBody, Col, Container, Row } from 'reactstrap';
import { CustomerCreditService } from '../../services/customerCreditService';

class CreditResult extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            customerCredit: {},
            redirect: null
        };
    }
    componentDidMount() {
        let customerCreditService = new CustomerCreditService();
            customerCreditService.getCustomeCreditById(this.props.customerCreditId)
                .then(response => this.handleResponse(response.data))
                .catch(error => this.handleError(error?.response?.data));
    }
    handleResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.setState({ customerCredit: response.data })
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
    creditResponse(creditResult) {
        let customrResponse = {};
        customrResponse.id=this.state.customerCredit.id;
        customrResponse.creditResult = creditResult;
        customrResponse.crdCreditId = this.props.creditId;
        customrResponse.csrCustomerId = this.props.customerId;
        let customerCreditService = new CustomerCreditService();
        customerCreditService.customerCreditResponse(customrResponse)
            .then(response => this.handleResponse(response.data))
            .catch(error => this.handleError(error?.response?.data));
        this.setState({redirect:"/"})
    }

    render() {
        if (this.state.redirect) {
            return <Redirect to={this.state.redirect} />   }
        return <div>
            <div className="spacer" id="forms-component">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="4" className="text-center">
                            <h1 className="title font-bold">Kredi Sonucu</h1>
                        </Col>
                    </Row>
                </Container>
                <Container className="m-t-40">
                    <Row className="justify-content-center">
                        <Col lg="8" md="7">
                            <Card className="card-shadow">
                                <CardBody>
                                    <div className="p-20">
                                        <span className="label label-info  font-20">Kredi Başvurunuz Sonuçlandı</span>
                                        {this.state.customerCredit.creditResult === "SYSTEM_APPROVED" ?
                                            <>
                                                <h3 className="title ">Kredi İsteğiniz Sistem Tarafından Onayladı</h3>
                                                <p>{this.state.customerCredit.resultExplanation} Ayrıca Onay Smsi Alacaksınız, İsterseniz Kredi Cevabınızı Ordan da Verebilirsiniz.</p>
                                                <div className=' text-right'>
                                                    <span className="label label-success font-20">Onaylanan Kredi Tutarı: {this.currencyFormat(this.state.customerCredit.creditAmount)}</span>
                                                </div>
                                                <br></br>
                                                <Button className="btn btn-success btn-md btn-arrow m-t-20 m-r-20" onClick={() => this.creditResponse("CUSTOMER_APPROVED")}><span>Onayla <i className="ti-arrow-right"></i></span></Button>
                                                <Button className="btn btn-danger btn-md btn-arrow m-t-20" onClick={() => this.creditResponse("CUSTOMER_DENIED")} ><span>Reddet <i className="ti-arrow-right"></i></span></Button>
                                            </> :
                                            <>
                                                <h3 className="title">Kredi İsteğiniz Sistem Tarafından Reddedildi</h3>
                                                <p>{this.state.customerCredit.resultExplanation}</p>
                                                <Button className="btn btn-info btn-md btn-arrow m-t-20 m-r-20" href="/"><span>Anasayfaya Dön <i className="ti-arrow-right"></i></span></Button>
                                            </>
                                        }
                                    </div>
                                </CardBody>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>
        </div>;
    }
}
export default CreditResult;