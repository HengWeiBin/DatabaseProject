import React, { useState } from "react";
import ReactDOM from 'react-dom';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "../Login.css";
import { makeStyles } from '@material-ui/core/styles';
import { connect } from 'react-redux';
import { addDiscount } from '../actions';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { Opacity } from "@material-ui/icons";

const useStyles = makeStyles((theme) => ({
    navButtons: {
      fontFamily: 'Bebas Neue',
      '&:hover': {
        color:'#c26d5c'
     },
    },
    table: {
      margin:'100px',
      minWidth: 650,
      width:'80%',
      opacity:'80%',
    },
  })); 



function AddDiscount(props) {
  const [code, setCode] = useState("");
  const [value, setValue] = useState("");
  const [name, setName] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");

  
  const classes = useStyles();
 
  function handleSubmit(event) {
    console.log(value);
    console.log(code);
    
    props.addDiscount(value,code,name,startDate,endDate);
    event.preventDefault();
    window.location.reload();

  }

  return (
    <div className="Login">
     
      <Form name="form">
        <h2>ADD DISCOUNT</h2><Form.Group size="lg" controlId="code">
          <Form.Label>Discount Code</Form.Label>
          <Form.Control
            type="text"
            value={code}
            onChange={(e) => setCode(e.target.value)}
            step="0.01"
          />
        </Form.Group>

        <Form.Group size="lg" controlId="value">
          <Form.Label>Discount Percentage</Form.Label>
          <Form.Control
            type="number"
            placeholder="(only number. example:0.8)"
            value={value}
            onChange={(e) => setValue(e.target.value)}
          />
        </Form.Group>

        <Form.Group size="lg" controlId="name">
          <Form.Label>Event Name</Form.Label>
          <Form.Control
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </Form.Group>

        <Form.Group size="lg" controlId="startDate">
          <Form.Label>Start Date</Form.Label>
          <Form.Control
            type="text"
            placeholder="(YYYY/MM/DD)"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
        </Form.Group>
        
        <Form.Group size="lg" controlId="endDate">
          <Form.Label>End Date</Form.Label>
          <Form.Control
            type="text"            
            placeholder="(YYYY/MM/DD)"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
          />
        </Form.Group>
        
        <Button className="LoginBtn" block size="lg" variant="outline-secondary" onClick={handleSubmit} value="Submit">
          ADD DISCOUNT
        </Button>
      </Form>



      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell align="left">Discount Code</TableCell>
              <TableCell align="left">Discount Percentage</TableCell>
              <TableCell align="left">Event Name</TableCell>
              <TableCell align="right">Start Date</TableCell>
              <TableCell align="right">End Date</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {console.log(props.sellerDiscountList)}
            {props.sellerDiscountList.map((discount,index) => (
              <TableRow align="left" key={index}>
                <TableCell align="left">{discount.code}</TableCell>
                <TableCell align="left">{discount.value}</TableCell>
                <TableCell align="left">{discount.discountName}</TableCell>
                <TableCell align="right">{discount.startDateString}</TableCell>
                <TableCell align="right">{discount.endDateString}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

    </div>
  );
}


function mapStateToProps(state) {
  return {
    sellerDiscountList: state.sellerDiscountList
  }
}

function mapDispatchToProps(dispatch) {
  return {
    addDiscount: (value,code,name,startDate,endDate) => {
      dispatch(addDiscount(value,code,name,startDate,endDate))
    }
  }
}

export default connect(mapStateToProps,mapDispatchToProps)(AddDiscount);
