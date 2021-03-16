export function loginUser(username, password, userID) {
    return {
        type: "LOGIN_USER",
        username: username,
        password: password,
        userID: userID,
        setUser:(username, userID, dispatch) => dispatch(setUser(username, userID)),
        setLikeItemList:(userMyLike, dispatch) => dispatch(setLikeItemList(userMyLike)),
        setOrderList:(userOrderList, dispatch) => dispatch(setOrderList(userOrderList))
    }
}

export function setUser(username, userID) {
    return {
        type: "SET_USER",
        username: username,
        userID: userID
    }
}

export function registerUser(username, password, fullname, birthday, address, phoneNumber, email) {
    return {
        type: "REGISTER_USER",
        username: username,
        password: password,
        fullname: fullname,
        birthday: birthday,
        address: address,
        phoneNumber: phoneNumber,
        email: email
    }
}

export function enterWeb(){
    return {
        type: "ENTER_WEB",
        setProductList:(productList, dispatch) => dispatch(setProductList(productList)),
        setUserDiscountList:(userDiscountList,dispatch)=> dispatch(setUserDiscountList(userDiscountList)),

    }
}
export function getOrderList(userID){
    return {
        type: "GET_ORDER_LIST",
        userID: userID,
        setOrderList:(userOrderList, dispatch) => dispatch(setOrderList(userOrderList))
    }
}

export function setProductList(productList) {
    return {
        type: "SET_PRODUCT_LIST",
        productList: productList
    }
}

export function checkoutOrder(orderList,discountID){
    return{
        type: "ADD_ORDER",
        orderList: orderList,
        discountID: discountID
    }
}

export function setOrderList(userOrderList){
    return{
        type: "SET_ORDER_LIST",
        userOrderList: userOrderList
    }
}

export function addLikeItem(userID , itemID){
    return{
        type: "ADD_LIKE_ITEM",
        userID: userID,
        itemID: itemID
    }
}

export function removeLikeItem(userID , itemID){
    return{
        type: "REMOVE_LIKE_ITEM",
        userID: userID,
        itemID: itemID
    }
}

export function getLikeItemList(userID ){
    return{
        type: "GET_LIKE_ITEM",
        userID: userID,        
        setLikeItemList:(userMyLike, dispatch) => dispatch(setLikeItemList(userMyLike))
    }
}
export function setLikeItemList(userMyLike){
    return{
        type: "SET_MY_LIKE_LIST",
        userMyLike: userMyLike
    }
}
export function enterAdmin(){
    return{
        type: "ENTER_ADMIN",    
        setSellerUserList:(sellerUser, dispatch) => dispatch(setSellerUserList(sellerUser)),
        setSellerProductList:(sellerProduct, dispatch) => dispatch(setSellerProductList(sellerProduct)),
        setSellerOrderList:(sellerOrder, dispatch) => dispatch(setSellerOrderList(sellerOrder)),
        setSellerDiscountList:(SellerDiscountList,dispatch)=> dispatch(setSellerDiscountList(SellerDiscountList))

    }
}
export function setSellerUserList(sellerUser){
    return{
        type: "SET_SELLER_USER",
        sellerUser: sellerUser
    }
}
export function setSellerProductList(sellerProduct){
    return{
        type: "SET_SELLER_PRODUCT",
        sellerProduct: sellerProduct
    }
}
export function setSellerOrderList(sellerOrder){
    return{
        type: "SET_SELLER_ORDER",
        sellerOrder: sellerOrder
    }
}
export function updateStatus(orderID , status){
    return{
        type: "UPDATE_STATUS",
        orderID: orderID,
        status: status
    }
}
export function editProduct(itemID,name,price,description){
    return{
        type: "EDIT_PRODUCT",
        itemID: itemID,
        name: name,
        price: price,
        description: description
    }
}
export function removeProduct(itemID){
    return{
        type: "REMOVE_PRODUCT",
        itemID: itemID
    }
}
export function addProduct(name,quantity,category,size,price,description,pictureURL){
    return{
        type: "ADD_PRODUCT",
        name: name,
        quantity: quantity,
        category: category,
        size: size,
        price: price,
        description: description,
        pictureURL: pictureURL
    }
}
export function addDiscount(value,code,name,startDate,endDate){
    return{
        type: "ADD_DISCOUNT",
        value: value,
        code: code,
        name: name,
        startDate: startDate,
        endDate: endDate
    }
}
export function setUserDiscountList(userDiscountList){
    return{
        type: "SET_DISCOUNT_LIST",
        userDiscountList: userDiscountList
    }
}
export function setSellerDiscountList(sellerDiscountList){
    return{
        type: "SET_SELLER_DISCOUNT_LIST",
        sellerDiscountList: sellerDiscountList
    }
}
