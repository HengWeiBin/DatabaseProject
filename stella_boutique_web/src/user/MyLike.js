import React, { useState } from 'react';
import '../App.css';
import 'bootstrap/dist/css/bootstrap.css';
import AlbumJson from '../Album.json';
import { Nav,Navbar,Form,FormControl,Button } from 'react-bootstrap';
import { BrowserRouter} from 'react-router-dom';
import { connect } from 'react-redux';
import { getOrderList, removeLikeItem , getLikeItemList} from '../actions';
import { useHistory } from 'react-router-dom';
import ProductItem from '../ProductItem';

import { Container, Row, Col, Jumbotron, Card, CardImg, CardBody ,  CardTitle, CardSubtitle, CardText, Badge } from 'reactstrap';


function MyLike(props){
  const history = useHistory();
  const userID = useState(localStorage.getItem("userID"));

  function GoToMyLikes(){
    props.getLikeItemList(userID)
    console.log("item like"+ props.userMyLike)
    console.log("product list "+ props.ProductList)
    history.push("/MyLike")
  }
  function GoToHistory(){
    props.getOrderList(userID)
    history.push("/MyOrder")
  }
    return (
        <div>
            <div style={{margin:'10px' , display: 'flex',  justifyContent:'flex-end ', alignItems:'center'}}>
                <Form inline>
                    <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                    <Button variant="outline-dark">Search</Button>
                </Form>
            </div>
            <Row style={{margin:'10px 100px' , display: 'flex',  justifyContent:'flex-end ', alignItems:'center'}}>
            {console.log(props.ProductList)}
            {console.log(props.userMyLike)}
            {
              props.ProductList.map((item,key) => {
                return(
                  props.userMyLike.map((likeItem,key1) => {
                    if(item.itemID == likeItem){
                      return(
                        <ProductItem key={item.itemID} product={item}/>
                      )
                    }
                  })
                )
              })
            }
            </Row>
        </div>
    );
}
function mapStateToProps(state) {
  return {
    userMyLike: state.userMyLike,    
    ProductList: state.ProductList
  }
}
function mapDispatchToProps(dispatch) {
  return {
    getOrderList: (userID) => {
      dispatch(getOrderList(userID))
    },
    removeLikeItem: (userID,itemID) => {
      dispatch(removeLikeItem(userID,itemID))
    },
    getLikeItemList: (userID) => {
      dispatch(getLikeItemList(userID))
    }
  }
}
export default connect(mapStateToProps,mapDispatchToProps)(MyLike);