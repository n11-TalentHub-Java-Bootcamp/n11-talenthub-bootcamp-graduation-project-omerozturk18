/* eslint-disable */
import React from 'react';
import { Container, Row, Col } from 'reactstrap';

const Footer = () => {
    return (
        <div className="footer4 b-t spacer">
            <Container>
                <Row>
                    <Col lg="3" md="6" className="m-b-30">
                        <h5 className="m-b-20">Adres</h5>
                        <p>Keçiören, Ankaraa</p>
                    </Col>
                    <Col lg="3" md="6" className="m-b-30">
                        <h5 className="m-b-20">Telefon</h5>
                       
                    </Col>
                    <Col lg="3" md="6" className="m-b-30">
                        <h5 className="m-b-20">Email</h5>
                        <p>  <a href="mailto:omer_ozturk1997@hotmail.com" className="link">omer_ozturk1997@hotmail.com</a> <br /></p>
                    </Col>
                    <Col lg="3" md="6">
                        <h5 className="m-b-20">Sosyal Medya</h5>
                        <div className="round-social light">
                            <a href="https://www.linkedin.com/in/omerozturk18" target="_blank" className="link"><i className="fa fa-linkedin"></i></a>
                            <a href="https://github.com/omerozturk18" target="_blank" className="link"><i className="fa fa-github"></i></a>
                            <a href="https://twitter.com/_Omer_Ozturk_" target="_blank" className="link"><i className="fa fa-twitter"></i></a>
                            <a href="https://www.instagram.com/omerozturk__/" target="_blank" className="link"><i className="fa fa-instagram"></i></a>
                        </div>
                    </Col>
                </Row>
                <div className="f4-bottom-bar">
                    <Row>
                        <Col md="12">
                            <div className="d-flex font-14">
                                <div className="m-t-10 m-b-10 copyright">All Rights Reserved by Ömer Öztürk</div>
                            </div>
                        </Col>
                    </Row>
                </div>
            </Container>
        </div>
    );
}
export default Footer;
