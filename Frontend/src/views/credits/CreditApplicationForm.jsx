import React from 'react';
import { Button, Col, Container, FormGroup, Row } from 'reactstrap';
import N11TextInput from '../../utils/N11TextInput';
import * as Yup from 'yup';
import { Form, Formik } from 'formik';
import { toast } from 'react-toastify';
import { CustomerCreditService } from '../../services/customerCreditService';

class CreditApplicationForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            creditResult: {}
        };

        this.handleSubmit = this.handleSubmit.bind(this);
    }
    validationSchema() {
        return Yup.object({
            identityNumber: Yup.number()
                .required("TC Kimlik No Zorunludur")
                .typeError("TC Kimlik No Sayı Olmalıdır")
                .positive("TC Kimlik No Pozitif Sayı Olmalıdır")
                .test('len', 'TC Kimlik No 11 Karakter Olmalıdır', val => val?.toString().length === 11)
            ,
            dateOfBirth: Yup.date().required('Doğum Tarihi Zorunludur'),
        });
    }
    initialValues() {
        return {
            identityNumber: this.state.creditResult.identityNumber,
            dateOfBirth: this.state.creditResult.birthDate,
        };
    }
    handleSubmit(event) {
        let customerCreditService = new CustomerCreditService()
        if (this.props.resultType === "0") {
            customerCreditService.getCustomerCreditsResultBySystemApproved(event.identityNumber, event.dateOfBirth)
                .then(response => this.handleResponse(response.data))
                .catch(error => this.handleError(error?.response?.data));
        } else {
            customerCreditService.getCustomerCreditsResults(event.identityNumber, event.dateOfBirth)
                .then(response => this.handleResponse(response.data))
                .catch(error => this.handleError(error?.response?.data));
        }

    }
    handleResponse(response) {
        if (response.success) {
            this.props.resultType === "0" ?
                this.props.creditResult(response.data) :
                this.props.creditResult(response.data[response.data.length-1]);
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
            <Container>
                <Row className="justify-content-center">
                    <Col md="4" className="text-center">
                        <h1 className="title font-bold">Kredi Başvurusu Sorgula</h1>
                    </Col>
                </Row>
            </Container>
            <Container>
                <Row>
                    <Col md="12">
                        <Formik
                            initialValues={this.initialValues}
                            validationSchema={this.validationSchema}
                            onSubmit={(values) => { this.handleSubmit(values) }}>
                            <Form className="row">
                                <FormGroup className="col-md-6">
                                    <N11TextInput type="text" name="identityNumber" id="identityNumber" placeholder='TC Kimlik No' />
                                </FormGroup>
                                <FormGroup className="col-md-6">
                                    <N11TextInput type="date" name="dateOfBirth" id="dateOfBirth" placeholder='Doğum Tarihi' />
                                </FormGroup>
                                <Col md="12 text-right">
                                    <Button type="submit" className="btn btn-success waves-effect waves-light m-r-10">Sorgula</Button>
                                </Col>
                            </Form>
                        </Formik>
                    </Col>
                </Row>
            </Container>
        </div>;
    }
}

export default CreditApplicationForm