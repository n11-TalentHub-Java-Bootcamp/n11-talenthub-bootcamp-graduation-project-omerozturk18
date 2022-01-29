import React from 'react';
import { Button, Card, CardBody, Col, Container, Row } from 'reactstrap';
import userImage from '../../assets/images/cv/user.jpg';
import htmlImge from "../../assets/images/cv/html.svg";
import cssImge from "../../assets/images/cv/css.svg";
import bootstrapImge from "../../assets/images/cv/bootstrap.svg";
import jsImge from "../../assets/images/cv/js.svg";
import tsImge from "../../assets/images/cv/ts.svg";
import angularImge from "../../assets/images/cv/angular.svg";
import reactImge from "../../assets/images/cv/react.webp";
import sqlImge from "../../assets/images/cv/sql.svg";
import netcoreImge from "../../assets/images/cv/netcore.png";
import springImge from "../../assets/images/cv/spring.svg";

class Cv extends React.Component {

    render() {
        return <div>
            <div className="static-slider10 p-b-30">
                <Container>
                    <Row className="justify-content-center">
                        <Col lg="8" md="6" className="text-center m-b-10">
                            <img src={userImage} alt="img" className="img-circle" width="290" />
                            <h1 className="title">Ömer Öztürk</h1>
                            <span className="label label-rounded label-inverse ">Full Stack Developer</span>
                            <h6 className="subtitle op-8 text-white">
                                Merhaba ben Ömer,<br></br>
                                Düzce Üniversitesi Yönetim Bilişim Sistemleri mezunuyum. 02/2020-01/2021
                                Tarihleri arasında askerlik görevimi yaptım. 03/2021 Tarihinden itibaren Tabim Bilişim’de
                                Yazılım Geliştirici olarak çalışmaktayım.
                            </h6>
                        </Col>
                        <Col lg="8" md="6" className="text-center m-t-20">
                            <div className="round-social light p-t-10">
                                <a href="https://www.linkedin.com/in/omerozturk18" target="_blank" className="link"><i className="fa fa-linkedin"></i></a>
                                <a href="https://github.com/omerozturk18" target="_blank" className="link"><i className="fa fa-github"></i></a>
                                <a href="https://twitter.com/_Omer_Ozturk_" target="_blank" className="link"><i className="fa fa-twitter"></i></a>
                                <a href="https://www.instagram.com/omerozturk__/" target="_blank" className="link"><i className="fa fa-instagram"></i></a>
                            </div>
                        </Col>
                    </Row>
                </Container>

            </div>
            <div className="spacer bg-light p-40">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="7" className="text-center">
                            <h1 className="title font-bold">İş Deneyimi</h1>
                        </Col>
                    </Row>
                </Container>
            </div>
            <Container className="m-t-20">
                <Row className="m-t-40">
                    <Col md="4" className="ml-auto pricing-box align-self-top p-b-30">
                        <Card className="b-all h-100">
                            <Button className="btn btn-info-gradiant p-15 btn-arrow btn-block">Mikro Beta Yazılım</Button>
                            <CardBody className="p-30 p-t-15 text-center">
                                <h4>Yazılım Geliştirme Stajyeri</h4>
                                <h6 className="font-light font-14">09/2014 - 06/2015</h6>
                                <p className="m-t-40">
                                    <ul>
                                        <li>Uygulama Geliştirme kullanıcı el kitabının hazırlanmasına, proje uygulamasına ve kullanıma yardımcı olundu.</li>
                                        <li>İş birimlerinin uygulaması için kullanıcı kılavuzunu hazırlanması.</li>
                                        <li>Dökümantasyon takibi.</li>
                                    </ul>
                                </p>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col md="4" className="ml-auto pricing-box align-self-top p-b-30">
                        <Card className="b-all h-100">
                            <Button className="btn btn-danger-gradiant p-15 btn-arrow btn-block">Sistaş Sayısal İletişim San. ve Tic. A.Ş.</Button>
                            <CardBody className="p-30 p-t-15 text-center">
                                <h4>Yazılım Geliştirme Stajyeri</h4>
                                <h6 className="font-light font-14">01/2019 - 05/2019</h6>
                                <p className="m-t-40">
                                    <ul>
                                        <li>Kullanıcı arayüzü geliştirme.</li>
                                        <li>Projenin teslim edilmeden önce kontrollü, gerçek durumlarda testlerin yapılması.</li>
                                        <li>Sistem iyileştirmeleri için mevcut sistemin test edilmesi ve raporlanması</li>
                                        <li>Test senaryolarının hazırlanması ve yürütülmesi.</li>
                                        <li>Ürünlerin önyüz testlerinin yapılması ve uygun test senaryolarının yazılması.</li>
                                        <li>Projenin güncellenen bölümlerinin döküman ve raporlarında değiştirilmesi.</li>
                                    </ul>
                                </p>
                            </CardBody>
                        </Card>
                    </Col>
                    <Col md="4" className="ml-auto pricing-box align-self-top p-b-30">
                        <Card className="b-all h-100">
                            <Button className="btn btn-success-gradiant p-15 btn-arrow btn-block">Tabim Bilişim</Button>
                            <CardBody className="p-30 p-t-15 text-center">
                                <h4>Full Stack Developer</h4>
                                <h6 className="font-light font-14">03/2021 - <i className='text-danger'>Devam Ediyor</i> </h6>
                                <p className="m-t-40">
                                    <ul>
                                        <li>Backend .Net Core,</li>
                                        <li>Frontend Angular,</li>
                                        <li>Proje Bazında Asp.Net Mvc ve Php</li>
                                        <li>Projerlerin Takibi ve İstenilen Yeniliklerin Yapılması</li>
                                        <li>Version Güncellemerin Yapılması</li>
                                        <li>Eski Projelerin Güncel Teknolojilere Göre Revize Edilmesi</li>
                                    </ul>
                                </p>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>
            <div className="spacer bg-light p-40">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="7" className="text-center">
                            <h1 className="title font-bold">Beceriler</h1>
                        </Col>
                    </Row>
                </Container>
                <Container>
                    <Row className="wrap-feature-20">
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={htmlImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-success-gradiant">
                                            <h1 className="font-medium text-white"> 9/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={cssImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-danger-gradiant">
                                            <h1 className="font-medium text-white"> 7/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={bootstrapImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-warning">
                                            <h1 className="font-medium text-white"> 8/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={sqlImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-info-gradiant">
                                            <h1 className="font-medium text-white"> 7/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={jsImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-secondary">
                                            <h1 className="font-medium text-white"> 7/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={tsImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-info">
                                            <h1 className="font-medium text-white"> 8/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={angularImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-success">
                                            <h1 className="font-medium text-white"> 8/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={reactImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-danger">
                                            <h1 className="font-medium text-white"> 6/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={netcoreImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-orange-gradiant">
                                            <h1 className="font-medium text-white"> 7/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                        <Col lg="3">
                            <Card>
                                <Row>
                                    <Col md="6">
                                        <CardBody className="d-flex no-block">
                                            <div className="m-r-20"><img src={springImge} width="70" alt="img" /></div>
                                        </CardBody>
                                    </Col>
                                    <Col md="6" className="text-center">
                                        <a className="btn text-white linking bg-successwarning-gradiant">
                                            <h1 className="font-medium text-white"> 7/10</h1> 
                                        </a>
                                    </Col>
                                </Row>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>
            <div className="spacer">
                <Container>
                    <Row className="justify-content-center">
                        <Col md="7" className="text-center">
                            <h1 className="title font-bold">Kendimi Geliştirmek İçin Yaptığım Projeler</h1>
                        </Col>
                    </Row>
                </Container>
                <hr></hr>
                <Container>
                    <Row >
                        <Col md="3" className="wrap-feature4-box">
                            <Card className="h-100">
                                <CardBody>
                                    <div className="icon-round bg-light-info"><i className="fa fa-check-circle"></i></div>
                                    <h5 className="font-medium">Asp.Net Mvc Projesi</h5>
                                    <p className="m-t-20">E-Sözlük</p>
                                </CardBody>
                                <a href="https://github.com/omerozturk18/MvcProject" target="_blank" className="linking text-themecolor">Göremk İçin Tıklayınız<i className="ti-arrow-right"></i></a>
                            </Card>
                        </Col>
                        <Col md="3" className="wrap-feature4-box">
                            <Card className="h-100">
                                <CardBody>
                                    <div className="icon-round bg-light-info"><i className="fa fa-check-circle"></i></div>
                                    <h5 className="font-medium">Net Core + Angular Projesi </h5>
                                    <p className="m-t-20">Araç Kiralama Projesi</p>
                                </CardBody>
                                <a href="https://github.com/omerozturk18/ReCapProject" target="_blank" className="linking text-themecolor">Görmek İçin Tıklayınız<i className="ti-arrow-right"></i></a>
                            </Card>
                        </Col>
                        <Col md="3" className="wrap-feature4-box">
                            <Card className=" h-100">
                                <CardBody>
                                    <div className="icon-round bg-light-info"><i className="fa fa-check-circle"></i></div>
                                    <h5 className="font-medium">Net Core + Angular Projesi </h5>
                                    <p className="m-t-20">Kahoot Benzeri Quiz Projesi</p>
                                </CardBody>
                                <a href="https://github.com/omerozturk18/QuizProject" target="_blank" className="linking text-themecolor">Görmek İçin Tıklayınız<i className="ti-arrow-right"></i></a>
                            </Card>
                        </Col>
                        <Col md="3" className="wrap-feature4-box">
                            <Card className=" h-100">
                                <CardBody>
                                    <div className="icon-round bg-light-info"><i className="fa fa-star"></i></div>
                                    <h5 className="font-medium">Java + React Projesi</h5>
                                    <p className="m-t-20">İnsan Kaynaları Sistemi</p>
                                </CardBody>
                                <a href="https://github.com/omerozturk18/HumanResourceManagementSystem" target="_blank" className="linking text-themecolor">Görmek İçin Tıklayınız<i className="ti-arrow-right"></i></a>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>

        </div>;
    }
}
export default Cv;