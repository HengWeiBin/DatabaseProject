import { Nav,Navbar,Button } from 'react-bootstrap';
import { makeStyles } from '@material-ui/core/styles';
import { connect } from 'react-redux';
import { BrowserRouter} from 'react-router-dom';
import React, { useState } from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { useHistory } from 'react-router-dom';
import Card from 'react-bootstrap/Card';


import { getOrderList , getLikeItemList, updateStatus} from '../actions';

import '../App.css';

import 'bootstrap/dist/css/bootstrap.min.css';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'Date', headerName: 'Date', width: 130 },
  { field: 'State', headerName: 'State', width: 130 },
  {
    field: 'Cost',
    headerName: 'Cost',
    type: 'number',
    width: 90,
  },
];

const useStyles = makeStyles({
  table: {
    margin:'100px',
    minWidth: 650,
    width:'80%'
  },
});

function MyOrder(props) {
  const classes = useStyles();
  const history = useHistory();
  const [userID,setUserID] = useState(localStorage.getItem("userID"));

  function GoToMyLikes(){
    props.getLikeItemList(userID)
    history.push("/MyLike")
  }
  function GoToHistory(){
    props.getOrderList(userID)
    history.push("/MyOrder")
  }

  function getstatus (status) {
    if (status == 0)
    { return "new order"}
    else if (status == 1) 
    { return "shipout" }
    else 
    { return "done" }
  }

  const processOrder = playload => {
    console.log("update order "+playload.orderID)
    props.updateStatus(playload.orderID,2)
    window.location.href = "/MyOrder"
  }

  const canProcess = playload => {
    console.log("Check Process "+playload.orderID)
    if(playload.status != 1)
      return true;
  }

  return (
    <React.Fragment>
      <main>
      <div style={{ height: 400, width: '90%' , margin: '60px'}}>
      <TableContainer component={Paper}>
      {/* <Table className={classes.table} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="left">No</TableCell>
            <TableCell>Date</TableCell>
            <TableCell align="right">Status</TableCell>
            <TableCell align="right">Total Price</TableCell>
          </TableRow>
        </TableHead>
        <TableBody> */}
          {props.userOrderList.map((order,index) => (
             <Card>
              <Card.Header className="p-2 col-example text-left" >
                <div className="d-flex justify-content-between">
                  <Card.Text className="p-2 col-example text-left" style={{ textAlign: "right" }}> Order : {order.orderDate.toString().substring(0,10)}</Card.Text>
                  <Card.Text className="p-2 col-example text-left" style={{ textAlign: "right" }}> Status : {getstatus(order.status)}</Card.Text>
                </div>
              </Card.Header>
          {order.itemList.map((item) => (
            <div>
              <Card.Body>
                <div className="d-flex justify-content-between">
                  {/* <Card.Img className="p-2 col-example text-left" variant="top" src={require("."+item.pictureURL)}></Card.Img> */}
                  <Card.Title className="p-2 col-example text-left">{item.name}</Card.Title>
                  <Card.Text className="p-2 col-example text-left" style={{ textAlign: "right" }}>
                  {item.price}NTD x {item.buyAmount}   = {item.buyAmount*item.price}
                  </Card.Text>
                </div>
              </Card.Body>
            </div>
              ))}
              {
                order.discountID == 1? null:
                props.userDiscountList.map((discount)=>{
                  if(order.discountID == discount.discountID){
                    return(
                    <div className="d-flex justify-content-between">
                      <Card.Title className="p-2 col-example text-left">{discount.discountName}</Card.Title>
                      <Card.Text className="p-2 col-example text-left" style={{ textAlign: "right" }}>
                      - {(100-(discount.value*100))}%OFF
                      </Card.Text>
                    </div>
                    )}
                })
              }
              <div className="d-flex justify-content-between">
                <Card.Title className="p-2 col-example text-left">Total</Card.Title>
                <Card.Text className="p-2 col-example text-left" style={{ textAlign: "right" }}>
                {order.totalPrice}
                </Card.Text>
              </div>
              {!canProcess(order)?
                <Button onClick={() => processOrder(order)} variant="primary">取件</Button> :
                null
              }
          </Card>

            // <TableRow align="left" key={index}>
            //   <TableCell component="th" scope="row">
            //     {index+1}
            //   </TableCell>
            //   <TableCell>{order.orderDate.toString().substring(0,10)}</TableCell>
            //   <TableCell align="right">{getstatus(order.status)}</TableCell>
            //   <TableCell align="right">{order.totalPrice}</TableCell>
            //   <TableCell align="right">
            //     <Button onClick={() => processOrder(order)} disabled={canProcess(order)}>取件</Button>
            //   </TableCell>
            // </TableRow>
          ))}
        {/* </TableBody>
      </Table> */}
    </TableContainer>
      </div>
      </main>
    </React.Fragment>
  );
}
function mapStateToProps(state) {
  return {
    userOrderList: state.userOrderList,
    userMyLike: state.userMyLike,
    userDiscountList: state.userDiscountList
  }
}
function mapDispatchToProps(dispatch) {
  return {
    getOrderList: (userID) => {
      dispatch(getOrderList(userID))
    },
    getLikeItemList: (userID) => {
      dispatch(getLikeItemList(userID))
    },
    updateStatus: (orderID,status) => {
      dispatch(updateStatus(orderID,status))
    }
  }
}
export default connect(mapStateToProps,mapDispatchToProps)(MyOrder);