import React,{ useState,useEffect } from 'react';
import Form from "react-bootstrap/Form";
import { Nav ,Navbar ,Button } from 'react-bootstrap';
import { makeStyles } from '@material-ui/core/styles';
import './App.css';
import {  Modal, ModalHeader, ModalBody, ModalFooter, Table, Alert} from 'reactstrap';
import { connect } from 'react-redux';
import { setUser , checkoutOrder , getOrderList , getLikeItemList} from './actions';
import { useHistory } from 'react-router-dom';
import { TramRounded } from '@material-ui/icons';

const useStyles = makeStyles((theme) => ({
    icon: {
      marginRight: theme.spacing(2),
    },
    navButtons: {
      fontFamily: 'Bebas Neue',
      '&:hover': {
        color:'#c26d5c'
     },
    },
    footer: {
      backgroundColor: theme.palette.background.paper,
      padding: theme.spacing(6),
    },
    iconColor: {
      backgroundColor:'#9e7d7a',
    }
  }));
    
function MyNavbar(props) {
    var totalPrice = 0;
    
    const [total,setTotal] = useState(0);
    const [discount, setDiscount] = useState("");
    const [discountID,setDiscountID] = useState(0);
    const [userID,setUserID] = useState(localStorage.getItem("userID"));
    const [username,setUername] = useState(localStorage.getItem("username"));
    const classes = useStyles();
    var cartItems = localStorage.getItem('cart') ? JSON.parse(localStorage.getItem('cart')) : [];
    const [profileOpen,setProfileClose] = useState(false); 
    useState(() => {
      props.setUser(username,userID);
    });

    function handleLogout() {
      localStorage.clear();
      window.location.href = '/';
    }

    const history = useHistory();

    const goToNewArrival = () => {
      setProfileClose(false)
      history.push("/Newarrivals")
    };
    const goToOnSale = () => {
      setProfileClose(false)
      history.push("/Onsale")
    };
    const goToTops = () => {
      setProfileClose(false)
      history.push("/Tops")
    };
    const goToBottoms = () => {      
      setProfileClose(false)
      history.push("/Bottom")
    };
    const goToOutwear = () => {
      setProfileClose(false)
      history.push("/Jacket")
    };
    const goToDresses = () => {
      setProfileClose(false)
      history.push("/Dresses")
    };
    const goToProfile = () => {
      setProfileClose(!profileOpen)
      if(profileOpen){
        history.push("/")
      }else{
        console.log("getting order");
        props.getOrderList(userID);
        props.getLikeItemList(userID);
        history.push("/MyOrder")
      }
    };
    const GoToMyLikes = () => {
      console.log("item like"+ props.userMyLike)
      console.log("product list "+ props.ProductList)
      history.push("/MyLike")
    }
    const GoToHistory = () => {
      history.push("/MyOrder")
    }

    const [cartOpen, setcartOpenOpen] = useState(false);
    const handleCartOpen = () => {
      setcartOpenOpen(!cartOpen)
    }
    const removeProduct = payload => {
      console.log(cartItems);
      cartItems.pop(payload.itemID);
      localStorage.setItem("cart", JSON.stringify(cartItems));
      handleCartOpen();
      console.log('removeProduct' +payload.itemID );
    }

    const clearCart = () => {
        cartItems = [0];
        localStorage.setItem("cart", JSON.stringify(cartItems));
        handleCartOpen();
        console.log('clearCart' );
    }

    const handleCheckout = () => {
      cartItems = JSON.parse(localStorage.getItem('cart'));
      props.checkoutOrder(cartItems,discountID);
      clearCart();
      //alert to tell user checkout sucess
      console.log('handleCheckout' );
    }

    const getDiscount = () => {
      console.log(discount)
      var found = false;
      var value = 0;
      console.log(props.userDiscountList);
      props.userDiscountList.map((disc)=>{
        console.log(disc.code)
        console.log(disc.code == discount)
        if(disc.code == discount){
          value = disc.value
          setDiscountID(disc.discountID);
          found=true;
        }
      })
      if(found){
        setTotal(totalPrice*=value)
        console.log(total)
      }else{
        alert("voucher is unavailable")
      }
    }
    return (
      <React.Fragment>
        <Navbar className="brand-bar" style={{justifyContent:'space-between'}}>
          <Navbar.Brand href="/">Stella Boutique</Navbar.Brand>
            <div>
              <p>Welome{userID == null?null:", "+username} </p> 
            </div>
            {userID == null? 
            <div>
              <Button href="/Login" className={classes.navButtons} variant="contained" color="primary">login</Button>
              <Button href="/Register" className={classes.navButtons} variant="contained" color="primary">register</Button>
            </div> :
            <div>
              <Button color="secondary" onClick={handleCartOpen}>購物車</Button>
              <Button className={classes.navButtons} variant="contained" color="primary" onClick={goToProfile}>Profile</Button>
              <Button href="/Login" className={classes.navButtons} variant="contained" color="primary" onClick={handleLogout}>logout</Button>              
            </div>
            }
        </Navbar>
        <Navbar bg="dark" variant="dark" className="menu-bar" expand="lg">
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link onClick={goToNewArrival}>NEW ARRIVALS</Nav.Link>
              <Nav.Link onClick={goToOnSale}>ON SALE</Nav.Link>
              <Nav.Link onClick={goToTops}>TOPS</Nav.Link>
              <Nav.Link onClick={goToBottoms}>BOTTOMS</Nav.Link>
              <Nav.Link onClick={goToOutwear}>OUTERWEAR</Nav.Link>
              <Nav.Link onClick={goToDresses}>DRESSES & JUMPSUITS</Nav.Link>
            </Nav>
            
            {
              profileOpen?
              <Nav className="mr-right">
                <Nav.Link onClick = {GoToMyLikes}>LIKE</Nav.Link>
                <Nav.Link onClick={GoToHistory}>ORDER</Nav.Link>
              </Nav>
              :
              null
            }
            
          </Navbar.Collapse>
        </Navbar>

        <Modal isOpen={cartOpen} toggle={handleCartOpen}>
          <ModalHeader toggle={handleCartOpen}>購物車</ModalHeader>
          <ModalBody>
            <Table>
              <thead>
                <tr>
                    <th>#</th>
                    <th>品項</th>
                    <th>價格</th>
                    <th>     </th>
                </tr>
              </thead>
              <tbody>
              {
                cartItems.map((cartItem,key1)=>{
                  return(
                  props.ProductList.map((item,key) => {
                    if(cartItem.toString() == item.itemID.toString()){
                      { totalPrice += item.price;  }
                      return(
                        <tr>
                          <th scope="row">{1}</th>
                          <td>{item.name}</td>
                          <td>{item.price}</td>
                          <td><button onClick={() => removeProduct(item)}>-</button></td>
                        </tr>
                        
                      )
                    }
                })
                )
              })
              } 
              </tbody>
            </Table>
            <div style={{display:"inline"}}>
              <label>請輸入折扣碼:</label>
              <input
                  autoFocus
                  type="text"
                  value={discount}
                  onChange={(e) => setDiscount(e.target.value)}
                  style={{display:"inline",width:"50%", margin:"10px"}}
              />
              <Button style={{display:"inline",margin:"10px"}} className="LoginBtn" size="md" variant="outline-secondary" onClick={getDiscount}>
                輸入
              </Button>
            </div>
            <Alert color="success" className="text-right">
                總價：
                {total == 0? totalPrice:total}
                元
              </Alert>
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={handleCheckout}>結帳</Button>
            <Button color="secondary" onClick={clearCart}>取消</Button>
          </ModalFooter>
        </Modal>
      </React.Fragment>
    );
  }

  function mapStateToProps(state) {
    return {
      ProductList: state.ProductList,
      LoginUser: state.LoginUser,    
      userMyLike: state.userMyLike,
      userDiscountList : state.userDiscountList
    }
  }
  
  function mapDispatchToProps(dispatch) {
    return {
      setUser: (username,userID) => {
        dispatch(setUser(username,userID))
      },
      checkoutOrder: (orderList,discountID) => {
        dispatch(checkoutOrder(orderList,discountID))
      },
      getOrderList: (userID) => {
        dispatch(getOrderList(userID))
      },
      getLikeItemList: (userID) => {
        dispatch(getLikeItemList(userID))
      }
    }
  }
  export default connect(mapStateToProps,mapDispatchToProps)(MyNavbar);