import axios from 'axios';
import { useDispatch } from 'react-redux';


// const API_HOST = process.env.REACT_APP_HOST;
const API_HOST = "http://localhost:8080/api";

// const dispatch = useDispatch();

function getHeaders(token) {
    return ({
        'Content-Type': 'application/json',
        'Authorization': token
    })
}

function getBody(username, password,userID) {
    return ({
        username: username,
        password: password,
        userID: userID
    })
}

function registerData(username, password, fullname, birthday, address, phoneNumber, email,userID) {
    return({
        username: username,
        password: password,
        fullname: fullname,
        birthday: birthday,
        address: address,
        phoneNumber: phoneNumber,
        email: email,
        userID: userID
    })
}

const myMiddleware = store => next => action => {
    if(action.type === "LOGIN_USER") {
        const headers = getHeaders(action.token);
        const body = getBody(action.username, action.password);
        // console.log(body);
        axios.post(API_HOST + '/guest/Login', body, {headers: headers})
        .then(response => {
            action.userID =  response.data.userID;
            action.setUser(action.username,response.data.userID,store.dispatch);
            if(response.data.userID!=0 && response.data.userID!= null ){
                localStorage.setItem("username", action.username);
                localStorage.setItem("userID", response.data.userID);            
                localStorage.setItem("cart",JSON.stringify([0]));            
            }else{  
                alert("Invalid username or password")
            }
        })
        .catch(err => {
            console.log(err)
            alert("User Authentication Failed!")
        });
    } else if(action.type === "REGISTER_USER") {
        const headers = getHeaders(action.token)
        const body = registerData(
            action.username, 
            action.password, 
            action.fullname, 
            action.birthday, 
            action.address, 
            action.phoneNumber, 
            action.email
            )
        // console.log(body)
        axios.post(API_HOST + '/Register', body, {headers: headers})
        .then(response => {
            action.registerUser(
                action.username,
                action.password,
                action.fullname, 
                action.birthday, 
                action.address, 
                action.phoneNumber, 
                action.email,
                store.dispatch
                )
        })
        .catch(err => {
            console.log(err)
            alert("User Register Failed!")
        })
    } else if(action.type === "ENTER_WEB"){
        const headers = getHeaders(action.token);
        const body = {
            productList: action.productList
        }
        console.log("getting product");
        axios.get(API_HOST + '/guest/product', body, {headers: headers})
        .then(response => {
            action.setProductList(response.data.productList,store.dispatch);
            // console.log("middleware " + response.data.productList)
        })
        .catch(err => {
            console.log(err)
            alert("Entering Web Failed!")
        });

        console.log("middleware get discount");
        axios.get(API_HOST + '/guest/discount', body, {headers: headers})
        .then(response => {
            action.setUserDiscountList(response.data.discountList,store.dispatch);
            console.log(response.data.discountList)
        })
        .catch(err => {
            console.log(err)
            alert("Get Discount Failed!")
        });

    } else if(action.type === "ADD_ORDER"){
        const headers = getHeaders(action.token);
        const body = {
            itemList: action.orderList,
            userID : localStorage.getItem("userID"),
            discountID: action.discountID
        }
        console.log("middleware add order");
        console.log(body)
        axios.post(API_HOST + '/user/create/order', body, {headers: headers})
        .then(response => {
            alert(`已從您的信用卡中扣除！`);
        })
        .catch(err => {
            console.log(err)
            alert("Creating Order Failed!")
        });
    } else if(action.type === "GET_ORDER_LIST"){
        const headers = getHeaders(action.token);
        const body = {
            userID: action.userID
        }
        console.log("getting order history");
        console.log(body)

        axios.post(API_HOST + '/user/history', body, {headers: headers})
        .then(response => {
            console.log("return")
            console.log(response.data.orderList)
            action.setOrderList(response.data.orderList,store.dispatch);
        })
        .catch(err => {
            console.log(err)
            alert("Getting User Profile Failed!")
        });
    }else if(action.type === "ADD_LIKE_ITEM"){
        const headers = getHeaders(action.token);
        const body = {
            userID : action.userID,
            itemID : action.itemID
        }
        console.log("middleware add like");
        console.log(body);
        axios.post(API_HOST + '/user/add/like', body, {headers: headers})
        .then(response => {
            alert(`已加入到您的喜歡商品中！`);
        })
        .catch(err => {
            console.log(err)
            alert("Like Failed!")
        });
    }else if(action.type === "REMOVE_LIKE_ITEM"){
        const headers = getHeaders(action.token);
        const body = {
            userID : action.userID,
            itemID : action.itemID
        }
        console.log("middleware remove like");
        console.log(body);
        axios.post(API_HOST + '/user/remove/like', body, {headers: headers})
        .then(response => {
            console.log("middleware " + body.itemID)
            console.log("middleware " + body.userID)
        })
        .catch(err => {
            console.log(err)
            alert("Unlike Failed!")
        });
    }else if(action.type === "GET_LIKE_ITEM"){
        const headers = getHeaders(action.token);
        const body = {
            userID : localStorage.getItem("userID"),
        }
        console.log("middleware get like");
        console.log("middleware " + body.userID)
        axios.post(API_HOST + '/user/get/like', body, {headers: headers})
        .then(response => {
            action.setLikeItemList(response.data.likeList,store.dispatch);
            console.log("like list " +response.data.likeList )
        })
        .catch(err => {
            console.log(err)
            alert("Get Like List Failed!")
        });
    }else if(action.type === "ENTER_ADMIN"){
        const headers = getHeaders(action.token);
        const body = {
        }
        console.log("prepare admin");

        axios.get(API_HOST + '/seller/get/order', body, {headers: headers})
        .then(response => {
            action.setSellerOrderList(response.data.orderList,store.dispatch);
            // console.log("middleware order" + response.data.orderList)
        })
        .catch(err => {
            console.log(err)
            alert("Entering Web Failed!")
        });

        axios.get(API_HOST + '/seller/get/user', body, {headers: headers})
        .then(response => {
            action.setSellerUserList(response.data.userList,store.dispatch);
            // console.log(response.data.userList)
        })
        .catch(err => {
            console.log(err)
            alert("Entering Web Failed!")
        });

        axios.get(API_HOST + '/seller/get/product', body, {headers: headers})
        .then(response => {
            action.setSellerProductList(response.data.productList,store.dispatch);
            // console.log("middleware product " + response.data.productList)
        })
        .catch(err => {
            console.log(err)
            alert("Entering Web Failed!")
        });

        axios.get(API_HOST + '/guest/seller/discount', body, {headers: headers})
        .then(response => {
            action.setSellerDiscountList(response.data.discountList,store.dispatch);
            console.log("discount list ")
            console.log(response.data.discountList )
        })
        .catch(err => {
            console.log(err)
            alert("Get Discount Failed!")
        });
    }else if(action.type === "UPDATE_STATUS"){
        const headers = getHeaders(action.token);
        const body = {
            orderID : action.orderID,
            status : action.status
        }
        console.log("update order status");
        axios.post(API_HOST + '/seller/update/order', body, {headers: headers})
        .then(response => {
            console.log("have been update");
        })
        .catch(err => {
            console.log(err)
            alert("Changing Status Failed!")
        });
    }else if(action.type === "EDIT_PRODUCT"){
        const headers = getHeaders(action.token);
        const body = {
            itemID: action.itemID,
            name: action.name,
            price: action.price,
            description: action.description
        }
        console.log(body);
        console.log("update product");
        axios.post(API_HOST + '/seller/update/product', body, {headers: headers})
        .then(response => {
            console.log("product have been update");
        })
        .catch(err => {
            console.log(err)
            alert("Edit Product Failed!")
        });
    }else if(action.type === "REMOVE_PRODUCT"){
        const headers = getHeaders(action.token);
        const body = {
            itemID: action.itemID
        }
        console.log(body);
        console.log("remove product");
        axios.post(API_HOST + '/seller/remove/product', body, {headers: headers})
        .then(response => {
            console.log("product have been remove");
        })
        .catch(err => {
            console.log(err)
            alert("Remove Product Failed!")
        });
    }else if(action.type === "ADD_PRODUCT"){
        const headers = getHeaders(action.token);
        const body = { 
            name: action.name,
            quantity: action.quantity,
            category: action.category,
            size: action.size,
            price: action.price,
            description: action.description,
            pictureURL: action.pictureURL
        }
        console.log(body);
        console.log("adding product");
        axios.post(API_HOST + '/seller/add/product', body, {headers: headers})
        .then(response => {
            console.log("product have been add");
            alert("Add Product Success!")
        })
        .catch(err => {
            console.log(err)
            alert("Add Product Failed!")
        });
    }else if(action.type === "ADD_DISCOUNT"){
        const headers = getHeaders(action.token);
        const body = { 
            value: action.value,
            code: action.code,
            name: action.name,
            startDate: action.startDate,
            endDate: action.endDate
        }
        console.log(body);
        console.log("adding Discount");
        axios.post(API_HOST + '/seller/add/discount', body, {headers: headers})
        .then(response => {
            console.log("Discount have been add");
            alert("Add Discount Success!")
        })
        .catch(err => {
            console.log(err)
            alert("Add Discount Failed!")
        });
    }else {
        return next(action)
    }


}

export default myMiddleware




