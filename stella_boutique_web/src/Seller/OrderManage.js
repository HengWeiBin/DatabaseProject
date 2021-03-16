import { Nav,Navbar,NavDropdown,Form,FormControl,Button } from 'react-bootstrap';
import { makeStyles } from '@material-ui/core/styles';
import Card from 'react-bootstrap/Card';
import { connect } from 'react-redux';
import { ArgumentScale, Animation } from '@devexpress/dx-react-chart';
import { scalePoint } from 'd3-scale';
import {
  Chart,
  BarSeries,
  Title,
  ArgumentAxis,
  ValueAxis,
} from '@devexpress/dx-react-chart-material-ui';


import * as React from 'react';

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { useHistory } from 'react-router-dom';
import { getOrderList , updateStatus} from '../actions';

import '../App.css';

import 'bootstrap/dist/css/bootstrap.min.css';

const useStyles = makeStyles({
  table: {
    margin:'100px',
    minWidth: 650,
    width:'80%'
  },
});



function OrderManage(props) {
  var sale2020 = 0;
  var sale2021 = 0;
  var y = 0;
  
  const classes = useStyles();
  const history = useHistory();

  function getstatus (status) {
    if (status == 0)
    { return "new order"}
    else if (status == 1) 
    { return "shipout" }
    else 
    { return "done" }
  }

  function getsale (year,sale,order) {
    console.log(order.itemList)
    y = parseInt(year) - 2000
    if (y == 20)
    { sale2020 += sale }
    else if (y == 21) 
    { sale2021 += sale }
    else 
    { }

    return sale

   
  }

  const processOrder = playload => {
    console.log("update order "+playload.orderID)
    props.updateStatus(playload.orderID,1)
    window.location.href = "/OrderManage"
  }

  const canProcess = playload => {
    console.log("Check Process "+playload.orderID)
    if(playload.status != 0)
      return true;
  }
  console.log("----------")
  console.log(sale2020)
  var data = [
    
  ];

  function getURL(arg){
    var url = "./." + arg
    let URL = url
    const uurl = "./." + arg
    try{
      console.log("Try 1")
      console.log(url)
      return require(url)
    }catch(error){
      try{
        console.log("Try 2")
        console.log(URL)
        return require(URL)
      }catch(error){
        try{
          console.log("Try 3")
          console.log("" + url)
          return require("" + url)
        }catch(error){
          try{
            console.log("Try 4")
            console.log("" + URL)
            return require("" + URL)
          }catch(error){
            try{
              console.log("Try 5")
              let required = require(url)
              return required
            }catch(error){
              try{
                console.log("Try 6")
                console.log(url.toString())
                return require(url.toString())
              }catch(error){
                try{
                  console.log("Try 7")
                  console.log(String(url))
                  return require(String(url))
                }catch(error){
                  try{
                    console.log("Try 8")
                    console.log(new String(url))
                    return require(new String(url))
                  }catch(error){
                    try{
                      console.log("Try 9")
                      console.log((String(url)).raw())
                      return require((String(url)).raw())
                    }catch(error){
                      try{
                        console.log("Try 10")
                        console.log(uurl)
                        return require(uurl)
                      }catch(error){
                        console.log("Try 11")
                        console.log("./../img/clothes/Jacket/JolieJeansJacketInNude.jpg")
                        return require("./../img/clothes/Jacket/JolieJeansJacketInNude.jpg")
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  return (
    
    
    <React.Fragment>
      <main>
        <div style={{ height: 400, width: '90%' , margin: '60px'}}>
          <TableContainer component={Paper}>
            {props.sellerOrder.map((order,index) => (
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
                      <Card.Img className="p-2 col-example text-left" variant="top" src= {getURL(item.pictureURL)} ></Card.Img>
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
                  props.sellerDiscountList.map((discount)=>{
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
                      {getsale(order.orderDate.toString().substring(0,4),order.totalPrice,order)}
                      </Card.Text>
                    </div>
                
                 {!canProcess(order)?
                    <Button onClick={() => processOrder(order)} variant="primary">出貨</Button> :
                    null
                  }
              </Card>
                ))}
            <Chart
              data={data= [
                { year: '2020', sale: sale2020 },
                { year: '2021', sale: sale2021 },
              ]}
              style={{margin:"100px 500px"}}
            >
              <ArgumentAxis />
              <ValueAxis max={7} />

              <BarSeries
                valueField="sale"
                argumentField="year"
              />
              <Title text="銷售報表" />
              <Animation />
            </Chart>
          </TableContainer>
        </div>
      </main>
    </React.Fragment>
  );
}
function mapStateToProps(state) {
  return {
    sellerOrder: state.sellerOrder,
    sellerDiscountList: state.sellerDiscountList
 
  }
}
function mapDispatchToProps(dispatch) {
  return {
    getOrderList: (userID) => {
      dispatch(getOrderList(userID))
    },
    updateStatus: (orderID, status) => {
      dispatch(updateStatus(orderID, status))
    }
  }
}
export default connect(mapStateToProps,mapDispatchToProps)(OrderManage);