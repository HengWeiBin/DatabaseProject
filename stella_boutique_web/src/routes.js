import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import Newarrivals from './Newarrivals';
import Home from './Home';
import Onsale from './Onsale';

import Dresses from './Dresses';
import Jacket from './Jacket';
import Bottom from './Bottom';
import Tops from './Tops';
import Login from './Login';
import Register from './Register';
import ProductManage from './Seller/ProductManage';
import OrderManage from './Seller/OrderManage';
import MemberManage from './Seller/MemberManage';
import MyLike from './user/MyLike';
import MyOrder from './user/MyOrder';
import AddProduct from './Seller/AddProduct';
import AddDiscount from './Seller/AddDiscount';

class AllRoutes extends Component {

    render() {
        return (
            <div >
                <Switch>
                    <Route path="/" component={Home} exact={true}></Route>
                    <Route path="/Newarrivals" component={Newarrivals} exact={true}></Route>
                    <Route path="/Onsale" component={Onsale} exact={true}></Route>
                    <Route path="/Dresses" component={Dresses} exact={true}></Route>
                    <Route path="/Jacket" component={Jacket} exact={true}></Route>
                    <Route path="/Tops" component={Tops} exact={true}></Route>
                    <Route path="/Bottom" component={Bottom} exact={true}></Route>
                    <Route path="/Login" component={Login} exact={true}></Route>
                    <Route path="/Register" component={Register} exact={true}></Route>
                    <Route path="/ProductManage" component={ProductManage} exact={true}></Route>
                    <Route path="/OrderManage" component={OrderManage} exact={true}></Route>
                    <Route path="/MemberManage" component={MemberManage} exact={true}></Route>
                    <Route path="/MyLike" component={MyLike} exact={true}></Route>
                    <Route path="/MyOrder" component={MyOrder} exact={true}></Route>
                    <Route path="/AddProduct" component={AddProduct} exact={true}></Route>
                    <Route path="/AddDiscount" component={AddDiscount} exact={true}></Route>
                </Switch>
            </div>
        )
    }
}

export default AllRoutes
