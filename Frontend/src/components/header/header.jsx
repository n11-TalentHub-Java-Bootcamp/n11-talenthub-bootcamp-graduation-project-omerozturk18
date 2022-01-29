/* eslint-disable */
import React, { useState } from 'react';
import { HashLink as Link } from 'react-router-hash-link';
import { Container, NavbarBrand, Navbar, Nav, NavItem, NavbarToggler, Collapse, DropdownToggle, DropdownMenu, DropdownItem, Row, Col, ButtonGroup, UncontrolledButtonDropdown } from 'reactstrap';

import logo from '../../assets/images/logos/logo.svg';

const Header = () => {
    const [isOpen, setIsOpen] = useState(false);

    const toggle = () => setIsOpen(!isOpen);

    return (
        <div className="topbar" id="top">
            <div className="header6">
                <Container className="po-relative">
                    <Navbar className="navbar-expand-lg h6-nav-bar">
                        <NavbarBrand href="/"><img src={logo} alt="wrapkit" /></NavbarBrand>
                        <NavbarToggler onClick={toggle}><span className="ti-menu"></span></NavbarToggler>
                        <Collapse isOpen={isOpen} navbar className="hover-dropdown font-14 ml-auto" id="h6-info">
                            <Nav navbar className="ml-auto">
                                <NavItem>
                                    
                                </NavItem>
                                <NavItem>
                                    
                                </NavItem>
                            </Nav>
                            <div className="act-buttons m-r-10">
                                <Link to="/" className="btn btn-info font-14">Anasayfa</Link>
                            </div>
                            <ButtonGroup>
                                <UncontrolledButtonDropdown setActiveFromChild>
                                    <DropdownToggle tag="button" className="btn btn-danger-gradiant font-14" caret>
                                        Başvuru Sorgula
                                    </DropdownToggle>
                                    <DropdownMenu>
                                        <DropdownItem tag={Link} to="/inquire-application-of-credit/0">
                                            Onay Bekleyen
                                        </DropdownItem>
                                        <DropdownItem tag={Link} to="/inquire-application-of-credit/1">
                                            Tümü
                                        </DropdownItem>
                                    </DropdownMenu>
                                </UncontrolledButtonDropdown>
                            </ButtonGroup>
                            <div className="act-buttons">
                                <Link to="/credit-apply" className="btn btn-success-gradiant font-14">Krediye Başvur</Link>
                            </div>
                        </Collapse>
                    </Navbar>
                </Container>
            </div>
        </div>
    );

}
export default Header;
