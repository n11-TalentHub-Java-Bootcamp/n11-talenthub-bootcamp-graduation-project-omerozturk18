import React from 'react';
import { Route, Switch } from 'react-router-dom';
import Footer from './components/footer/footer';
import Header from './components/header/header';
import CreditApply from './views/credits/CreditApply';
import InquireApplicationOfCredit from './views/credits/InquireApplicationOfCredit';
import Cv from './views/cv/Cv';
import Dashboard from './views/Dashboard';

function App() {
    return (
        

        <div className="App">
            <div id="main-wrapper">
                <Header />
                <div className="page-wrapper">
                    <div className="container-fluid">
                        <Switch>
                            <Route path="/credit-apply" component={CreditApply} />
                            <Route path="/inquire-application-of-credit/:resultType" component={InquireApplicationOfCredit} />
                            <Route path="/cv" component={Cv} />
                            <Route path="/" component={Dashboard} />
                        </Switch>
                    </div>
                </div>
                <Footer />
            </div>
        </div>
        
    );
}

export default App;

