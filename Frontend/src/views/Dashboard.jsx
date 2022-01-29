import React from "react";
import PropTypes from "prop-types";
import HeaderBanner from "../components/banner/banner.jsx";
import { Container, Row, Col, Card, CardBody } from 'reactstrap';



const Dashboard = () => {
    return (<div>
        <HeaderBanner />
        <div className="spacer bg-light p-40">
            <Container>
                <Row className="justify-content-center">
                    <Col md="7" className="text-center">
                        <h1 className="title font-bold">Kullanılan Teknolojiler</h1>
                    </Col>
                </Row>
            </Container>
            <Container>
                <Row className="wrap-feature-20">
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Spring Boot</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Spring Data JPA</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Spring HATEOAS</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">MapStruct</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Loombak</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Validation</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Swagger</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">PostgreSQL</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>

                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Unit Test</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white"> Result Type</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Twilio Sms Send</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-success-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Mernis Check</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                        <Col md="12" className="m-b-20">
                            <hr/>
                        </Col>

                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-danger-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">React</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-danger-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Axios</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-danger-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Reactstrap</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-danger-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Formik</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-danger-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">Yup</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col lg="3">
                        <Card>
                            <CardBody className="btn linking bg-danger-gradiant">
                                <Row className="text-center" >
                                    <Col md="12">
                                        <h2 className="font-medium text-white">React Toastify</h2>
                                    </Col>
                                </Row>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </div>
    </div>
    );
}

Dashboard.propTypes = {
    classes: PropTypes.object
};

export default Dashboard;
