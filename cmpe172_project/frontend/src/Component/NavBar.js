import React from "react";

import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";

class navbar extends React.Component {
  render() {
    return (
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
          172Project
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link active" href="/Home">
              Home <span class="sr-only">(current)</span>
            </a>
            <a class="nav-item nav-link active" href="/Sale">
              Sales 
            </a>
            <a class="nav-item nav-link active" href="/Customer">
              Customer
            </a>
            <a class="nav-item nav-link active" href="/Product">
              Product
            </a>
            <a class="nav-item nav-link active" href="/AddSale">
              Add Sales
            </a>
            <a class="nav-item nav-link active" href="/AddCustomer">
              Add Customer
            </a>
            <a class="nav-item nav-link active" href="/AddProduct">
              Add Product
            </a>
            <a class="nav-item nav-link active" href="/Analytics">
              Analytics
            </a>
          </div>
        </div>
      </nav>
    );
  }
}

export default navbar;
