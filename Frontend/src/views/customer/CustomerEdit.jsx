import React from 'react'
import { Container, Row, Col, FormGroup, Button } from 'reactstrap';
import { CustomerService } from '../../services/customerService';
import { Formik, Form } from 'formik';
import * as Yup from 'yup';
import N11TextInput from '../../utils/N11TextInput';
import { toast } from 'react-toastify';

class CustomerEdit extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            customer: {}
        };

        this.handleSubmit = this.handleSubmit.bind(this);
    }
    validationSchema() {
        return Yup.object({
            identityNumber: Yup.number()
                .required("TC Kimlik No Zorunludur")
                .typeError("TC Kimlik No Sayı Olmalıdır")
                .positive("TC Kimlik No Pozitif Sayı Olmalıdır")
                .test('len', 'TC Kimlik No 11 Karakter Olmalıdır', val => val?.toString().length === 11),
            firstName: Yup.string()
                .required("Ad Zorunludur"),
            lastName: Yup.string()
                .required("Soyad Zorunludur"),
            dateOfBirth: Yup.date()
                .required('Doğum Tarihi Zorunludur'),
            phoneNumber: Yup.number()
                .required('Telefon Numarası Zorunludur')
                .typeError("Telefon Numarası Sayı Olmalıdır")
                .positive("Telefon Numarası Pozitif Sayı Olmalıdır")
                .test('len', 'Telefon Numarası 10 Karakter Olmalıdır', val => val?.toString().length === 10),
            salary: Yup.number("Maaş Sayı Olmalıdır")
                .required("Maaş Zorunludur")
                .typeError("Maaş Sayı Olmalıdır")
                .positive("Maaş Pozitif Sayı Olmalıdır")
            ,
        });
    }
    initialValues() {
        return {
            identityNumber: this.state.customer.identityNumber,
            firstName: this.state.customer.firstName,
            lastName: this.state.customer.lastName,
            dateOfBirth: this.state.customer.birthDate,
            phoneNumber: this.state.customer.phoneNumber,
            salary: this.state.customer.salary
        };
    }
    handleSubmit(event) {
        let customerService = new CustomerService()
        customerService.addCustomer(event)
            .then(response => this.handleResponse(response.data))
            .catch(error => this.handleError(error?.response?.data));
    }

    handleResponse(response) {
        if (response.success) {
            toast.success(response.message);
            this.props.customer(response.data);
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
    render() {
        return (<div>
            <div className="spacer" id="forms-component">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="4" className="text-center">
                            <h1 className="title font-bold">Kredi Başvurusu</h1>
                            <h6 className="subtitle">Kredi Başvurusu İçin Lütfen Aşağıdaki Formu Doldurunuz</h6>
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
                                    <FormGroup className="col-md-12">
                                        <N11TextInput type="text" key={'identityNumber'} name="identityNumber" id="identityNumber" placeholder='TC Kimlik No' />
                                    </FormGroup>
                                    <FormGroup className="col-md-6">
                                        <N11TextInput type="text" key={'firstName'} name="firstName" id="firstName" placeholder='Ad' />
                                    </FormGroup>
                                    <FormGroup className="col-md-6">
                                        <N11TextInput type="text" key={'lastName'} name="lastName" id="lastName" placeholder='Soyad' />
                                    </FormGroup>
                                    <FormGroup className="col-md-6">
                                        <N11TextInput type="date" key={'dateOfBirth'} name="dateOfBirth" id="dateOfBirth" placeholder='Doğum Tarihi' />
                                    </FormGroup>
                                    <FormGroup className="col-md-6">
                                        <N11TextInput type="text" key={'phoneNumber'} name="phoneNumber" id="phoneNumber" placeholder='Telefon Numarası' />
                                    </FormGroup>
                                    <FormGroup className="col-md-6">
                                        <N11TextInput type="text" key={'salary'} name="salary" id="salary" placeholder='Maaş Giriniz' />
                                    </FormGroup>
                                    <Col md="12 text-right">
                                        <Button type="submit" className="btn btn-success waves-effect waves-light m-r-10">Devam Et</Button>
                                    </Col>
                                </Form>
                            </Formik>
                        </Col>

                    </Row>
                </Container>
            </div>
        </div>);

    }
}
export default CustomerEdit;