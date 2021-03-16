import React,{Component,useState} from 'react';
import { connect } from 'react-redux';
import AllRoutes from './routes'
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import MyNavbar from './MyNavbar';
import SellerNavBar from './Seller/SellerNavBar'
import { ModeComment } from '@material-ui/icons';
import { enterWeb ,getLikeItemList ,getOrderList,enterAdmin } from './actions';
import '@devexpress/dx-react-chart-bootstrap4/dist/dx-react-chart-bootstrap4.css';


class App extends Component {
constructor(props){
  super(props)
  this.state = {
    admin:false
  }
}
componentDidMount(){
  const userID = localStorage.getItem("userID");
  if(userID == "admin"){
    this.props.enterAdmin();
    this.setState({
      admin:true
    })
  }else{
    if(userID){
      this.props.getLikeItemList(userID)
      this.props.getOrderList(userID)
    }
    this.props.enterWeb();
  }
 

}
 render(){ 
  return (
    <div>
      {console.log(this.state.admin)}
    {this.state.admin?
      <SellerNavBar/> : <MyNavbar />
    }
    <AllRoutes />
    </div>
    );
  }
}

function mapDispatchToProps(dispatch) {
  return {
    enterWeb: () => dispatch(enterWeb()),
    enterAdmin: () => dispatch(enterAdmin()),
    getLikeItemList: (userID) => {
      dispatch(getLikeItemList(userID))
    },
    getOrderList: (userID) => {
      dispatch(getOrderList(userID))
    },
  }
}

export default connect(null,mapDispatchToProps)(App);