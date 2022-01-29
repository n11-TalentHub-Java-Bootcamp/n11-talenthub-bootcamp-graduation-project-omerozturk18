
import React from 'react'
import { Row, Col, FormGroup, Button, UncontrolledCollapse, Container, Table } from 'reactstrap';
import { Formik, Form } from 'formik';
import * as Yup from 'yup';
import N11TextInput from '../../utils/N11TextInput';
import N11SelectList from '../../utils/N11SelectList';
import { EnumGuaranteeType } from '../../models/EnumGuaranteeType';
import { CustomerGuaranteeService } from '../../services/customerGuaranteeService';
import { toast } from 'react-toastify';

class CustomerGuarantee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            guarantee: {},
            customerGuaranteeList: [],
            newRecord: false
        };

        this.setGuarantee = this.setGuarantee.bind(this);
    }
    validationSchema() {
        return Yup.object({
            guaranteeType: Yup.string()
                .required("Teminat Tipi Zorunludur"),
            explanation: Yup.string()
                .required("Teminat Açıklaması Zorunludur"),
            guaranteeAmount: Yup.number()
                .required("Teminat Tutarı Zorunludur")
                .typeError("Teminat Tutarı Sayı Olmalıdır")
                .positive("Teminat Tutarı Pozitif Sayı Olmalıdır")
            ,
        });
    }
    initialValues() {
        return {
            guaranteeType: this.state.guarantee.guaranteeType,
            firstName: this.state.guarantee.explanation,
            lastName: this.state.guarantee.guaranteeAmount,
        };
    }
    componentDidMount() {
        this.getCustomerGuaranteeList();
    }
    getCustomerGuaranteeList() {
        let customerGuaranteeService = new CustomerGuaranteeService();
        customerGuaranteeService.getCustomerByCustomerId(this.props.customerId)
            .then(response => this.handleCustomerGuaranteeResponse(response.data))
            .catch(error => this.handleError(error?.response?.data));
    }
    setGuarantee(item) {
        item.csrCustomerId = this.props.customerId;
        this.state.customerGuaranteeList.push(item);
        this.setState({ customerGuaranteeList: this.state.customerGuaranteeList, newRecord: true });
    }
    next = () => {
        if (this.state.newRecord) {
            let customerGuaranteeService = new CustomerGuaranteeService();
            customerGuaranteeService.addAllGuaranteeList(this.state.customerGuaranteeList)
                .then(response => this.handleResponse(response.data))
                .catch(error => this.handleError(error?.response?.data));
        } else {
            this.props.guarantee("");
        }
    }
    handleResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.props.guarantee("");
        } else {
            toast.error(response.message);
        }
    }
    handleCustomerGuaranteeResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.setState({ customerGuaranteeList: response.data });
        } else {
            toast.error(response.message);
        }
    }

    handleError(response) {
        let message = "";
        response.message ?
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
                            <h1 className="title font-bold">Teminat Ekle</h1>
                            <h6 className="subtitle">Kredi Başvurusu İçin Teminat Ekleyebilirsiniz. Bu Sizi Kredi Liminitizi Artırabilir.</h6>
                        </Col>
                    </Row>
                </Container>
                <Container>
                    <Button type="button" className="btn btn-warning" id="toggler"  >
                        Teminat Ekle
                    </Button>
                    <Button type="button" className="btn btn-success waves-effect waves-light m-l-10" onClick={this.next}> Devam Et </Button>
                    <UncontrolledCollapse toggler="#toggler">
                        <Formik
                            initialValues={this.initialValues}
                            validationSchema={this.validationSchema}
                            onSubmit={(values) => { this.setGuarantee(values) }}>
                            <Row>
                                <Col>
                                    <Form className="row m-t-20">
                                        <FormGroup className="col-md-4">
                                            <N11SelectList name="guaranteeType" id="guaranteeType" placeholder='Teminat Türü'
                                                options={EnumGuaranteeType} />
                                        </FormGroup>
                                        <FormGroup className="col-md-4">
                                            <N11TextInput type="text" key={'explanation'} name="explanation" id="explanation" placeholder='Teminat Açıklaması' />
                                        </FormGroup>
                                        <FormGroup className="col-md-3">
                                            <N11TextInput type="text" key={'guaranteeAmount'} name="guaranteeAmount" id="guaranteeAmount" placeholder='Tahmini Teminat Tutarı' />
                                        </FormGroup>
                                        <FormGroup className="col-md-1 m-t-30">
                                            <Button type="submit" className="btn btn-primary waves-effect waves-light m-r-10">Ekle</Button>
                                        </FormGroup>
                                    </Form>
                                </Col>
                            </Row>
                        </Formik>
                    </UncontrolledCollapse >
                </Container >
                {this.state.customerGuaranteeList.length > 0 ?
                    <Container className="m-t-20">
                        <Row>
                            <Col md="12">
                                <div className="table-responsive">
                                    <Table>
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Teminat Türü</th>
                                                <th>Teminat Açıklaması</th>
                                                <th>Tahmini Teminat Tutarı</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {this.state.customerGuaranteeList.map((customerGuarantee, i) => (
                                                <tr key={i}>
                                                    <td>{i + 1}</td>
                                                    <td>{EnumGuaranteeType[customerGuarantee.guaranteeType]}</td>
                                                    <td>{customerGuarantee.explanation}</td>
                                                    <td>{this.currencyFormat(Number(customerGuarantee.guaranteeAmount))}</td>
                                                </tr>
                                            ))}
                                        </tbody>
                                    </Table>
                                </div>
                            </Col>
                        </Row>
                    </Container> :
                    <></>
                }
            </div>
        </div >;
    }

}
export default CustomerGuarantee;