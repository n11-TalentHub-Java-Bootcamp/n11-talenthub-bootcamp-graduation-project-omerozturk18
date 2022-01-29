import React from 'react';
import { HashLink as Link } from 'react-router-hash-link';
import { Container, Row, Col } from 'reactstrap';

const HeaderBanner = () => {
    return (
        <div className="static-slider-head banner2">
            <Container>
                <Row className="justify-content-center">
                    <Col lg="8" md="6" className="align-self-center text-center">
                        <h1 className="title">N11 Bootcamp</h1>
                        <h4 className="subtitle font-light"> Bitirme Projesi</h4>
                        <Link to="/cv" className="btn btn-outline-light m-r-20 btn-md m-t-30 font-14">Özgeçmişimi Görmek İçin Tıklayınız</Link>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}

export default HeaderBanner;
