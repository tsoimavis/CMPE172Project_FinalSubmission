import React from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import GroupIcon from "@material-ui/icons/Group";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import ButtonGroup from '@material-ui/core/ButtonGroup';

const useStyles = makeStyles(theme => ({
  paper: {
    marginTop: theme.spacing(7),
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(3)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: "100%"
  }
}));

export default function AddProduct() {
  const classes = useStyles();
  const [firstLoad, setLoad] = React.useState(true);

  //const [selectedDate, setSelectedDate] = React.useState(
   // new Date("1998-04-02T21:11:54")
 // );
  const [cus_ID, setCus_ID] = React.useState("");
  const [product_ID, setProduct_ID] = React.useState("");
  const [quantity, setQuantity] = React.useState("");
  const [time, setTime] = React.useState("");

  //const handleDateChange = date => setSelectedDate(date);
  const handleCus_IDChange = event => setCus_ID(event.target.value);
  const handleProduct_IDChange = event => setProduct_ID(event.target.value);
  const handleQuantityChange = event => setQuantity(event.target.value);
  const handleTimeChange = event => setTime(event.target.value);

  const [message, setMessage] = React.useState("Nothing saved in the session");

  async function sampleFunc(toInput) {
    const response = await fetch("/api/sale", {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      mode: "cors", // no-cors, *cors, same-origin
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json"
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: "follow", // manual, *follow, error
      referrerPolicy: "no-referrer", // no-referrer, *client
      body: JSON.stringify(toInput) // body data type must match "Content-Type" header
    });
    let body = await response.json();
    console.log(body.sale_ID);
    setMessage(body.sale_ID ? "Data sucessfully updated" : "Data updation failed");
  }

  const handleSubmit = variables => {
    const toInput = { "customer": {cus_ID}, "product":{product_ID},quantity, time };
   
    sampleFunc(toInput);
    setCus_ID("");
    setProduct_ID("");
    setQuantity("");
    setTime("");
  };

  if (firstLoad) {
    // sampleFunc();
    setLoad(false);
  }

  return (
    <Container component="main" maxWidth="sm">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <GroupIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Add Sales
        </Typography>
        <form className={classes.form} noValidate>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="cus_ID"
                value={cus_ID}
                label="Customer ID"
                name="cus_ID"
                autoComplete="cus_ID"
                onChange={handleCus_IDChange}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="product_ID"
                name="product_ID"
                variant="outlined"
                required
                fullWidth
                value={product_ID}
                id="product_ID"
                label="Product ID"
                onChange={handleProduct_IDChange}
              />
              
            </Grid>
            
            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="quantity"
                value={quantity}
                label="quantity"
                name="quantity"
                autoComplete="Quantity"
                onChange={handleQuantityChange}
              />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="time"
                value={time}
                label="Time"
                name="time"
                autoComplete="time"
                onChange={handleTimeChange}
              />
            </Grid>
            {/*
            <Grid item xs={12}>
              <TextField
                id="date"
                label="Date of birth"
                type="date"
                defaultValue="1998-04-02"
                className={classes.textField}
                InputLabelProps={{
                  shrink: true
                }}
                onChange={handleDateChange}
              />
            </Grid>
            */}
          </Grid>
          <Button
            // type="submit"
            fullWidth
            variant="contained"
            color="primary"
            preventDefault
            className={classes.submit}
            onClick={handleSubmit}
          >
            Save
          </Button>

          <Grid container justify="center">
            <Grid item>
              <Link to="/sale">View Sales Records</Link>
            </Grid>
          </Grid>
        </form>
        <Typography style={{ margin: 7 }} variant="body1">
          Status: {message}
        </Typography>
      </div>
    </Container>
  );
}