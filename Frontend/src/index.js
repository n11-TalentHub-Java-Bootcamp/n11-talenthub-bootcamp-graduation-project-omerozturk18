import React from "react";
import ReactDOM from "react-dom";
import './assets/scss/style.scss';
import 'react-toastify/dist/ReactToastify.css';
import App from "./App";
import { BrowserRouter } from "react-router-dom/cjs/react-router-dom.min";
import { ToastContainer } from 'react-toastify';


ReactDOM.render(
  <BrowserRouter>
    <React.StrictMode>
      <ToastContainer
        position="top-right"
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        theme="colored"
        pauseOnFocusLoss
        draggable
        pauseOnHover />

      <App />
    </React.StrictMode>
  </BrowserRouter>
  ,
  document.getElementById("root")
);
