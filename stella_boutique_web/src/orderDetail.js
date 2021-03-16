import React, { useState} from 'react';
import {Col, Card, CardImg, CardBody ,  CardTitle, CardSubtitle, CardText, Badge } from 'reactstrap';
import { Button } from 'react-bootstrap';
import IconButton from '@material-ui/core/IconButton';
import FavoriteBorderIcon from '@material-ui/icons/FavoriteBorder';
import FavoriteIcon from '@material-ui/icons/Favorite';
import { connect } from 'react-redux';
import { updateStatus} from './actions';
import './ProductItem.css';


function OrderDetail(props){
    var cartItems = localStorage.getItem('cart') ? JSON.parse(localStorage.getItem('cart')) : [];
    var like = false;
    var likeColor = "secondary";
    const [userID,setUserID] = useState(localStorage.getItem("userID"));
    
    
  function getstatus (status) {
    if (status == 0)
    { return "new order"}
    else if (status == 1) 
    { return "shipout" }
    else 
    { return "done" }
  }


    const addProduct = payload => {
        cartItems = JSON.parse(localStorage.getItem('cart'))
        cartItems.push(payload.itemID);
        localStorage.setItem("cart", JSON.stringify(cartItems));
        console.log('addProduct' +payload.itemID );
        alert(payload.name+"已加到購物車~")
    }

    const getLike = () => {
        console.log('item id ' + props.product.itemID );
        props.userMyLike.map((likeItem)=>{
            console.log('like id ' + likeItem );
            if(props.product.itemID == likeItem){
                console.log("true")
                like = true;
            }else{
                like = false;
            }
        })
    }

    const addLike = payload => {
        if(like == false)
        {   
            like = true; 
            props.addLikeItem(userID,payload.itemID);
            likeColor = "secondary"
        }
        else
        {
            like = false;
            props.removeLikeItem(userID,payload.itemID);
            likeColor = "default"
        } 
        console.log(like);
        console.log(likeColor);
    }
    
    return ( 
        <div>
            <Card>
            <Card.Header>Featured</Card.Header>
            <Card.Body>
                <Card.Title>Special title treatment</Card.Title>
                <Card.Text>
                With supporting text below as a natural lead-in to additional content.
                </Card.Text>
                <Button variant="primary">Go somewhere</Button>
            </Card.Body>
            </Card>
        </div>
     );
}
function mapStateToProps(state) {
    return {
      sellerOrder: state.sellerOrder
    }
  }
  function mapDispatchToProps(dispatch) {
    return {
      updateStatus: (orderID, status) => {
        dispatch(updateStatus(orderID, status))
      }
    }
  }
  export default connect(mapStateToProps,mapDispatchToProps)(OrderDetail);