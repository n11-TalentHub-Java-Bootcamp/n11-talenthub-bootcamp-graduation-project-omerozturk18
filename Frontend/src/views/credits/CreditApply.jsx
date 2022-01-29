import React from 'react'
import CustomerEdit from '../customer/CustomerEdit';
import CustomerGuarantee from '../customer/CustomerGuarantee';
import CreditResult from './CreditResult';
import SelectCredit from './SelectCredit';


class CreditApply extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      customer: {},
      customerCredit: {},
      creditApplyType: 0
    };
  }
  callbackCustomer = (childData) => {
    this.setState({ customer: childData, creditApplyType: 1 });
  }
  callbackGuarantee = () => {
    this.setState({ creditApplyType: 2 });
  }
  callbackCustomerCredit = (childData) => {
    this.setState({ customerCredit: childData, creditApplyType: 3 });
  }

  render() {
    return (<div>

      {
        this.state.creditApplyType === 0 ?
          <CustomerEdit customer={this.callbackCustomer} /> :
          this.state.creditApplyType === 1 ?
            <CustomerGuarantee customerId={this.state.customer.id} guarantee={this.callbackGuarantee} /> :
            this.state.creditApplyType === 2 ?
              <SelectCredit customerId={this.state.customer.id} customerCredit={this.callbackCustomerCredit} /> :
              <CreditResult customerCreditId={this.state.customerCredit.id} />
      }

    </div>);

  }
}
export default CreditApply;
