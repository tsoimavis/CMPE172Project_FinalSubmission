import React from "react";
import ReactDOM from "react-dom";
import {
  withStyles,
  MuiThemeProvider,
  createMuiTheme
} from "@material-ui/core/styles";
import { makeStyles } from "@material-ui/core/styles";
import Avatar from "@material-ui/core/Avatar";
import Card from "@material-ui/core/Card";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import Divider from "@material-ui/core/Divider";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
//import "./styles.css";
import min from "./img/min.jpg";
import max from "./img/max.jpg";
import maxitem from "./img/maxitem.jpg";
import minitem from "./img/minitem.jpg";
import user from "./img/user.jpg";
import avg from "./img/avg.jpg";

const muiBaseTheme = createMuiTheme();
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

const theme = {
  overrides: {
    MuiCard: {
      root: {
        "&.MuiEngagementCard--01": {
          transition: "0.3s",
          minWidth: 300,
          minHeight: 310,
          margin: "auto",
          boxShadow: "0 8px 40px -12px rgba(0,0,0,0.3)",
          "&:hover": {
            boxShadow: "0 16px 70px -12.125px rgba(0,0,0,0.3)"
          },
          "& .MuiCardMedia-root": {
            paddingTop: "56.25%"
          },
          "& .MuiCardContent-root": {
            textAlign: "left",
            padding: muiBaseTheme.spacing.unit * 3
          },
          "& .MuiDivider-root": {
            margin: `${muiBaseTheme.spacing.unit * 3}px 0`
          },
          "& .MuiTypography--heading": {
            fontWeight: "bold"
          },
          "& .MuiTypography--subheading": {
            lineHeight: 1.8
          },
          "& .MuiAvatar-root": {
            display: "inline-block",
            border: "2px solid white",
            "&:not(:first-of-type)": {
              marginLeft: -muiBaseTheme.spacing.unit
            }
          }
        }
      }
    }
  }
};

export default function OutlinedCard() {
  const classes = useStyles();

  
   const [data, upDateData] = React.useState([]);
   const [data1, upDateData1] = React.useState([]);
   const [data2, upDateData2] = React.useState([]);
   const [data3, upDateData3] = React.useState([]);
   const [firstLoad, setLoad] = React.useState(true);
   let isLoading = true;
  
   async function sampleFunc() {
     let response = await fetch("/api/analytics");
     let body = await response.json();
     upDateData(body);
     upDateData1(body[3].split(","));
     upDateData2(body[4].split(","));
     upDateData3(body[7].split(","));

   }
 
   if (firstLoad) {
     sampleFunc();
     setLoad(false);
   }
 


  return (
    <div style={{ marginTop: 20, padding: 30 }}>
      <Grid container spacing={8} justify="center">
        <MuiThemeProvider theme={createMuiTheme(theme)}>


          <Grid item key={1}>
            <div className="App">

              <Card className={"MuiEngagementCard--01"}>
                <CardMedia
                  className={"MuiCardMedia-root"}
                  image={
                    maxitem
                  }
                />
                <CardContent className={"MuiCardContent-root"}>
                  <Typography
                    className={"MuiTypography--heading"}
                    variant={"h6"}
                    gutterBottom
                  >
                    Most Selling Item
          </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                    Product name: {data1[0]}
                  </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                    <br/>Sales Unit: {data1[1]}
                  </Typography>

                </CardContent>
              </Card>

            </div>
          </Grid>
          <Grid item key={2}>
            
            <div className="App">
            <MuiThemeProvider theme={createMuiTheme(theme)}>

              <Card className={"MuiEngagementCard--01"}>
                <CardMedia
                  className={"MuiCardMedia-root"}
                  image={
                    minitem
                  }
                />
                <CardContent className={"MuiCardContent-root"}>
                  <Typography
                    className={"MuiTypography--heading"}
                    variant={"h6"}
                    gutterBottom
                  >
                    Least Selling Item
          </Typography>
          <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                    Product name: {data2[0]}
                  </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                    <br/>Sales Unit: {data2[1]}
                  </Typography>

                </CardContent>
              </Card>
              </MuiThemeProvider>
            </div>
          </Grid>
          <Grid item key={3}>
            <div className="App">
              <Card className={"MuiEngagementCard--01"}>
                <CardMedia
                  className={"MuiCardMedia-root"}
                  image={
                    user
                  }
                />
                <CardContent className={"MuiCardContent-root"}>
                  <Typography
                    className={"MuiTypography--heading"}
                    variant={"h6"}
                    gutterBottom
                  >
                    Highest sales Customer
          </Typography>
          <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                    Customer name: {data3[0]}
                  </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                    <br/>total Sales: $ {data3[1]}
                  </Typography>

                </CardContent>
              </Card>
            </div>
          </Grid>
        </MuiThemeProvider>
      </Grid>

      <Grid container spacing={8} justify="center">
        <MuiThemeProvider theme={createMuiTheme(theme)}>
          <Grid item key={4}>
            <div className="App">
              <Card className={"MuiEngagementCard--01"}>
                <CardMedia
                  className={"MuiCardMedia-root"}
                  image={
                    max
                  }
                />
                <CardContent className={"MuiCardContent-root"}>
                  <Typography
                    className={"MuiTypography--heading"}
                    variant={"h6"}
                    gutterBottom
                  >
                    Highest price of product
          </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                   $ {data[2]}
                  </Typography>

                </CardContent>
              </Card>
            </div>
          </Grid>
          <Grid item key={5}>
            <div className="App">
              <Card className={"MuiEngagementCard--01"}>
                <CardMedia
                  className={"MuiCardMedia-root"}
                  image={
                    min
                  }
                />
                <CardContent className={"MuiCardContent-root"}>
                  <Typography
                    className={"MuiTypography--heading"}
                    variant={"h6"}
                    gutterBottom
                  >
                    Lowest price of product
          </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                  $  {data[0]}
                  </Typography>

                </CardContent>
              </Card>
            </div>
          </Grid>
          <Grid item key={6}>
            <div className="App">
              <Card className={"MuiEngagementCard--01"}>
                <CardMedia
                  className={"MuiCardMedia-root"}
                  image={
                    avg
                  }
                />
                <CardContent className={"MuiCardContent-root"}>
                  <Typography
                    className={"MuiTypography--heading"}
                    variant={"h6"}
                    gutterBottom
                  >
                    Average price of product
          </Typography>
                  <Typography
                    className={"MuiTypography--subheading"}
                    variant={"h8"}
                  >
                   $ {data[1]}
                  </Typography>

                </CardContent>
              </Card>
            </div>
          </Grid>
        </MuiThemeProvider>
      </Grid>
    </div>
    
  );
}


