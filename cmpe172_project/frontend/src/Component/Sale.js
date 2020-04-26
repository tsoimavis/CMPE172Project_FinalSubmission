import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import Avatar from "@material-ui/core/Avatar";
import GroupIcon from "@material-ui/icons/Group";
import { Link } from "react-router-dom";
import Typography from "@material-ui/core/Typography";
import CircularProgress from "@material-ui/core/CircularProgress";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import Button from "@material-ui/core/Button";
import MUIDataTable from "mui-datatables";
import "bootstrap/dist/css/bootstrap.css";
import { createMuiTheme, MuiThemeProvider } from "@material-ui/core/styles";

const useStyles = makeStyles(theme => ({
  table: {
    minWidth: 600
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  paper: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    margin: `10px`,
    height: "100%",
    width: "99%",
    marginTop: theme.spacing(7)
  },
  link: {
    color: "rgba(0,0,0,0.65)",
    textDecoration: "none",
    marginLeft: "10%",
    alignSelf: "flex-start",
    "&:hover": {
      color: "rgba(0,0,0,1)"
    }
  }
}));

export default function SimpleTable() {

  const classes = useStyles();

  const [data, upDateData] = React.useState([]);
  const [firstLoad, setLoad] = React.useState(true);
  let isLoading = true;

  async function sampleFunc() {
    let response = await fetch("/api/sale");
    let body = await response.json();
    upDateData(body);
  }

  if (firstLoad) {
    sampleFunc();
    setLoad(false);
  }

  if (data.length > 0) isLoading = false;

  console.log(JSON.stringify(data));

  const columns = [
    {
      name: "sale_ID",
      label: "Sale ID",
      options: {
        filterType: "multiselect",
        responsive: "scroll",
        filter: true,
        sort: true
      }
    },
    {
      name: "product.product_ID",
      label: "Product ID",
      options: {
        filterType: "multiselect",
        responsive: "scroll",
        filter: true,
        sort: true
      }
    },
    {
      name: "customer.cus_ID",
      label: "Customer ID",
      options: {
        filterType: "multiselect",
        responsive: "scroll",
        filter: true,
        sort: true
      }
    },
    {
      name: "quantity",
      label: "Quantity",
      options: {
        filterType: "multiselect",
        responsive: "scroll",
        filter: true,
        sort: true
      }
    },
    {
      name: "time",
      label: "Time",
      options: {
        filterType: "multiselect",
        responsive: "scroll",
        filter: true,
        sort: true
      }
    }
  ];


  const options = {
    filterType: "checkbox"
  };

  return (

    <div className="container">
      
      <MUIDataTable
        title={"Sales List"}
        data={data}
        columns={columns}
        options={options}
      />
    </div>
  );
  
}
