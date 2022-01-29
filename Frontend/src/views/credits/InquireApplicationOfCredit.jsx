import React from 'react';
import CreditResult from './CreditResult';
import CreditApplicationForm from './CreditApplicationForm';
import CreditResultList from './CreditResultList';

class InquireApplicationOfCredit extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            creditResult: {},
            type:null
        };
        
    }
    callbackCreditResult = (childData) => {
        this.setState({ creditResult: childData });
      }
    render() {
        const { resultType } = this.props.match.params;
        if (this.state.type !== resultType) {
            this.setState({ creditResult: {},type:resultType });
        } 

        return <div>
            <div className="spacer" id="forms-component">
                {
                    this.state.creditResult.id == null || !this.state.creditResult.lenght<1 || this.state.type !== resultType?
                        <>
                            <CreditApplicationForm creditResult={this.callbackCreditResult} resultType={resultType} />
                        </> :
                        <>
                            {resultType === "0" ?
                                <>
                                    <CreditResult customerCreditId={this.state.creditResult.id} />
                                </> :
                                <>
                                <CreditResultList customerId={this.state.creditResult.csrCustomerId} />
                                </>
                            }

                        </>
                }

            </div>
        </div>;
    }

}
export default InquireApplicationOfCredit;