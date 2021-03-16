import React,{ useState,useEffect } from 'react';
import { Nav ,Navbar ,Button } from 'react-bootstrap';
import { makeStyles } from '@material-ui/core/styles';
import '../App.css';
import {  Modal, ModalHeader, ModalBody, ModalFooter, Table, Alert} from 'reactstrap';
import { connect } from 'react-redux';
import { setUser , checkoutOrder , getOrderList , getLikeItemList} from '../actions';
import { useHistory } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    icon: {
      marginRight: theme.spacing(2),
    },
    homecoverdiv: {
      display:'flex',
      alignItems:'center',
      justifyContent:'center',
      width:'100%',
    },
    homecover: {
      width:'100%',
    },
    heroContent: {
      backgroundColor: theme.palette.background.paper,
      padding: theme.spacing(8, 0, 6),
      backgroundColor: '#f7ebea',
    },
    navButtons: {
      fontFamily: 'Bebas Neue',
      '&:hover': {
        color:'#c26d5c'
     },
    },
    cardGrid: {
      paddingTop: theme.spacing(8),
      paddingBottom: theme.spacing(8),
    },
    card: {
      height: '100%',
      display: 'flex',
      flexDirection: 'column',
    },
    cardMedia: {
      paddingTop: '56.25%', // 16:9
    },
    cardContent: {
      flexGrow: 1,
    },
    footer: {
      backgroundColor: theme.palette.background.paper,
      padding: theme.spacing(6),
    },
    iconColor: {
      backgroundColor:'#9e7d7a',
    }
  }));
    
function SellerNavBar(props) {
    var totalPrice = 0;
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

    const goToProduct = () => {
      setProfileClose(false)
      history.push("/ProductManage")
    };
    const goToOrder = () => {
      setProfileClose(false)
      history.push("/OrderManage")
    };
    const goToMember = () => {
      setProfileClose(false)
      history.push("/MemberManage")
    };

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
      props.checkoutOrder(cartItems);
      clearCart();
      //alert to tell user checkout sucess
      console.log('handleCheckout' );
    }
    function handleLogout() {
        localStorage.clear();
        window.location.href = '/';
      }
    return (
      <React.Fragment>
        <Navbar bg="dark" variant="dark" className="menu-bar" expand="lg">
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link href="/ProductManage">PRODUCT</Nav.Link>
              <Nav.Link href="/OrderManage">ORDER</Nav.Link>
              <Nav.Link href="/MemberManage">MEMBER</Nav.Link>
              <Nav.Link href="/AddProduct">ADD PRODUCT</Nav.Link>
              <Nav.Link href="/AddDiscount">ADD DISCOUNT</Nav.Link>
            </Nav>
            <Nav className="mr-right">
              <Nav.Link onClick={handleLogout}>LOGOUT</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </React.Fragment>
    );
  }

  function mapStateToProps(state) {
    return {
      ProductList: state.ProductList,
      LoginUser: state.LoginUser,    
      userMyLike: state.userMyLike
    }
  }
  
  function mapDispatchToProps(dispatch) {
    return {
      setUser: (username,userID) => {
        dispatch(setUser(username,userID))
      },
    }
  }
  export default connect(mapStateToProps,mapDispatchToProps)(SellerNavBar);