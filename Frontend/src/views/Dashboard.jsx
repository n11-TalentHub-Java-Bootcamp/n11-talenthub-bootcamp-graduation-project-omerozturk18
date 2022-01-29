import React from "react";
import PropTypes from "prop-types";
import HeaderBanner from "../components/banner/banner.jsx";



const Dashboard = () => {
    return (<div>
        <HeaderBanner />
    </div>
    );
}

Dashboard.propTypes = {
    classes: PropTypes.object
};

export default Dashboard;
